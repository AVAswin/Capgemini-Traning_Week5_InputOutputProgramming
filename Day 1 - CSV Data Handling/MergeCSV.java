import java.io.*;
import java.util.*;

class Student {
    String id, name;
    int age, marks;
    String grade;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addMarksAndGrade(int marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, Student> studentMap = new HashMap<>();

        // Read students1.csv
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String id = tokens[0].trim();
                String name = tokens[1].trim();
                int age = Integer.parseInt(tokens[2].trim());
                studentMap.put(id, new Student(id, name, age));
            }
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }

        // Read students2.csv and update map 
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            br.readLine(); // skip header           
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String id = tokens[0].trim();
                int marks = Integer.parseInt(tokens[1].trim());
                String grade = tokens[2].trim();

                if (studentMap.containsKey(id)) {
                    studentMap.get(id).addMarksAndGrade(marks, grade);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }

        // Write merged output
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Student student : studentMap.values()) {
                bw.write(student.toString() + "\n");
            }
            System.out.println("Merged file created: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing output: " + e.getMessage());
        }
    }
}
