public class Laptop {
    private String model;
    private int ram;
    private int storageCapacity;
    private String operatingSystem;
    private String color;

    // Конструктор
    public Laptop(String model, int ram, int storageCapacity, String operatingSystem, String color) {
        this.model = model;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Геттеры
    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}    

