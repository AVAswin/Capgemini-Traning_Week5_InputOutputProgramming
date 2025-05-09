import java.lang.reflect.Field;

public class APIConfiguration {
    // Private static field
    private static String API_KEY = "initial_value";

    public static void main(String[] args) throws Exception {
        // Print original API_KEY
        System.out.println("Original API_KEY: " + API_KEY);

        // Access the private static field using reflection
        Field field = APIConfiguration.class.getDeclaredField("API_KEY");
        
        // Set the field accessible to modify it
        field.setAccessible(true);
        
        // Modify the value of the private static field
        field.set(null, "new_value");

        // Print modified API_KEY
        System.out.println("Modified API_KEY: " + API_KEY);
    }
}
