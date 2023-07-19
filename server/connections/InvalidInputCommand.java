package connections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import rusystem.ManagedNetwork;
import common.Response;
import ruunit.CommonType.FrequencyBand;
import ruunit.CommonType.RFPort;
import ruunit.Carrier;

public class InvalidInputCommand extends Command
{
    public InvalidInputCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
    }

    @Override
    public Response execute()
    {
        Response response = new Response(false, "Invalid input was received");
        return response;
    }
}