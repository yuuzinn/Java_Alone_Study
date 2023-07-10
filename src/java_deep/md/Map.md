## Map

### HashMap 과 HashTable의 차이점은 무엇인가 ?

둘의 차이점에서 핵심은 동기화의 지원 유무이다. HashMap의 경우 동기화를 지원하지 않으며, 
HashTable의 경우 동기화를 지원한다.

HashTable의 경우, 모든 메서드에 동기화를 지원하지만 HashMap에 비해 속도면에선 느린 편이다. 그리고 Iterator 중에
데이터 변경이 일어날 경우 Exception이 일어나게 된다. Key, Value에서 null을 허용하지 않는다는 점이 있다.

HashMap의 경우, 동기화를 지원하지 않는다. 따라서 상대적으로 빠르며 Iterator 중에 데이터 변경도 가능하며, Key, Value에서도 null이 허용된다.


### Thread-safety인 Map을 선택한다면 ?

ConcurrentHashMap이 대표적이다. Java에서 제공하는 Thread-safety한 Map 구현체이다.
내부적으로 세분화된 락(split-locking) 기술을 사용해 동시성을 지원해준다. 동시 읽기(read) 연산에 대해서는 lock을 사용하지 않아
읽기 성능이 우수하다. (HashTable은 메서드마다 동기화를 지원하기에 read연산도 느리다.)

### 싱글 Thread, 멀티 Thread 환경에서 적합한 Map은 어떤 것인가 ?

- 싱글 스레드 환경 : HashMap이다. 일반적으로 가장 빠르고 효율적인 선택이다. 동기화된 메서드나 Lock이 없기에 동기화 오버헤드가 없으며, 단일 스레드로부터 안전하게 액세스할 수 있습니다.
그러나 멀티스레드에서 동시에 액세스할 경우 동기화 메서드를 지원하지 않기 때문에 Thread-safety 하다고 할 수 없다.

- 멀티 스레드 환경 : ConcurrentHashMap이다. 메서드 자체에 동기화를 걸어두지 않으며 부분적으로 동시성에 관해 제어하며 멀티 Thread 환경에서 Thread-safety하다. 
동시성을 제어함과 Thread-safety, 그리고 읽기 연산은 따로 동시성을 제어하지 않아 연산 속도도 효율적임으로 적합하다고 말할 수 있다.

따라서 싱글 스레드 환경에선 HashMap을, 멀티 스레드 환경에서는 ConcurrentHashMap을 구현하는 것이 가장 적합하다.

아래는 ConcurrentHashMap의 put 메서드 내부 동작이다.
```java
final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();
        int hash = spread(key.hashCode());
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh; K fk; V fv;
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                if (casTabAt(tab, i, null, new Node<K,V>(hash, key, value)))
                    break;                   // no lock when adding to empty bin
            }
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else if (onlyIfAbsent // check first node without acquiring lock
                     && fh == hash
                     && ((fk = f.key) == key || (fk != null && key.equals(fk)))
                     && (fv = f.val) != null)
                return fv;
            else {
                V oldVal = null;
                synchronized (f) { // <<------ 핵심 -----------
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key, value);
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                        else if (f instanceof ReservationNode)
                            throw new IllegalStateException("Recursive update");
                    }
                }
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);
        return null;
    }
```

### Synchronized가 나왔는데, 해당 키워드는 무엇인가 ?
멀티 Thread가 하나의 자원에 접근 시에 현재 사용 중인 데이터를 제외한 나머지 Thread의 접근을 제한하는 Java 키워드이다.

따라서 멀티 Thread 환경에서 Thread-safety하다고 말할 수 있다. 하지만 Thread-safety하다고 남발하게 될 경우 성능적으로 하락할 수 있다.

그리고 Synchronized는 단일 서버에 지원한다. 서버가 여러 대(scale-out 하여)일 경우에는 지원하지 않는다. 이 점을 주의해야한다. 

프로젝트 중에 동기화 이슈가 있었는데, 단일 서버에서 지원하고 다중 서버에선 지원하지 않는다는 것을 알게 되었다. 


### Java 8 Map의 관계는 어떠한가 ? 구체적으로 어떤 변경 사항이 있었는지 ?

HashMap에서 성능 저하 요소가 가장 큰 부분은 바로 해시 충돌이다.

