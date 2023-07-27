package connections;

import java.util.List;

import carriermanagement.Carrier;
import rusystem.ManagedNetwork;
import common.Response;

public class AddRadioUnitCommand extends Command
{
    private String ipAddress;
    private Carrier carrier;

    public AddRadioUnitCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() == 1)
        {
            ipAddress = inputs.get(0);
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
        
        // TODO: Write code that does what AddRadioUnitCommand should do on the managedNetwork
        managedNetwork.addRadioUnit(ipAddress, carrier);

        Response response = new Response(true, "Successfully executed AddRadioUnitCommand");
        return response;
    }
}