package ruunit;

import java.util.List;

import ruunit.CommonType.FrequencyBand;
import ruunit.CommonType.RFPort;

public class Carrier
{
    private static Integer globalId = 1;
    private final Integer id;
    private FrequencyBand freqBand;
    private List<RFPort> rfPorts;
    private double transmittingPower;
    
    public Carrier(List<RFPort> rfPorts, FrequencyBand frequencyBand, double transmittingPower)
    {
        this.id = globalId;
        ++globalId;
        this.rfPorts = rfPorts;
        this.freqBand = frequencyBand;
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