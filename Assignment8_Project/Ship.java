
/**
 * Ship class represents a basic ship with a name and the year it was built.
 */
public class Ship {
    private String name;
    private String yearBuilt;

    // Constructor
    public Ship(String name, String yearBuilt) {
        this.name = name;
        this.yearBuilt = yearBuilt;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    // Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    // toString method
    @Override
    public String toString() {
        return "Ship Name: " + getName() + ", Year Built: " + getYearBuilt();
    }
}
