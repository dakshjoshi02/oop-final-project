package connections;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import networkmanagement.NetworkManagementController;
import common.Observer;
import common.Response;
import common.Event;

public class Connection implements Observer, Runnable
{
    private NetworkManagementController networkManagementController = null;
    private Socket socket = null;
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;
    Integer observerId = -1;
    
    public Connection(Socket socket, NetworkManagementController networkManagementController)
    {
        try
        {
            this.socket = socket;
            
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            
            // Register for the responses
            this.networkManagementController = networkManagementController;
            observerId = networkManagementController.registerObserver(this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private String retrieveMsg()
    {
        // Blocking call
        String msgFromClient = "";

        try
        {
            msgFromClient = (String) ois.readObject();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return msgFromClient;
    }

    private void sendMessage(String messageToClient)
    {
        try
        {
            oos.writeObject(messageToClient);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // What format are we using for the strings to be sent?
    private Command buildCommand(String msgFromClient)
    {
        // Each field of the string from the msgFromClient will be seperated by a :
        // Each variable inside of a field will be seperated by a ;
        List<String> inputParameters = new ArrayList<String>(Arrays.asList(msgFromClient.split(":")));
        Event eventId = Event.END;
        
        if (inputParameters.size() > 0)
        {
            try
            {
                eventId = Event.values()[Integer.parseInt(inputParameters.get(0))];
                System.out.println(eventId);
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
        // Bind the observerId (connection identifier) to the command, so we can get the response
        if (command != null)
        {
            command.observerId = observerId;
        }
        
        return command;
    }

    @Override
    public void sendResponse(Response response)
    {
        // Format this later
        sendMessage(response.responseMessage);
    }

    @Override
    public void run()
    {
        while (true)
        {
            String msgFromClient = retrieveMsg();
            System.out.println(msgFromClient);
            Command command = buildCommand(msgFromClient);
            if (command != null)
            {
                networkManagementController.addToProcessingQueue(command);
            }
        }
    }
}