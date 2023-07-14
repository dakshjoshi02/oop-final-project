package connections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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
    
    private Command buildCommand(String commandString)
    {
        // All commandStrings should start with the command number followed by a ','
        List<String> inputParameters = new ArrayList<String>(Arrays.asList(commandString.split(",")));
        Event eventId = Event.END;
        
        if (inputParameters.size() > 0)
        {
            try
            {
                eventId = Event.values()[Integer.parseInt(inputParameters.get(0))];
                System.out.println(inputParameters.get(0));
                System.out.println(inputParameters.get(1));
                // Don't need the event ID after we've parsed it
                inputParameters.remove(0);
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Invalid command string");
            return null;
        }
        
        Command command = CommandFactory.getInstance().createCommand(eventId, inputParameters);
        
        return command;
    }
    
    public void run()
    {
        while(true)
        {
            // TODO: Delete the below lines of code. Only meant for testing purposes
            List<String> parameters = new ArrayList<String>();
            parameters.add("Test");
            
            // Test code, the socket will send a message as a string which needs to be parsed and converted into a valid command
            // NOTE: Conversion of complex types from string should be done in the individual commands (ie. Carrier)
            // To be done later
            String commandString = "0,192.168.0.1"; // 0 ==> COMMISSION_RU, 192.168.0.1 ==> ipAddress
            Command command = buildCommand(commandString);
            
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
