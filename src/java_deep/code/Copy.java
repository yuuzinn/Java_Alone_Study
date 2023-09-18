package java_deep.code;

import java.util.ArrayList;
import java.util.List;

public class Copy {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(i + "번째");
        }
        System.out.println("list1 = " + list1); // list1 = [0번째, 1번째, 2번째, 3번째, 4번째]
        List<String> temp1 = list1; // list1의 같은 주소값을 가지는 temp1
        temp1.add("temp1에 추가할 거예요.");
        System.out.println("temp1 = " + temp1); // temp1 = [0번째, 1번째, 2번째, 3번째, 4번째, temp1에 추가할 거예요.]
        System.out.println("list1 = " + list1); // list1 = [0번째, 1번째, 2번째, 3번째, 4번째, temp1에 추가할 거예요.]
        /**
         * 얕은 복사 -> 주소값을 같이 참조하고 있으니 값이 변경되면 기존의 인스턴스도 변경이 적용된다.
         */

        /**
         * 깊은 복사 -> 새로이 인스턴스를 생성해서 각각의 주소를 가짐. 구현하는 데에는 여러 방법이 있다.
         * 1. Cloneable 인터페이스의 구현
         * 2. 복사 생성자
         * 3. 복사 팩터리 이 외에도 더 있다.
         */

    }
}
