import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonStructureValidation {
    public static void main(String[] args) {
        String json = "{\"brand\":\"Toyota\", \"model\":\"Camry\", \"year\":2020}";

        ObjectMapper mapper = new ObjectMapper();

        try {
            Car car = mapper.readValue(json, Car.class);
            System.out.println("JSON is structurally valid for Car class.");
        } catch (Exception e) {
            System.out.println("Invalid structure: " + e.getMessage());
        }
    }
}
