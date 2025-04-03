import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 72),
            new Student("Charlie", 90),
            new Student("David", 65),
            new Student("Emma", 78)
        );

        List<String> topStudents = students.stream()
            .filter(s -> s.getMarks() > 75) // Filter students scoring above 75%
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed()) // Sort by marks (descending)
            .map(Student::getName) // Extract names
            .collect(Collectors.toList());

        System.out.println("Top Students (Marks > 75): " + topStudents);
    }
}
