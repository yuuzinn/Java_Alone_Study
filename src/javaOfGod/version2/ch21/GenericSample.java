package javaOfGod.version2.ch21;

public class GenericSample {
    public static void main(String[] args) {

        GenericSample sample = new GenericSample();
        sample.checkCastingDTO();
    }

    public void checkCastingDTO() {
        CastingDTO dto1 = new CastingDTO();
        dto1.setObject(new String());

        CastingDTO dto2 = new CastingDTO();
        dto2.setObject(new StringBuffer());
        Object object = dto2.getObject();
        System.out.println(object);

        CastingDTO dto3 = new CastingDTO();
        dto3.setObject(new StringBuilder());
    }
}
