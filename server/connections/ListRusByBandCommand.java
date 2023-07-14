package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public class ListRusByBandCommand extends Command
{
    private String bandFreq;

    public ListRusByBandCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() == 1)
        {
            bandFreq = inputs.get(0);
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
        
        // TODO: Write code that does what ListRusByBandCommand should do on the managedNetwork

        Response response = new Response(true, "Successfully executed ListRusByBandCommand");
        return response;
    }
}