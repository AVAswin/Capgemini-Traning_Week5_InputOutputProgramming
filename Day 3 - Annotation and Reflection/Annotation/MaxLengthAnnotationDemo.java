import java.lang.annotation.*;
import java.lang.reflect.*;

// Main class
public class MaxLengthAnnotationDemo {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface MaxLength {
        int value();
    }

    static class User {
        @MaxLength(10)
        private String username;

        public User(String username) {
            this.username = username;

            // Validate using reflection
            for (Field field : this.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(MaxLength.class)) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(this);
                        if (value instanceof String str) {
                            int max = field.getAnnotation(MaxLength.class).value();
                            if (str.length() > max) {
                                throw new IllegalArgumentException("Field " + field.getName()
                                        + " exceeds max length of " + max);
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("\n✅ Validating @MaxLength on User class:");
        try {
            User user1 = new User("ShortName"); // valid
            System.out.println("User1 created successfully.");

            User user2 = new User("ThisNameIsWayTooLong"); // invalid
            System.out.println("User2 created successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }
    }
}
