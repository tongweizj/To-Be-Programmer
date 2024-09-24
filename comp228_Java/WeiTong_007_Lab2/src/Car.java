
enum CarType { "SUV","Hatchback","Sedan","Truck"}
public class Car {
    private String manufacturer;
    private int make;
    private String model;
    private static int VI_NUMBER = 1001;
    private int VIN;
    private double basePrice;
    private CarType type;

    public Car(String manufacturer, int make, String model, int VIN, double basePrice, CarType type) {
        this.manufacturer = manufacturer;
        this.make = make;
        this.model = model;
        this.VIN = VIN;
        this.basePrice = basePrice;
        this.type = type;
    }

    @Override
    public toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", make=" + make +
                ", model='" + model + '\'' +
                ", VIN=" + VIN +
                ", basePrice=" + basePrice +
                ", type=" + type +
                '}';
    }
}
