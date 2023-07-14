package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public class ListRusByStandardCommand extends Command
{
    private String ratType;

    public ListRusByStandardCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() == 1)
        {
            ratType = inputs.get(0);
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
        
        // TODO: Write code that does what ListRusByStandardCommand should do on the managedNetwork

        Response response = new Response(true, "Successfully executed ListRusByStandardCommand");
        return response;
    }
}