import java.util.ArrayList;

public class WarningExample {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Raw ArrayList (without generics)
        ArrayList list = new ArrayList();

        // Adding elements (no type safety here)
        list.add("Hello");
        list.add("World");

        // Casting back to generic (unchecked warning is suppressed)
        ArrayList<String> stringList = list;

        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
