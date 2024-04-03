package Project4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriageDemo {

    public static void main(String[] args) throws FileNotFoundException {

        File triageFile = new File("Project4/TriageList.txt");
        if (!triageFile.exists()) {
            System.exit(0);
        }

        TriageSimulator triageSimulator = new TriageSimulator();

        System.out.println("\n*** Initializing... ***\n");
        System.out.println("The contents of the file include: \n");

        Scanner scanner = new Scanner(triageFile);

        while (scanner.hasNext()) {
            String patientInfo = scanner.nextLine();
            System.out.println(patientInfo);
            triageSimulator.add(patientInfo);
        }

        System.out.println("\n*** File-reading complete. ***\n");

        System.out.println("\nHospital Priority Queue:\n");

        while (!triageSimulator.isEmpty()) {
            System.out.println(triageSimulator.remove());
        }

        scanner.close();

    } // end main

} // end TriageDemo
