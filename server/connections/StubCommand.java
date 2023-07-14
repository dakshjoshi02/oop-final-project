package connections;

import common.Response;

public class StubCommand extends Command
{
    @Override
    public Response execute()
    {
        Response response = new Response(true, "StubCommand::execute");
        return response;
    }
}