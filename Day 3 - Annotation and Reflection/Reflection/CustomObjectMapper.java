import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        // Create a new instance of the given class
        T obj = clazz.getDeclaredConstructor().newInstance();
        
        // Iterate over the map and set fields of the object
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            // Get the field name from the map and try to get the corresponding field in the class
            Field field = clazz.getDeclaredField(entry.getKey());
            
            // Make the field accessible if it's private
            field.setAccessible(true);
            
            // Set the value from the map to the corresponding field of the object
            field.set(obj, entry.getValue());
        }
        
        return obj;
    }

    public static void main(String[] args) throws Exception {
        // Example Map with property names and values
        Map<String, Object> properties = Map.of(
            "name", "John Doe",
            "age", 30
        );

        // Convert map to a Person object using toObject method
        Person person = toObject(Person.class, properties);

        // Print the result
        System.out.println(person);
    }
}

class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
