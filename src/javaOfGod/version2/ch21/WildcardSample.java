package javaOfGod.version2.ch21;

public class WildcardSample {
    public static void main(String[] args) {
        WildcardSample sample =new WildcardSample();
        sample.callWildMethod();
    }

    public void callWildMethod() {
        WildcardGeneric<String> wildCard = new WildcardGeneric<>(); // <String> -> <?> 불가능하다. 와일드카드로는 객체 생성 불가능, param 으로는 와일드카드 가능함.
//        WildcardGeneric<?> wildCard2 = new WildcardGeneric<String>();
        wildCard.setWildcard("A");
        wildcardStringMethod(wildCard);
    }

    public void wildcardStringMethod(WildcardGeneric<String> c) {
        String value = c.getWildcard();
        if (value instanceof String) {
            System.out.println(value);
        }
    }
    // param 에서 String -> Integer 로 바꾸려면 ?
    // 1 param 에서 <?> 로 바꾸어 준다.
    // 2 String value = c.getWildcard(); -> Object value = c.getWildcard();

    // ? 로 타입을 명시한 것을 wildcard 타입이라 부른다. 어떤 타입이든 들어올 수 있음.
    // 만약 두세 가지로 정해져 있다면 (넘어오는 타입) instanceof 로 타입 확인해서 찍어버림 됨.
}
