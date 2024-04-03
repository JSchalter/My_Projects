package Project4;
import java.util.*;

public class TriageSimulator{

    Queue<String>  highPriorityQueue = new LinkedList<>();
    Queue<String> midPriorityQueue = new LinkedList<>();
    Queue<String> lowPriorityQueue = new LinkedList<>();

    /**
     * 
     */
    public TriageSimulator() {
    }

    public static TriageSimulator createTriageSimulator() {
        return new TriageSimulator();
    }

    @Override
    public String toString() {
        return "TriageSimulator{" + "highPriorityQueue=" + highPriorityQueue
                + ", midPriorityQueue=" + midPriorityQueue + ", lowPriorityQueue="
                + lowPriorityQueue + '}';
    }

    public void add(String patientInfo) {
        if(patientInfo.contains("AL") || patientInfo.contains("HA") ||
                patientInfo.contains("ST")) {
            highPriorityQueue.add(patientInfo);
        } else if (patientInfo.contains("BL") || patientInfo.contains("IW") ||
                patientInfo.contains("KS") || patientInfo.contains("OT")) {
            midPriorityQueue.add(patientInfo);
        } else if(patientInfo.contains("HN")) {
            lowPriorityQueue.add(patientInfo);
        }
    }

    public Object remove() {
        Object patientToRemove = "";

        if(!highPriorityQueue.isEmpty()) {
            patientToRemove = highPriorityQueue.remove();
        } else if(!midPriorityQueue.isEmpty()) {
            patientToRemove = midPriorityQueue.remove();
        } else if(!lowPriorityQueue.isEmpty()) {
            patientToRemove = lowPriorityQueue.remove();
        }

        return patientToRemove;
    }

    public boolean isEmpty() {
        return highPriorityQueue.isEmpty() && midPriorityQueue.isEmpty() && lowPriorityQueue.isEmpty();
    }

} // end TriageSimulator
