import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRowCounter {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Replace with your CSV file path
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip header
            if ((line = br.readLine()) != null) {
                // Header read and ignored
            }

            // Count rows
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    rowCount++;
                }
            }

            System.out.println("Number of records (excluding header): " + rowCount);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