- Java 7에서는 위의 상황 시 Linked List로 관리했다. 최악의 시간인 경우 O(N)이 소요한다.
속도가 조금 더 빠른 ConcurrentHashMap을 사용해도 되지만, Concurrent 패키지는 기본적으로 동기화가 되어 있다.
Concurrent의 Hash 충돌 기법을 참고해 Java 8에서 Hash 충돌 기법이 개선된다.

- Java 8에서 HashMap의 Performance를 크게 끌어 올리는 변경점은 Binary Tree의 사용이다.
버킷의 수가 특정 개수에 도달하게 되면 기존에 있던(Java 7) Linked List로 이루어졌던 값을 Binary Tree로 변경한다.
이 경우 최악의 시간인 경우 O(log(N))이 된다. 특정 케이스에선 기본 HashMap보다 느릴 순 있으나, Hash 충돌이 많이 발생하는 대용량의 데이터일 때 
기존 HashMap보다 확연한 성능 차이를 보여준다.

### Java 8 (Map) Linked List에서 Tree로 변경된다는데, 어떻게 대체되는가 ?

HashMap은 버킷의 요소 수가 특정 임계값에 도달하면 Linked List를 Tree로 대체된다.
변환하는 동안 Hash Code가 분기 변수로 사용된다. 

동일한 버킷에 두 개의 다른 Hash Code가 있는 경우, 하나는 더 큰 것으로 간주되어
트리의 오른쪽으로 이동하고 다른 하나는 왼쪽으로 이동시킨다. 

그러나 동일하다면 HashMap은 키가 비슷하다 가정하고 키를 비교해 일부 순서가 유지될 수 있도록 방향을 결정하게 된다.
HashMap의 키를 비교 가능하게 만드는 것이 좋다.

그리고 Java 8 HashMap에서 하나의 버킷에 8개의 Key-Value 값이 모이면 Tree로 변경하게 된다. 버킷에 있는 데이터를 삭제해 6개에 이르면 다시 Linked List로 변경한다.

이유는 Tree는 Linked List보다 메모리 사용량이 많으며, 데이터의 개수가 적을 때 Tree와 Linked List의 Worst Case 수행 시간 차이 비교는 의미가 없다.

이 JDK 8 변경사항은 HashMap, LinkedHashMap 및 ConcurrentHashMap에만 적용된다.

### HashMap에서 해시 충돌이 발생하는 경우 어떻게 처리되는가 ?

HashMap에서 사용하는 방식은 Separate Chaining이다. Separate Chaining이란 간단하게 말해 분리 연결법이다. 

다른 방법으로는 Open Addressing인데, 이는 사용하지 않는다. 그 이유는 데이터 삭제 시 효율적인 처리가 어려워서이다.

HashMap의 경우 remove()가 빈번할 수 있는데, OpenAddressing의 경우 버킷을 해운 밀도가 높아질 수록 Worst Case 발생 확률이 높아질 수밖에 없다.

Separate Chaining의 경우 보조해시함수를 사용해 충돌이 발생하지 않도록 조정할 수 있다.

이의 내용은 바로 위의 질문 내용과 비슷하다.

### Map 인터페이스를 사용할 때 반복자(Iterator)를 어떻게 사용할 수 있는가 ?

while문을 통해 hasNext() 메서드를 이용해서 Map의 모든 요소들을 순회할 수 있다.

주의할 점은 Map는 순서를 보장하지 않으며 요소에 대한 반복 순서가 보장되지 않는다는 것이다.

따라서 순서가 중요한 경우 LinkedHashMap을 이용하거나, 정렬로 접근해야 하는 경우엔 TreeMap이 적합하다고 말할 수 있다.


### hashCode는 왜 equals와 같이 재정의 해야하는가? (Hash를 사용하는 라이브러리 중..(HashMap))

```java
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
    }
```
HashMap 중 put 메서드를 확인해보면 된다. putVal 메서드를 타고 들어가게 되면 아래와 같은 메서드의 내용이 있다.
```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```
여기서 확인해야할 포인트는 아래와 같다.
```java
if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
```

**참조 p의 hash와 매개변수 hash가 같아야 하고** key값이 같거나 **equals 메서드를 통해 같은지**?

그래서 조건식이 true일 경우 아래의 로직이 실행된다는 것이다. 그래서 hashCode와 equals를 재정의 해야만 
구현되어 있는 putVal 메서드의 조건이 올바르게 실행되기 때문에 재정의해야만 한다.

물론 HashMap 말고도 equals와 hashCode는 일반적으로 재정의한다. 보통은 자주같이 사용되니까 같이만드는게 통상적이다.

