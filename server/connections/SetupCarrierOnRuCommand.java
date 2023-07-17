package connections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import rusystem.ManagedNetwork;
import common.Response;
import rusystem.FrequencyBand;
import rusystem.Carrier;

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
            System.out.println(carrierAsString);
            List<String> carrierSegments = new ArrayList<String>(Arrays.asList(carrierAsString.split(";")));
            if (carrierSegments.size() == 3)
            {
                String port = carrierSegments.get(0);
                System.out.println(port);
                FrequencyBand frequencyBand = FrequencyBand.values()[Integer.parseInt(carrierSegments.get(1))];
                System.out.println(frequencyBand);
                double transmittingPower = Double.parseDouble(carrierSegments.get(2));
                System.out.println(transmittingPower);
                carrier = new Carrier(port, frequencyBand, transmittingPower);
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