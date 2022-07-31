package src.question9;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class Processor extends Thread {
    private List<Student> students;
    private String resultPath;
    private boolean shouldAppend = true;

    public Processor(List<Student> list, String fileName) {
        students = list;
        resultPath = fileName;

    }

    public Processor(List<Student> list, String fileName, boolean shouldAppend) {
        students = list;
        resultPath = fileName;
        this.shouldAppend = shouldAppend;
    }

    @Override
    synchronized public void run() {
        try {
            FileOutputStream file = new FileOutputStream(resultPath, shouldAppend);
            PrintWriter writer = new PrintWriter(file);

            for (Student student : students) {
                int marks = student.getMarks();

                if (marks >= 90) {
                    writer.println(student.getName() + " ,Grade: Distinction");
                } else if (marks < 90 && marks >= 50) {
                    writer.println(student.getName() + " ,Grade: Passed");
                } else {
                    writer.println(student.getName() + " ,Grade: Not Cleared");
                }
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
