package java_deep.code;

import java.util.HashMap;

public class test {
    public Object solution(String s){
        HashMap<Character, Integer> sH = new HashMap<>();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        for(char key : sH.keySet()){
            System.out.println(key + " " + sH.get(key));
        }
        return null;
    }
    public static void main(String[] args){
        test T = new test();
        System.out.println(T.solution("statisics"));
    }

}
