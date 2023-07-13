package networkmanagement;

import java.util.List;

import common.Observer;
import common.Event;
import connections.ConnectionManager;

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
    
    public String processEvent(Event event, List<String> parameters)
    {
        String response = "Recieved " + event + ". Parameters: ";
        for (int i = 0; i < parameters.size(); ++i)
        {
            if (i != parameters.size() - 1)
            {
                response += parameters.get(i) + ", ";
            }
            else
            {
                response += parameters.get(i);
            }
        }
        return response;
    }
}
