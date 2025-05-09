import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter full class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            Class<?> cls = Class.forName(className);
            System.out.println("\nClass: " + cls.getName());

            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("\n--- Fields ---");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Get and display methods
            System.out.println("\n--- Methods ---");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found. Please enter a valid class name.");
        }

        scanner.close();
    }
}
