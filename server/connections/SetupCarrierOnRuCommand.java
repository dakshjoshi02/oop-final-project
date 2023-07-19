package connections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import rusystem.ManagedNetwork;
import common.Response;
import common.CommonType.FrequencyBand;
import common.CommonType.RFPort;
import common.Carrier;

public class SetupCarrierOnRuCommand extends Command
{
    private String ipAddress;
    private Carrier carrier;

    public SetupCarrierOnRuCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() == 2)
        {
            ipAddress = inputs.get(0);
            String carrierAsString = inputs.get(1);

            List<String> carrierSegments = new ArrayList<String>(Arrays.asList(carrierAsString.split(";")));
            if (carrierSegments.size() == 3)
            {
                List<String> strPorts = new ArrayList<String>(Arrays.asList(carrierSegments.get(0).split("-")));
                if (strPorts.size() == 0)
                {
                    throw new Exception("ABN: Wrong number of input strings passed to ctor()");
                }
                List<RFPort> rfPorts = new ArrayList<RFPort>();
                for (String strPort : strPorts)
                {
                    rfPorts.add(RFPort.values()[Integer.parseInt(strPort)]);
                }
                FrequencyBand frequencyBand = FrequencyBand.values()[Integer.parseInt(carrierSegments.get(1))];
                double transmittingPower = Double.parseDouble(carrierSegments.get(2));
                carrier = new Carrier(rfPorts, frequencyBand, transmittingPower);
            }
            else
            {
                throw new Exception("ABN: Wrong number of input strings passed to ctor()");
            }
        }
        else
        {
            throw new Exception("ABN: Wrong number of input strings passed to ctor()");
        }
    }

    @Override
    public Response execute()
    {
        ManagedNetwork managedNetwork = ManagedNetwork.getInstance();
        
        // TODO: Write code that does what SetupCarrierOnRuCommand should do on the managedNetwork

        Response response = new Response(true, "Successfully executed SetupCarrierOnRuCommand");
        return response;
    }
}