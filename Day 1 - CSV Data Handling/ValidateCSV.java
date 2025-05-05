import java.io.*;
import java.util.*;

class Student {
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grade='" + grade + "'}";
    }
}

class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Update path as needed
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String name = data[0].trim();
                    int age = Integer.parseInt(data[1].trim());
                    String grade = data[2].trim();
                    studentList.add(new Student(name, age, grade));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print all students
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
