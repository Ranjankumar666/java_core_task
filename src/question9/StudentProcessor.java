package src.question9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.stream.Stream;

public class StudentProcessor {
    private LinkedList<Student> students = new LinkedList<>();

    public void readFile(String fileName) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        Stream<String> lines = br.lines().skip(1);

        lines.forEachOrdered((line) -> {
            String[] data = line.split(",");
            students.add(new Student(
                    Integer.parseInt(data[0]),
                    data[1], data[2],
                    Integer.parseInt(data[3])));
        });

        br.close();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        StudentProcessor sp = new StudentProcessor();
        int partitions = 3;
        int size = 20;
        Thread[] threads = new Thread[partitions];

        sp.readFile("./Student_Data - Sheet1.csv");

        for (int i = 0; i < partitions; i++) {
            int start = i * size;
            int end = (i + 1) * size;

            // Clear all the file contents for batch 1
            boolean shouldAppend = true;
            if (i == 0)
                shouldAppend = false;

            threads[i] = new Processor(sp.students.subList(start, end),
                    "./results.txt", shouldAppend);

        }

        /// Sequentially updated the results
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();

            try {
                threads[i].join();
            } catch (Exception e) {
                System.out.println("Thread " + i + " done editing");
            }
        }

    }

}
