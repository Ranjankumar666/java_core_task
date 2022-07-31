package src.question6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import src.Student;

public class StudentMapTest {
    private StudentMap smap;
    private List<String[]> dummyVals;

    @Before
    public void init() {
        smap = new StudentMap();
        dummyVals = new ArrayList<>();

        dummyVals.add(new String[] { "Shivam", "Kumar", "sk@gmail.com" });
        dummyVals.add(new String[] { "Rajesh", "Irani", "ir@gmail.com" });
        dummyVals.add(new String[] { "Anna", "Murpy", "am@gmail.com" });

        for (String[] data : dummyVals) {
            smap.addStudent(new Student(data[0], data[1], data[2]));
        }
    }

    @Test
    public void checkAddStudent() {
        assertEquals(dummyVals.size(), smap.getRecord().size());
    }

    @Test
    public void checkGetByEmail() {
        assertTrue(smap.get(dummyVals.get(2)[2]).isPresent());
    }

    @Test
    public void checkGetByName() {
        String[] std = dummyVals.get(2);

        assertTrue(smap.get(std[0], std[1]).isPresent());
    }

    @Test
    public void checkGetByNameEmail() {
        String[] std = dummyVals.get(2);

        assertTrue(smap.get(std[0], std[1], std[2]).isPresent());
    }

    @Test
    public void checkSortByFirstName() {
        Map<Integer, Student> sorted = smap.sortByFirstName();
        String expected = dummyVals.get(2)[0];

        assertEquals(expected, sorted.values().stream().findFirst().get().getFirstname());

    }

    @Test
    public void checkSortByLastName() {
        Map<Integer, Student> sorted = smap.sortByLastName();
        String expected = dummyVals.get(1)[1];

        assertEquals(expected, sorted.values().stream().findFirst().get().getLastname());
    }

    @Test
    public void checkSortByEmail() {
        Map<Integer, Student> sorted = smap.sortByEmail();
        String expected = dummyVals.get(2)[2];

        assertEquals(expected, sorted.values().stream().findFirst().get().getEmail());

    }

}
