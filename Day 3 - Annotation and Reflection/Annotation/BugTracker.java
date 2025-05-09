import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Step 1: Define container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Define repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 3: Use annotation on a method
class BugTracker {

    @BugReport(description = "Null pointer exception when input is null")
    @BugReport(description = "Array index out of bounds on large inputs")
    public void processData() {
        System.out.println("Processing data...");
    }

    public static void main(String[] args) {
        try {
            Method method = BugTracker.class.getMethod("processData");

            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
            for (BugReport br : bugReports) {
                System.out.println("Bug: " + br.description());
            }

            // Optional: Call the method
            new BugTracker().processData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


