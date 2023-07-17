package rusystem;

import java.util.ArrayList;

public class Carrier {

    private static int globalId = 1;
    private final int id;
    private ArrayList<String> RFPorts; // TODO: type of rf ports
    private double transmittingPower;

    public Carrier() {
        this.id = globalId;
        ++globalId;
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
