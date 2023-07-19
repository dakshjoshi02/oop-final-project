package connections;

import java.net.Socket;
import java.io.InputStream;
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
            System.out.println("New client has connected!");
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

    private void sendMessage(String messageToClient)
    {
        try
        {
            oos.writeObject(messageToClient);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
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
        try
        {
            // Check for server side disconnects
            while (!socket.isClosed())
            {
                String msgFromClient = "";

                Object obj = ois.readObject();
                if (obj == null)
                {
                    socket.close();
                }
                msgFromClient = (String) obj;
                
                Command command = buildCommand(msgFromClient);
                if(command != null)
                {
                    networkManagementController.addToProcessingQueue(command);
                }
            }
            oos.close();
            ois.close();
        }
        catch(Exception e)
        {
            System.out.println("Client has disconnected");
        }
    }
}