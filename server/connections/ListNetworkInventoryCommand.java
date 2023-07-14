package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public class ListNetworkInventoryCommand extends Command
{
    public ListNetworkInventoryCommand(String commandText, List<String> inputs) throws Exception
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
        
        // TODO: Write code that does what ListNetworkInventoryCommand should do on the managedNetwork

        Response response = new Response(true, "Successfully executed ListNetworkInventoryCommand");
        return response;
    }
}