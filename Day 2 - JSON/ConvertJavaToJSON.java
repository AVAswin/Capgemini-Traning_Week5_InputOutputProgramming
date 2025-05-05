// To convert java code to JSON (Using Jackson or Gson)

// Using Jackson (Add to Maven)
// <dependency>
//   <groupId>com.fasterxml.jackson.core</groupId>
//   <artifactId>jackson-databind</artifactId>
//   <version>2.15.0</version>
// </dependency>

// Then import
// import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

class Car {
    private String make;
    private String model;
    private int year;
    private String[] features;

    public Car(String make, String model, int year, String[] features) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.features = features;
    }

    // Getters and setters can be added if needed
}

class ConvertJavaToJSON {
    public static void main(String[] args) throws Exception {
        Car car = new Car("Toyota", "Camry", 2021, new String[]{"Bluetooth", "Backup Camera"});

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(car);

        System.out.println(json);
    }
}

