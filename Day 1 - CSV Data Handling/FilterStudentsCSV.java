import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterStudentsCSV {
    public static void main(String[] args) {
        String file = "students.csv"; // Path to your CSV file
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Read the header line
            line = br.readLine();

            System.out.println("Students with marks greater than 80:");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0].trim();
                int marks = Integer.parseInt(data[1].trim());

                if (marks > 80) {
                    System.out.println("Name: " + name + ", Marks: " + marks);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV: " + e.getMessage());
        }
    }
}
