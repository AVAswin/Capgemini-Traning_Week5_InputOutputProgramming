import java.io.*;
import java.util.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "large_students.csv"; // Your large CSV file
        int batchSize = 100;
        int totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;                            
            List<String> chunk = new ArrayList<>(); 
            br.readLine(); // skip header if needed 

            while ((line = br.readLine()) != null) { 
                chunk.add(line);                     

                if (chunk.size() == batchSize) {     
                    processChunk(chunk);
                    totalProcessed += chunk.size();
                    System.out.println("Processed records: " + totalProcessed);
                    chunk.clear();
                }
            }

            // Process any remaining lines
            if (!chunk.isEmpty()) {
                processChunk(chunk);
                totalProcessed += chunk.size();
                System.out.println("Processed records: " + totalProcessed);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void processChunk(List<String> chunk) {
        // You can replace this with actual processing logic
        for (String record : chunk) {
            // e.g., parse and store to DB, transform, etc.
        }
    }
}
