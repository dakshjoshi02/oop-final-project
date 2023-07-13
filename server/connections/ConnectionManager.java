package connections;

import java.util.List;
import java.util.ArrayList;

import common.Subject;
import common.Observer;
import common.Event;

public class ConnectionManager implements Subject, Runnable
{
    List<Observer> observers = new ArrayList<Observer>();
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
            notifyObservers(Event.COMMISSION_RU, parameters);
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
            
            // Call notifyObservers with the parsed message
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
    
    public void notifyObservers(Event event, List<String> parameters)
    {
        for (Observer observer : observers)
        {
            String responseString = observer.processEvent(event, parameters);
            
            // Write code that responds to the connection that triggered the event
            // with the responseString
            System.out.println(responseString);
        }
    }
}
