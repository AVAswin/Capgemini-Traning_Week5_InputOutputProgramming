import java.lang.annotation.*;
import java.lang.reflect.*;

// Main class
public class LogAnnotationDemo {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface LogExecutionTime {}

    static class Worker {

        @LogExecutionTime
        public void fastTask() {
            for (int i = 0; i < 1000; i++) {} // light work
        }

        @LogExecutionTime
        public void slowTask() {
            try {
                Thread.sleep(200); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("🔍 Executing @LogExecutionTime Methods:");
        Worker worker = new Worker();
        for (Method method : Worker.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(worker);
                long end = System.nanoTime();
                System.out.println("Method: " + method.getName() +
                        " | Time Taken: " + (end - start) + " ns");
            }
        }
    }
}
