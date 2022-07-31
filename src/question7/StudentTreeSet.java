package src.question7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import src.Student;

public class StudentTreeSet {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>((a, b) -> {
            return a.getFirstname().compareTo(b.getFirstname());
        });
        ArrayList<String[]> dummyVals = new ArrayList<>();

        dummyVals.add(new String[] { "Shivam", "Kumar", "sk@gmail.com" });
        dummyVals.add(new String[] { "Rajesh", "Irani", "ir@gmail.com" });
        dummyVals.add(new String[] { "Anna", "Murpy", "am@gmail.com" });

        for (String[] data : dummyVals) {
            ts.add(new Student(data[0], data[1], data[2]));
        }

        try {
            PrintStream out = new PrintStream(new FileOutputStream("./tsStudent.csv"));

            Iterator<Student> it = ts.iterator();

            while (it.hasNext()) {
                out.println(it.next());
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
