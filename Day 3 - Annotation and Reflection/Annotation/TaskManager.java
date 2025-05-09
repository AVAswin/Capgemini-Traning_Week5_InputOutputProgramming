import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)  // Make it available at runtime
@Target(ElementType.METHOD)          // Can be applied to methods only
@interface TaskInfo {
    String priority() default "Medium";
    String assignedTo();
}

class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeProject() {
        System.out.println("Completing the project...");
    }

    public static void main(String[] args) {
        try {
            Class<TaskManager> obj = TaskManager.class;
            Method method = obj.getMethod("completeProject");

            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo task = method.getAnnotation(TaskInfo.class);
                System.out.println("Priority: " + task.priority());
                System.out.println("Assigned To: " + task.assignedTo());
            }

            // Optional: Run the method
            new TaskManager().completeProject();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

