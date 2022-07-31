package src.question6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import src.Student;

public class StudentMap {
    private Map<Integer, Student> record = new HashMap<>();
    private int id;

    public Map<Integer, Student> getRecord() {
        return record;
    }

    public void addStudent(Student std) {
        record.put(id, std);
        id += 1;
    }

    public Optional<Student> get(int id) {
        return Optional.ofNullable(record.get(id));
    }

    public Optional<Student> get(String email) {
        int foundId = -1;

        for (int id : record.keySet()) {
            Student std = record.get(id);

            if (std.getEmail().startsWith(email)) {
                foundId = id;
            }
        }

        return Optional.ofNullable(record.get(foundId));
    }

    public Optional<Student> get(String fname, String lname) {
        int foundId = -1;

        for (int id : record.keySet()) {
            Student std = record.get(id);

            if (std.getFirstname().startsWith(fname) ||
                    std.getLastname().startsWith(lname)) {
                foundId = id;
            }
        }

        return Optional.ofNullable(record.get(foundId));
    }

    public Optional<Student> get(String fname, String lname, String email) {
        int foundId = -1;

        for (int id : record.keySet()) {
            Student std = record.get(id);

            if (std.getFirstname().startsWith(fname) ||
                    std.getLastname().startsWith(lname) ||
                    std.getEmail().startsWith(email)) {
                foundId = id;
            }
        }

        return Optional.ofNullable(record.get(foundId));
    }

    public Map<Integer, Student> sortByFirstName() {
        return record.entrySet().stream().sorted((a, b) -> {
            return a.getValue().getFirstname().compareTo(b.getValue().getFirstname());
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oV, nV) -> oV, LinkedHashMap::new));
    }

    public Map<Integer, Student> sortByLastName() {
        return record.entrySet().stream().sorted((a, b) -> {
            return a.getValue().getLastname().compareTo(b.getValue().getLastname());
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oV, nV) -> oV, LinkedHashMap::new));
    }

    public Map<Integer, Student> sortByEmail() {
        return record.entrySet().stream().sorted((a, b) -> {
            return a.getValue().getEmail().compareTo(b.getValue().getEmail());
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oV, nV) -> oV, LinkedHashMap::new));
    }

}
