
/**
 * CruiseShip class represents a cruise ship with a maximum number of passengers.
 * It extends the Ship class.
 */
public class CruiseShip extends Ship {
    private int maxPassengers;

    // Constructor
    public CruiseShip(String name, String yearBuilt, int maxPassengers) {
        super(name, yearBuilt);
        this.maxPassengers = maxPassengers;
    }

    // Accessor
    public int getMaxPassengers() {
        return maxPassengers;
    }

    // Mutator
    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    // toString method overrides the Ship's toString method
    @Override
    public String toString() {
        return "Cruise Ship Name: " + getName() + ", Max Passengers: " + getMaxPassengers();
    }
}
