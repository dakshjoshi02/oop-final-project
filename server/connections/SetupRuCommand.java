package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;
import carriermanagement.Carrier;
import carriermanagement.CarrierManager;

public class SetupRuCommand extends Command
{
    private String ipAddress;
    private Carrier carrier;

    public SetupRuCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
                
        if (inputs.size() == 2)
        {
            ipAddress = inputs.get(0);
            carrier = CarrierManager.Instance().createCarrier(inputs.get(1));
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
        
        // TODO: Write code that does what SetupRuCommand should do on the managedNetwork
        managedNetwork.setupRU(ipAddress, carrier);

        Response response = new Response(true, "Successfully executed SetupRuCommand");
        return response;
    }
}