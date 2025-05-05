



import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Car {
    private String brand;
    private String model;
    private int year;

    // Constructors
    public Car() {}
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters and Setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}

public class ConvertListToJsonArray {
    public static void main(String[] args) {
        try {
            List<Car> cars = Arrays.asList(
                new Car("Toyota", "Camry", 2020),
                new Car("Honda", "Civic", 2022),
                new Car("Ford", "Focus", 2019)
            );

            ObjectMapper mapper = new ObjectMapper();

            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
