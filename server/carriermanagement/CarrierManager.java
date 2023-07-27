package carriermanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import common.*;

public class CarrierManager 
{
    static CarrierManager instance = null;
    public static CarrierManager Instance()
    {
        if(instance == null) instance = new CarrierManager();

        return instance;
    }


    int lastCarrierID = 0;
    
    HashMap<Integer, Carrier> carrierList = new HashMap<>();

    public Carrier createCarrier(String message)
    {
        List<String> carrierSegments = new ArrayList<String>(Arrays.asList(message.split(";")));

        if (carrierSegments.size() == 4)
        {
            List<String> strPorts = new ArrayList<String>(Arrays.asList(carrierSegments.get(0).split("-")));
            List<RFPort> rfPortList = new ArrayList<RFPort>();
            for (String strPort : strPorts)
            {
                rfPortList.add(RFPort.values()[Integer.parseInt(strPort)]);
                System.out.println(strPort);
            }

            FrequencyBand frequencyBand = FrequencyBand.values()[Integer.parseInt(carrierSegments.get(1))];
            double transmittingPower = Double.parseDouble(carrierSegments.get(2));
            Integer ruVender = Integer.parseInt(carrierSegments.get(3));

            int portCount = rfPortList.size();

            switch(portCount)
            {
                case 4:
                {
                    lastCarrierID ++;
                    
                    Carrier carrier = new Carrier(lastCarrierID, ruVender, RAT.LTE_FDD, rfPortList, frequencyBand, transmittingPower);
                    carrierList.put(carrier.getID(), carrier);
                    return carrier;
                }

                case 2:
                {
                    lastCarrierID ++;
                    
                    Carrier carrier = new Carrier(lastCarrierID, ruVender, RAT.WCDMA, rfPortList, frequencyBand, transmittingPower);
                    carrierList.put(carrier.getID(), carrier);
                    return carrier;
                }
                
                default:
                {
                    lastCarrierID ++;
                    
                    Carrier carrier = new Carrier(lastCarrierID, ruVender, RAT.Unknown, rfPortList, frequencyBand, transmittingPower);
                    carrierList.put(carrier.getID(), carrier);
                    return carrier;                    
                }
            }
        }
        
        return null;
    }
}
