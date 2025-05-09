import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Step 2: Apply the annotation to a class
@Author(name = "John Doe")
class Book {
    // class implementation
}

// Step 3: Use reflection to retrieve the annotation
public class AnnotationReader {
    public static void main(String[] args) {
        // Get the Class object
        Class<Book> clazz = Book.class;

        // Check if the annotation is present
        if (clazz.isAnnotationPresent(Author.class)) {
            // Retrieve the annotation
            Author author = clazz.getAnnotation(Author.class);

            // Display the value
            System.out.println("Author name: " + author.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}

