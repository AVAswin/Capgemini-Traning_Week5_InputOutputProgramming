import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a Person object
            Person person = new Person(25);
            person.displayAge(); // Output: Age: 25

            // Step 2: Get the Class object
            Class<?> clazz = person.getClass();

            // Step 3: Access the private field "age"
            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true); // Bypass private access

            // Step 4: Modify the private field
            ageField.setInt(person, 35);

            // Step 5: Retrieve the modified value
            int modifiedAge = ageField.getInt(person);
            System.out.println("Modified Age: " + modifiedAge); // Output: 35

            person.displayAge(); // Output: Age: 35

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
