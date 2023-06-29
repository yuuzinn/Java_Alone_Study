## 정렬 (Sort) 

### Sort 알고리즘에 대해 설명할 수 있는가 ?

정렬 알고리즘이란 원소들을 일정한 순서대로 열거하는 알고리즘이다. 

정렬 알고리즘을 사용할 때, 상황에 맞게 다음의 기준들로 사용할 알고리즘을 선정하게 된다.

- 시간복잡도 (소요되는 시간)
- 공간복잡도 (메모리의 사용량)

시간, 공간 복잡도는 BIG-O 표기법으로 나타낼 수 있다.

또한 정렬되는 항목 외에 충분히 무시할만한 저장공간만을 더 사용하는 정렬 알고리즘들을 **제자리 정렬**이라 한다.

간단하게 쓰이는 함수가 하나 있다.

```java
public static void swap(int[] arr, int idx1, int idx2) {
  int tmp = arr[idx1];
  arr[idx1] = arr[idx2];
  arr[idx2] = tmp;
}
```
배열의 두 인덱스의 원소를 교환하는 메서드이다. 정렬에서 주로 사용되는 메커니즘이다.

### 버블 정렬 (Bubble Sort)

정렬 과정에서 거품이 수면 위로 올라오는 모습과 흡사해 지어진 이름이다.

비교와 교환이 모두 일어날 수 있어 코드는 단순하지만, 성능은 좋지 못하다. (시간복잡도 O(N^2))

```java
public static void sortByBubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1l; j++) {
        if (arr[j] > arr[j + 1]) {
            swap(arr, j, j + 1);
        }
      }
    }
}
j가 0 ~ (n - 2)까지 반복하는 이유는 j의 원소와 j + 1의 원소를 비교하기 때문이다.
for문을 돌면서 뒤 원소가 더 작으면 swap()한다.
```

### 선택 정렬 (Selection Sort)

맨 앞 인덱스부터 차례대로 들어갈 원소를 선택하여 정렬한다.

교환횟수는 O(N)으로 적지만, 비교는 모두 진행된다. 버블 정렬보다는 성능이 좋다. (시간 복잡도 O(N^2))

```java
public static void sortBySelectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minIdx = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIdx]) {
          minIdx = j;
        }
        swap(arr, i, minIdx);
      }
    }
}
```
1. 인덱스 0 ~ (n - 1)을 돌면서 원소의 값이 가장 작은 인덱스를 찾는다.
2. 인덱스 0과 가장 작은 인덱스의 원소를 swap()한다. 
3. 다시 인덱스 1 ~ (n - 1)을 돌면서 원소의 값이 가장 작은 인덱스를 찾는다.
4. 인덱스 1과 가장 작은 인덱스의 원소를 swap()... 반복

### 삽입 정렬 (Insertion Sort)

인덱스 1의 원소부터 앞 방향으로 들어갈 위치를 찾아 교환하는 정렬 알고리즘이다.

정렬이 되어 있는 배열의 경우 O(N)의 속도로, 정렬되어 있을 수록 성능이 좋다(이미 되어 있으니)

시간복잡도는 O(N^2)이다.

```java
public static void sortByInsertionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int tmp = arr[i];
      int j = i - 1;
      while (j >= 0 && tmp < arr[j]){
          arr[j+1]=arr[j];
          j--;
      }
      arr[j + 1] = tmp;
    }
} 
```

### 셸 정렬 (Shell Sort)

삽입 정렬의 장점을 살리고 단점을 보완했다.

삽입 정렬의 단점은 (n - 1)번째 인덱스의 원소의 들어가야할 자리가 0번째 인덱스라면, 많은 swap()을 해야하는 것이다.

단점을 보완하기 위해 간격을 정하여 배열을 부분 배열들로 나누어 어느정도 정렬시키고, 다시 간격을 줄여 정렬함.

시간복잡도는 O(N^1.5)이다.

```java
public static void sortByShellSort(int[] arr) {
    for (int i = arr.length / 2; i > 0; i /= 2 ) {
      for (int j = i; j < arr.length; j ++) {
        int tmp = arr[i];
        int k = j - i;
        while (z >= 0 && arr[k] > tmp) {
          arr[k + i] = arr[k];
          k -= i;
        }
        arr[k + i] = tmp;
      } 
    }
}
```

### 합병(병합) 정렬 (Merge Sort)

분할 정복 알고리즘 중 하나이다.

배열의 길이가 1이 될 때까지 2개의 부분 배열로 분할한다.

