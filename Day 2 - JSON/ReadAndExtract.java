import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

class ReadAndExtract {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("user.json"));

        String name = root.get("name").asText();
        String age = root.get("age").asText();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
