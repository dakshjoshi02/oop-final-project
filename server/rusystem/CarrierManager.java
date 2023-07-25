package ruunit;

import java.util.HashMap;
import java.util.List;

import common.Carrier;
import common.CommonType.FrequencyBand;
import common.CommonType.RFPort;

public class CarrierManager 
{   
    private static CarrierManager instance;
    HashMap<Integer, Carrier> carrierMap;

    private CarrierManager() {

    }

    public static CarrierManager getInstance() {
        if (instance == null) {
            synchronized (CarrierManager.class) {
                if (instance == null) {
                    instance = new CarrierManager();
                }
            }
        }
    }

    public void createLteCarrier (List<RFPort> rfPorts, FrequencyBand frequencyBand, double transmittingPower)
    {   
        Carrier c = new Carrier(rfPorts, frequencyBand, transmittingPower);
        carrierMap.put(c.getInteger(), c);
    }

    public void createWcdmaCarrier(List<RFPort> rfPorts, FrequencyBand frequencyBand, double transmittingPower)
    {
        Carrier c = new Carrier(rfPorts, frequencyBand, transmittingPower);
        carrierMap.put(c.getInteger(), c);
    }

    public boolean removeCarrier(Integer carrierId) {
        if (!carrierMap.containsKey(carrierId)) {
            return false;
        }

        carrierMap.remove(carrierId);
        return true;
    }

    public boolean removeAllCarriers() {
        carrierMap.clear();
        return true;
    }
}
