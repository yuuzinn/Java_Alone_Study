package java_deep.code;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class EqualsAndHashCode {

  public static void main(String[] args) {
    String a = "a";
    String b = "a";
    System.out.println(a.equals(b));
    System.out.println(a == b);
    ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();
    ConcurrentHashMap<String, String> ma1 = new ConcurrentHashMap<>();
    String a2 = new String("a");
    String b2 = new String("b");
    System.out.println(a2.equals(b2));
    System.out.println(a2 == b2);

    System.out.println(a2.hashCode());
    System.out.println(b2.hashCode());

    String s1 = "string";
    String s2 = "string";
    String s3 = new String("string");
    System.out.println(s1.hashCode());
    System.out.println(s2.hashCode());
    System.out.println("---");
    System.out.println(s1 == s2);
    System.out.println(s1 == s3);
    System.out.println(s1.equals(s3));

    Object a1 = new Object();
    a1 = "a";
    Object b1 = new Object();
    b1 = "a";
    System.out.println(a1.equals(b1));
    System.out.println(a1 == b1);
  }
}
