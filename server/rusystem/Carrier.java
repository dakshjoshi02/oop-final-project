package rusystem;

import java.util.HashSet;

public class Carrier {

    private static int globalId = 1;
    private final int id;
    private HashSet<RURFPorts> RFPorts;
    private HashSet<FrequencyBand> frequencyBand;
    private double transmittingPower;

    public Carrier() {
        this.id = globalId;
        ++globalId;
        RFPorts = new HashSet<RURFPorts>();
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
