import java.io.*;
import java.util.*;

class Employee {
    String name;
    String department;
    double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class SortCSVBySalary {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<Employee> employeeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0].trim();
                String department = values[1].trim();
                double salary = Double.parseDouble(values[2].trim());

                employeeList.add(new Employee(name, department, salary));
            }

            // Sort list by salary in descending order
            employeeList.sort((a, b) -> Double.compare(b.salary, a.salary));

            // Print top 5
            System.out.println("Top 5 Highest Paid Employees:");
            System.out.printf("%-10s %-15s %-10s%n", "Name", "Department", "Salary");
            for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
                Employee e = employeeList.get(i);
                System.out.printf("%-10s %-15s %.2f%n", e.name, e.department, e.salary);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
