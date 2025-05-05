import java.io.*;
import java.util.*;

public class DuplicateCSVDetector {
    public static void main(String[] args) {
        String filePath = "students.csv";
        Set<String> seenIds = new HashSet<>();
        Set<String> duplicateIds = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header
                    continue;
                }

                String[] tokens = line.split(",");
                String id = tokens[0].trim();

                if (!seenIds.add(id)) {
                    // ID already exists → duplicate
                    duplicateIds.add(id);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Re-read file to print duplicate rows
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] tokens = line.split(",");
                String id = tokens[0].trim();

                if (duplicateIds.contains(id)) {
                    System.out.println("Duplicate record: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file again: " + e.getMessage());
        }
    }
}
