//package Kevin_Stream;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//
//public class StreamExamplesTest02 {
//    private static final String[] priceStrings = {"1.0","100.99","35.75","21.30","88.00"};
//    private static final Random random = new Random(123);
//
//    private static final List<Product> products;
//
//    static {
//        final int length = 8_000_000;
//        final List<Product> list = new ArrayList<>();
//
//        for (int i = 1; i <= length; i++) {
//            list.add(new Product((long) i, "Product" + i, new BigDecimal(priceStrings[random.nextInt(5)])));
//        }
//        products = Collections.unmodifiableList(list);
//    }
//
//    private static
//    public static void main(String[] args) {
//
//    }
//}
//@AllArgsConstructor
//@Data
//class Product {
//    private Long id;
//    private String name;
//    private BigDecimal price;
//}
