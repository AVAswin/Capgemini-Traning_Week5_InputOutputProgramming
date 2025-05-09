import java.lang.annotation.*;
import java.lang.reflect.Method;

// Main class
public class TodoAnnotationDemo {

    // Custom annotation definition
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Todo {
        String task();
        String assignedTo();
        String priority() default "MEDIUM";
    }

    // Sample class with annotated methods
    static class ProjectTasks {

        @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
        public void loginFeature() {
            // TODO
        }

        @Todo(task = "Connect to payment gateway", assignedTo = "Bob")
        public void paymentIntegration() {
            // TODO
        }

        public void completedFeature() {
            System.out.println("This feature is already completed.");
        }

        @Todo(task = "Optimize database queries", assignedTo = "Charlie", priority = "LOW")
        public void optimizeDB() {
            // TODO
        }
    }

    // Main method to print all @Todo annotations
    public static void main(String[] args) {
        Class<ProjectTasks> clazz = ProjectTasks.class;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Task       : " + todo.task());
                System.out.println("  Assigned To: " + todo.assignedTo());
                System.out.println("  Priority   : " + todo.priority());
                System.out.println("-------------------------------------");
            }
        }
    }
}
