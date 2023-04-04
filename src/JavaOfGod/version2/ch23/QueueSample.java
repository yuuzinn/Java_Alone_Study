package JavaOfGod.version2.ch23;

import java.util.LinkedList;

public class QueueSample {
    public static void main(String[] args) {
        QueueSample sample = new QueueSample();
        sample.checkLinkedList1();
    }

    public void checkLinkedList1() {
        LinkedList<String> link = new LinkedList<>();
        link.add("A");
        link.addFirst("B");
        System.out.println(link); // B, A
        link.offerFirst("C");
        System.out.println(link); // C, B, A
        link.addLast("D");
        System.out.println(link);// C, B, A, D
        link.offer("E");
        System.out.println(link); // C, B, A, D, E
        link.offerLast("F");
        System.out.println(link); // C, B, A, D, E, F
        link.push("G");
        System.out.println(link); // G, C, B, A, D, E, F
        link.add(0, "H");
        System.out.println(link); // H, G, C, B, A, D, E, F
        System.out.println("EX = " + link.set(0, "I")); // 수정
        System.out.println(link); // I, H, G, C, B, A, D, E, F -> [I, G, C, B, A, D, E, F]
    }
}
