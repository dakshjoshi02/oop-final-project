package carriermanagement;

import java.util.List;

import common.*;

public class Carrier
{
    private Integer id;

    private RUVender ruVender;
    private RAT ratType;

    private FrequencyBand freqBand = FrequencyBand.LTE_BAND_1;
    private List<RFPort> rfPorts = null;
    private double transmittingPower;
    
    public Carrier(Integer carrierID, Integer vender, RAT rat, List<RFPort> rfPorts, FrequencyBand frequencyBand, double transmittingPower)
    {
        this.id = carrierID;
        switch (vender)
        {
            case 0:
                this.ruVender = RUVender.ERICSSON;
                break;
            case 1:
                this.ruVender = RUVender.NOKIA;
                break;
            case 2:
                this.ruVender = RUVender.Unknown;
                break;
            default:
                this.ruVender = RUVender.Unknown;
        }
        this.ratType = rat;
        this.rfPorts = rfPorts;
        this.freqBand = frequencyBand;
        this.transmittingPower = transmittingPower;
    }

    public Integer getID() {return this.id;}
    public void setID(Integer value) {this.id = value; }

    public RUVender getVender() {return this.ruVender;}
    public void setVender(RUVender value) {this.ruVender = value; }

    public RAT getRAT() {return this.ratType;}
    public void setRAT(RAT value) {this.ratType = value; }

    public FrequencyBand getBand() {return this.freqBand;}
    public void setBand(FrequencyBand value) {this.freqBand = value;}

    public double getPower() {return this.transmittingPower;}
    public void setPower(double value) {this.transmittingPower = value; }

}