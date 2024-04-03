public class Plane {
    private String make;
    private String model;
    private String name;
    private int number;
    private int altitude;

    public Plane (String make, String model, String name, int number) {
        this.make = make;
        this.model = model;
        this.name = name;
        this.number = number;
        this.altitude = 0; // Initialize the altitude to ground level
    }

    public void changeAltitude(int newAltitude) {
        if (newAltitude < 0) {
            System.out.println("Altitude cannot be negative.");
        } else {
            this.altitude = newAltitude;
            System.out.println(name + " is now at an altitude of " + newAltitude + " feet.");
        }
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getAltitude() {
        return altitude;
    }

    public static void main(String[] args) {
        Plane myPlane = new Plane("Boeing", "747", "Air Force One", 1);

        System.out.println("Make: " + myPlane.getMake());
        System.out.println("Model: " + myPlane.getModel());
        System.out.println("Name: " + myPlane.getName());
        System.out.println("Number: " + myPlane.getNumber());

        myPlane.changeAltitude(30000);
        myPlane.changeAltitude(0);
    }
}
