import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Step 1: Read method name and parameters from user
            System.out.print("Enter method (add / subtract / multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int a = scanner.nextInt();

            System.out.print("Enter second number: ");
            int b = scanner.nextInt();

            // Step 2: Get the Class object
            Class<?> clazz = MathOperations.class;

            // Step 3: Create an object of MathOperations
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // Step 4: Get the Method object
            Method method = clazz.getMethod(methodName, int.class, int.class);

            // Step 5: Invoke the method dynamically
            Object result = method.invoke(obj, a, b);

            // Step 6: Display the result
            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
