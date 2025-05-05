import java.io.*;
import java.util.*;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        ) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (isHeader) {
                    // Write header directly
                    bw.write(line);
                    bw.newLine();
                    isHeader = false;
                    continue;
                }

                String name = values[0].trim();
                String department = values[1].trim();
                double salary = Double.parseDouble(values[2].trim());

                // Increase salary by 10% if in IT department
                if (department.equalsIgnoreCase("IT")) {
                    salary *= 1.10;
                }

                bw.write(name + "," + department + "," + salary);
                bw.newLine();
            }

            System.out.println("Updated salaries written to " + outputFile);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
