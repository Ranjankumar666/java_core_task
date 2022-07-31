package src.question5;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import src.Student;

public class StudentListTest {

    private ArrayList<Student> list1;
    private ArrayList<Student> list2;

    @Before
    public void init() {

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        list1.add(new Student("James", "Hetfield"));
        list1.add(new Student("Lemmy", "Kilmister"));
        list1.add(new Student("Robert", "Plant"));

        list2.add(new Student("Robert", "Plant"));
        list2.add(new Student("Dave", "Lombardo"));
    }

    @Test
    public void checkJoin() {
        assertEquals(list1.size() + list2.size() - 1, StudentList.join(list1, list2).size());
    }

    @Test
    public void checkSearch() {

        assertEquals("James", StudentList.search(list1, "James", "Hetfield").get(0).getFirstname());
    }
}
