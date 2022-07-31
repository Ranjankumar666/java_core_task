package src.question5;

import java.util.List;
import java.util.stream.Collectors;

import src.Student;

public class StudentList {
    public static List<Student> join(List<Student> list1, List<Student> list2) {

        for (Student student : list2) {
            boolean present = list1.stream().anyMatch((e) -> {
                return e.getFirstname().equals(student.getFirstname()) &&
                        e.getLastname().equals(student.getLastname());
            });

            if (!present) {
                list1.add(student);
            }

        }

        return list1;
    }

    public static List<Student> search(List<Student> list, String firstname, String lastname) {
        return list.stream().filter((e) -> {
            return e.getFirstname().equals(firstname) ||
                    e.getLastname().equals(lastname);
        }).collect(Collectors.toList());
    }
}
