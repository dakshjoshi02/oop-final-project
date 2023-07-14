package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public class SetAlarmOnRuCommand extends Command
{
    private String ipAddress;
    private String alarmStatus;

    public SetAlarmOnRuCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() == 2)
        {
            ipAddress = inputs.get(0);
            alarmStatus = inputs.get(1);
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
        
        // TODO: Write code that does what SetAlarmOnRuCommand should do on the managedNetwork

        Response response = new Response(true, "Successfully executed SetAlarmOnRuCommand");
        return response;
    }
}