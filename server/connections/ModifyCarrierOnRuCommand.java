package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public class ModifyCarrierOnRuCommand extends Command
{
    private String ipAddress;
    private String carrierId;
    private String bandFreq;

    public ModifyCarrierOnRuCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() == 3)
        {
            ipAddress = inputs.get(0);
            carrierId = inputs.get(1);
            bandFreq = inputs.get(2);
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
        
        // TODO: Write code that does what ModifyCarrierOnRuCommand should do on the managedNetwork

        Response response = new Response(true, "Successfully executed ModifyCarrierOnRuCommand");
        return response;
    }
}