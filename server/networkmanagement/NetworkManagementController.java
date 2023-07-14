package networkmanagement;

import java.util.List;

import common.Observer;
import common.Event;
import common.Response;
import connections.ConnectionManager;
import connections.Command;

public class NetworkManagementController implements Observer
{
    public NetworkManagementController()
    {
        // Create a connection manager thread and start it
        // This thread will run forever
        Thread connectionManagerThread = new Thread(ConnectionManager.getInstance());
        connectionManagerThread.start();
        
        // Register this class as an observer to the connection manager
        // so that this class can be notified about new events and respond to them
        ConnectionManager.getInstance().registerObserver(this);
    }
    
    public Response processEvent(Command command)
    {
        Response response = command.execute();

        return response;
    }
}
