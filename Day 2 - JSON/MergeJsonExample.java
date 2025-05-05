import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Create two JSON objects
            ObjectNode json1 = mapper.createObjectNode();
            json1.put("name", "Aswin");
            json1.put("age", 25);

            ObjectNode json2 = mapper.createObjectNode();
            json2.put("city", "Chennai");
            json2.put("age", 30);  // This will override age from json1

            // Merge json2 into json1
            json1.setAll(json2);

            // Print merged JSON
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
