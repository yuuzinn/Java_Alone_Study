package javaOfGod.version2.ch21;

public class GenericSample2 {
    public static void main(String[] args) {

        GenericSample2 sample = new GenericSample2();
        sample.checkCastingDTO();

    }

    public void checkCastingDTO() {
        CastingGenericDTO<String> dto1 = new CastingGenericDTO<>();
        dto1.setObject(new String());

        CastingGenericDTO<StringBuffer> dto2 = new CastingGenericDTO<>();
        dto2.setObject(new StringBuffer());

        CastingGenericDTO<StringBuilder> dto3 = new CastingGenericDTO<>();
        dto3.setObject(new StringBuilder());


        String temp1 = dto1.getObject();
        StringBuffer temp2 = dto2.getObject();
        StringBuilder temp3 = dto3.getObject();
    }
}
