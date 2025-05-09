import java.lang.annotation.*;
import java.lang.reflect.Method;

// Main class
class AnnotationDemo {

    // Custom Annotation
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ImportantMethod {
        String level() default "HIGH";
    }

    // Class with annotated methods
    static class TaskProcessor {

        @ImportantMethod(level = "MEDIUM")
        public void processUserData() {
            System.out.println("Processing user data...");
        }

        @ImportantMethod
        public void saveToDatabase() {
            System.out.println("Saving to database...");
        }

        public void helperMethod() {
            System.out.println("Just a helper method.");
        }
    }

    // Main method to use reflection
    public static void main(String[] args) {
        Class<TaskProcessor> clazz = TaskProcessor.class;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() +
                                   " | Importance Level: " + annotation.level());
            }
        }
    }
}
