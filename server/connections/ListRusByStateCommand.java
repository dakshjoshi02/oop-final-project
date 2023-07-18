package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;
import ruunit.CommonType.RUState;

public class ListRusByStateCommand extends Command
{
    private RUState ruState;

    public ListRusByStateCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() == 1)
        {
            ruState = RUState.values()[Integer.parseInt(inputs.get(0))];
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
        
        // TODO: Write code that does what ListRusByStateCommand should do on the managedNetwork

        Response response = new Response(true, "Successfully executed ListRusByStateCommand");
        return response;
    }
}