import java.lang.reflect.Field;

public class JsonSerializer {

    // Method to convert an object to a JSON-like string
    public static String toJson(Object obj) throws IllegalAccessException {
        // Start the JSON string
        StringBuilder json = new StringBuilder();
        json.append("{");

        // Get all fields of the object's class (including private fields)
        Field[] fields = obj.getClass().getDeclaredFields();

        // Iterate over all fields
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            // Make the field accessible if it is private
            field.setAccessible(true);

            // Append the field name and its value to the JSON string
            json.append("\"")
                .append(field.getName()) // Field name
                .append("\": ")
                .append("\"")
                .append(field.get(obj)) // Field value
                .append("\"");

            // Add a comma between fields if not the last field
            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        // End the JSON string
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        // Create a sample object
        Person person = new Person("John Doe", 30);

        // Convert the object to JSON-like string
        String jsonString = toJson(person);

        // Print the resulting JSON-like string
        System.out.println(jsonString);
    }
}

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
