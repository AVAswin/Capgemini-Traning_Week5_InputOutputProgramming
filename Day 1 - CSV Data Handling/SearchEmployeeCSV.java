import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeCSV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String targetName = scanner.nextLine().trim();

        String filePath = "students.csv";
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0].trim();

                if (name.equalsIgnoreCase(targetName)) {
                    String department = values[1].trim();
                    String salary = values[2].trim();

                    System.out.println("Department: " + department);
                    System.out.println("Salary: $" + salary);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}
