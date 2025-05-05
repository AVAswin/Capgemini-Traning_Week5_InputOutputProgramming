import java.io.*;
import java.util.*;

class Employee {
    public String name;
    public String email;
    public String number;

    Employee(String n, String e, String nu) {
        name = n;
        email = e;
        number = nu;
    }
}

class ConvertCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<Employee> list;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while((line = br.readLine()) != null) {
                
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
