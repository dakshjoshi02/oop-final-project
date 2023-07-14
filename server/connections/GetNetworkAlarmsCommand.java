package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public class GetNetworkAlarmsCommand extends Command
{
    public GetNetworkAlarmsCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() != 0)
        {
            throw new Exception("ABN: Wrong number of input strings passed to ctor()");
        }
    }

    @Override
    public Response execute()
    {
        ManagedNetwork managedNetwork = ManagedNetwork.getInstance();
        
        // TODO: Write code that does what GetNetworkAlarmsCommand should do on the managedNetwork

        Response response = new Response(true, "Successfully executed GetNetworkAlarmsCommand");
        return response;
    }
}