분할이 끝났다면 다시 2개의 부분 배열을 합병하고 정렬한다.

모든 부분 배열 반복. 시간 복잡도는 O(nlogn)으로 빠르지만, O(N)만큼 추가적인 메모리가 사용되는 단점이 있다.

보통은 재귀 함수로 구현하는데, 이것도 메모리를 많이 잡아 먹는다.

```java
public static void sortByMergeSort(int[] arr) {
    int[] tmpArr = new int[arr.length];
    mergeSort(arr, tmpArr, 0, arr.length - 1);
}
public static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
    if (left < right) {
        int m = left + (right - left) / 2;
        mergeSort(arr, tmpArr, left, m);
        mergeSort(arr, tmpArr, m + 1, right);
        merge(arr, tmpArr, left, m, right);
    }
}
public static void merge(int[] arr, int[] tmpArr, int left, int mid, int right) {
    for (int i = left; i <= right; i++) {
        tmpArr[i] = arr[i];
    }
    int part1 = left;
    int part2 = mid + 1;
    int index = left;
    while (part1 <= mid && part2 <= right) {
        if (tmpArr[part1] <= tmpArr[part2]) {
            arr[index] = tmpArr[part1];
            part1++;
        } else {
            arr[index] = tmpArr[part2];
            part2++;
        }
        index++;
    }
    for (int i = 0; i <= mid - part1; i++) {
        arr[index + i] = tmpArr[part1 + i];
    }
}
```

### 힙 정렬 (Heap Sort)

오름차순 정렬일 때 최대 힙을 사용하는 정렬이다. (내림차는 최소힙이다.)

최대힙을 배열로 구현하면 0번째 인덱스가 가장 큰 수라는 점을 사용한다.

시간 복잡도가 O(nlog n)으로 합병정렬, 퀵정렬과 동일하지만, 성능은 상대적으로 더 낮다.

이유는 매번 루트에서 최대값을 뺄 때마다 heapify()를 사용하여 다시 최대힙으로 만들어야 해서 그렇다.

```java
public static void sortByHeapSort(int[] arr) {
    for (int i = arr.length / 2 - 1; i < arr.length; i++) {
        heapify(arr, i, arr.length - 1);
    }
    for (int i = arr.length - 1; i >= 0; i--) {
        swap(arr, 0, i);
        heapify(arr, 0, i - 1);
    }
}
public static void heapify(int[] arr, int parentIdx, int lastIdx) {
    int leftChildIdx;
    int rightChildIdx;
    int largestIdx;
    while (parentIdx * 2 + 1 <= lastIdx) {
        leftChildIdx = (parentIdx * 2) + 1;
        rightChildIdx = (parentIdx * 2) + 2;
        largestIdx = parentIdx;
        if (arr[leftChildIdx] > arr[largestIdx]) {
            largestIdx = leftChildIdx;
        }
        if (rightChildIdx <= lastIdx && arr[rightChildIdx] > arr[largestIdx]) {
            largestIdx = rightChildIdx;
        }
        if (largestIdx != parentIdx) {
            swap(arr, parentIdx, largestIdx);
            parentIdx = largestIdx;
        } else {
            break;
        }
    }
}
```

### 퀵 정렬 (Quick Sort)

피벗을 사용한 정렬 알고리즘이며 합병 정렬과 같은 분할 정복 알고리즘이다.

합병 정렬은 일정한 부분 리스트로 분할하지만 퀵 정렬은 피벗이 들어갈 위치에 따라 불균형하다.

합병 정렬과 속도가 비슷하고 힙 정렬보다 빠르지만, 최악의 경우 O(N^2)까지 걸린다.

보통 재귀로 구현하기에 메모리를 더 사용한다 말할 수 있다.

최악의 경우, 피벗을 최솟값이나 최댓값으로 선택하여 부분 배열이 한쪽으로 계속 몰리는 경우이다.

```java
public static void sortByQuickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
}
public static void quickSort(int[] arr, int left, int right) {
    int part = partition(arr, left, right);
    if (left < part - 1) {
        quickSort(arr, left, part - 1);
    }
    if (part < right) {
        quickSort(arr, part, right);
    }
}
public static int partition(int[] arr, int left, int right) {
    int pivot = arr[(left + right) / 2];
    while (left <= right) {
        while (arr[left] < pivot) {
            left++;
        }
        while (arr[right] > pivot) {
            right--;
        }
        if (left <= right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    return left;
}
```

