package networkmanagement;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import common.Subject;
import common.Observer;
import common.Event;
import common.Response;
import connections.ConnectionManager;
import connections.Command;

public class NetworkManagementController implements Subject
{
    private Map<Integer, Observer> observers = new HashMap<Integer, Observer>();
    
    private Queue<Command> processingQueue = new LinkedList<Command>();
    private final Object lock = new Object();
    
    public NetworkManagementController()
    {        
        // Spawn a thread for the server to accept new connections
        Thread connectionManagerThread = new Thread(new ConnectionManager(this));
        connectionManagerThread.start();
        
        // We'll use the main thread as a way to serialize the processing queue of commands
        controlLoop();
    }
    
    private void controlLoop()
    {
        while (true)
        {
            synchronized (lock)
            {
                if (processingQueue.size() > 0)
                {
                    Command command = processingQueue.remove();
                    System.out.println("Executing: \"" + command.commandText + "\" task");
                    Response response = command.execute();
                    System.out.println("Sending Response: \"" + command.commandText + "\" task");
                    notifyObserver(command.observerId, response);
                }
            }
            // Sleep for 100 ms
            try
            {
                Thread.sleep(100);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private Integer generateUniqueObserverId()
    {
        Random random = new Random();
        // Potential for infinite loop if there were alot of connections but this won't happen for our project
        Integer number = -1;
        while (true)
        {
            number = random.nextInt(1000000);
            if (!observers.containsKey(number))
            {
                break;
            }
        }
        return number;
    }
    
    public void addToProcessingQueue(Command command)
    {
        synchronized (lock)
        {
            System.out.println("Queuing: \"" + command.commandText + "\" task");
            processingQueue.add(command);
        }
    }
    
    public Integer registerObserver(Observer o)
    {
        Integer uniqueObserverId = -1;
        synchronized (lock)
        {
            uniqueObserverId = generateUniqueObserverId();
            observers.put(uniqueObserverId, o);
        }
        return uniqueObserverId;
    }

    public void removeObserver(Integer observerId)
    {
        synchronized (lock)
        {
            if (observers.containsKey(observerId))
            {
                observers.remove(observerId);
            }
        }
    }
    
    public void notifyObserver(Integer observerId, Response response)
    {
        synchronized (lock)
        {
            if (observers.containsKey(observerId))
            {
                observers.get(observerId).sendResponse(response);
            }
        }
    }
}
