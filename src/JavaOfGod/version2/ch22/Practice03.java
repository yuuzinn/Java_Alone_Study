package JavaOfGod.version2.ch22;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 다시 시도해볼 필요 있음.
 */

public class Practice03 {
    public static void main(String[] args) throws Exception {
//        Practice03 test = new Practice03();
//        test.setData();
//    }
//    public void setData() {
//        ArrayList<ArrayList<Integer>> gradeHeights = new ArrayList<>();
//    }
//    public void printHeights(int classNo) {
//
        List<Integer> num = new ArrayList<>(20);
        for (int i = 0; i < 25; i++) {
            num.add(i);
        }
        System.out.println(num.size());
//        System.out.println(getCapacity(num));
    }

//    static int getCapacity(List num) throws Exception{
//        Field field = ArrayList.class.getDeclaredField("elementData");
//        field.setAccessible(true);
//        return ((Object[]) field.get(num)).length;
//    }
}
