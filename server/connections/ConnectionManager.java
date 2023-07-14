package connections;

import java.util.List;
import java.util.ArrayList;

import common.Subject;
import common.Observer;
import common.Event;
import common.Response;

public class ConnectionManager implements Subject, Runnable
{
    private List<Observer> observers = new ArrayList<Observer>();
    private static ConnectionManager instance = null;
    
    // Private constructor since it's a singleton
    private ConnectionManager()
    {
    }
    
    public static synchronized ConnectionManager getInstance()
    {
        if (instance == null)
        {
            instance = new ConnectionManager();
        }
        return instance;
    }
    
    public void run()
    {
        while(true)
        {
            // TODO: Delete the below lines of code. Only meant for testing purposes
            List<String> parameters = new ArrayList<String>();
            parameters.add("Test");
            
            Command command = CommandFactory.getInstance().createCommand(Event.COMMISSION_RU, parameters);
            if (command != null)
            {
                notifyObservers(command);
            }
            
            try
            {
                Thread.sleep(5000);
            }
            catch (Exception e)
            {
            }
            
            // Write code that accepts socket connections
            
            // Write code that gets a message from the socket connections
            
            // Parse the message into Event & String parameters
            
            // Call notifyObservers with the parsed message as a command
        }
    }
    
    public void registerObserver(Observer o)
    {
        observers.add(o);
    }
    
    public void removeObserver(Observer o)
    {
        if (observers.contains(o))
        {
            observers.remove(o);
        }
    }
    
    public void notifyObservers(Command command)
    {
        for (Observer observer : observers)
        {
            Response response = observer.processEvent(command);
            
            // Write code that responds to the connection that triggered the event
            // with the responseString
            System.out.println(response.responseMessage);
        }
    }
}
