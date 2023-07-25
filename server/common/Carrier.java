package common;

import java.util.List;

import common.CommonType.RFPort;

public class Carrier
{
    private static Integer globalId = 1;
    private final Integer id;

    public int getInteger() {
		return this.id;
	}

    private String freqBand;

    private List<RFPort> rfPorts;
    private double transmittingPower;

    public List<RFPort> getRfPorts() {
        return this.rfPorts;
    }

    public Carrier(List<RFPort> rfPorts, String frequencyBand, double transmittingPower)
    {
        this.id = globalId;
        ++globalId;
        this.rfPorts = rfPorts;
        this.freqBand = frequencyBand;
        this.transmittingPower = transmittingPower;
    }

    public String getFreqBand() {
        return this.freqBand;
    }

    public void setFreqBand(String freqBand) {
        this.freqBand = freqBand;
    }

    public void setRfPorts(List<RFPort> rfPorts) {
        this.rfPorts = rfPorts;
    }

    public double getTransmittingPower() {
        return this.transmittingPower;
    }

    public void setTransmittingPower(double transmittingPower) {
        this.transmittingPower = transmittingPower;
    }
    
}