import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            // Step 1: Create Calculator object
            Calculator calc = new Calculator();

            // Step 2: Get the Class object
            Class<?> clazz = calc.getClass();

            // Step 3: Access the private method "multiply"
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true); // Bypass private access

            // Step 4: Invoke the method
            int result = (int) multiplyMethod.invoke(calc, 6, 7);

            // Step 5: Display the result
            System.out.println("Result of multiply(6, 7): " + result); // Output: 42

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
