package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public class CommissionRuCommand extends Command
{
    private String ipAddress;

    public CommissionRuCommand(String commandText, List<String> inputs) throws Exception
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
        Response response = managedNetwork.setupRU(ipAddress);
        if (response.isSuccessful)
        {
            response = managedNetwork.activateRU(ipAddress);
            if (response.isSuccessful)
            {
                response = managedNetwork.postActivation(ipAddress);
                if (response.isSuccessful)
                {
                    response = managedNetwork.performSignalScaling(ipAddress);
                    if (response.isSuccessful)
                    {
                        response = managedNetwork.performSelfDiagnostics(ipAddress);
                        if (response.isSuccessful)
                        {
                            response = new Response(true, "Successfully executed CommissionRuCommand");
                            return response;
                        }
                    }
                }
            }
        }

        // This will return the latest error message if something failed
        return response;
    }
}