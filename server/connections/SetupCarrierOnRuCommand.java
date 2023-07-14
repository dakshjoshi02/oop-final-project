package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public class SetupCarrierOnRuCommand extends Command
{
    private String ipAddress;
    private String carrier;

    public SetupCarrierOnRuCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() == 2)
        {
            ipAddress = inputs.get(0);
            carrier = inputs.get(1);
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