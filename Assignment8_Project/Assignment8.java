
/**
 * Assignment8 class demonstrates the use of Ship, CruiseShip, and CargoShip classes.
 */
public class Assignment8 {
    public static void main(String[] args) {
        Ship[] ships = new Ship[9];

        // Create three Ship objects
        ships[0] = new Ship("SS Anne", "1995");
        ships[1] = new Ship("Titanic", "1912");
        ships[2] = new Ship("Queen Mary", "1936");

        // Create three CruiseShip objects
        ships[3] = new CruiseShip("Carnival Magic", "2011", 3650);
        ships[4] = new CruiseShip("Disney Dream", "2010", 4000);
        ships[5] = new CruiseShip("Oasis of the Seas", "2009", 5400);

        // Create three CargoShip objects
        ships[6] = new CargoShip("Evergreen", "2018", 200000);
        ships[7] = new CargoShip("Maersk", "2015", 180000);
        ships[8] = new CargoShip("Hanjin", "2012", 210000);

        // Display the information of each ship
        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }
    }
}
