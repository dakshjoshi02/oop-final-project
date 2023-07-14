package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public class ActivateRuCommand extends Command
{
    private String ipAddress;

    public ActivateRuCommand(String commandText, List<String> inputs) throws Exception
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
        
        // TODO: Write code that does what ActivateRuCommand should do on the managedNetwork

        Response response = new Response(true, "Successfully executed ActivateRuCommand");
        return response;
    }
}