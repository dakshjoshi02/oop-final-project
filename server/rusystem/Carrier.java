package rusystem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class Carrier {

    private static int globalId = 1;
    private final int id;
    private ArrayDeque<String> portQueue; 
    private HashSet<FrequencyBand> frequencyBand;
    private HashSet<String> ports;
    private double transmittingPower;
    private final static int NUM_OF_PORTS = 8;

    public Carrier() {
        this.id = globalId;
        ++globalId;
        this.portQueue = new ArrayDeque<String>();
        this.ports = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"));
        for (String port : ports) {
            portQueue.add(port);
        }
    }

    public boolean createLteCarrier() {
        // TODO: create lte carrier with set of input attributes
        return true;
    }

    public boolean createWcdmaCarrier() {
        // TODO: create wcdma carrier with set of input attributes
        return true;
    }
}
