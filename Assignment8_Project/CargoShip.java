
/**
 * CargoShip class represents a cargo ship with a cargo capacity in tonnage.
 * It extends the Ship class.
 */
public class CargoShip extends Ship {
    private int cargoCapacity;

    // Constructor
    public CargoShip(String name, String yearBuilt, int cargoCapacity) {
        super(name, yearBuilt);
        this.cargoCapacity = cargoCapacity;
    }

    // Accessor
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    // Mutator
    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    // toString method overrides the Ship's toString method
    @Override
    public String toString() {
        return "Cargo Ship Name: " + getName() + ", Cargo Capacity: " + getCargoCapacity() + " tons";
    }
}
