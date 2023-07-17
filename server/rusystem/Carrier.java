package rusystem;

public class Carrier {

    private static int globalId = 1;
    private final int id;
    private FrequencyBand frequencyBand;
    private String port;
    private double transmittingPower;
    
    public Carrier(String port, FrequencyBand frequencyBand, double transmittingPower)
    {
        this.id = globalId;
        ++globalId;
        this.port = port;
        this.frequencyBand = frequencyBand;
        this.transmittingPower = transmittingPower;
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
