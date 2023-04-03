package JavaOfGod.version1.Stream;

import java.util.ArrayList;
import java.util.List;

public class StreamFilterSample {
    public static void main(String[] args) {

        StreamFilterSample sample = new StreamFilterSample();
        List<StudentDTO> studentList = new ArrayList<>();
        studentList.add(new StudentDTO("요다", 1, 1, 1));
        studentList.add(new StudentDTO("만두", 2, 2, 2));
        studentList.add(new StudentDTO("건빵", 3, 3, 3));
        sample.filterWithScoreForLoop(studentList, 2);

//        studentList.stream().filter(student -> student.getScoreEnglish() > scoreCutLine)
//                  .forEach(student -> System.out.println(student.getName());

    }
    public void filterWithScoreForLoop(List<StudentDTO> studentList, int scoreCutLine) {
        for (StudentDTO student : studentList) {
            if (student.getScoreEnglish() > scoreCutLine) {
                System.out.println(student.getName());
            }
        }
    }
}
