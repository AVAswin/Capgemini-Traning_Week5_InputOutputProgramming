class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public void showName() {
        System.out.println("Student name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            // Step 1: Get the Class object
            Class<?> clazz = Class.forName("Student");

            // Step 2: Create object using the default constructor via Reflection
            Object studentObj = clazz.getDeclaredConstructor().newInstance();

            // Step 3: Cast and use the object
            Student student = (Student) studentObj;
            student.showName(); // Output: Student name: Default Student

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

