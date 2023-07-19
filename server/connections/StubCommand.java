package connections;

import common.Response;

public class StubCommand extends Command
{
    public StubCommand(String commandText)
    {
        this.commandText = commandText;
    }
    
    @Override
    public Response execute()
    {
        Response response = new Response(false, "Invalid input");
        return response;
    }
}