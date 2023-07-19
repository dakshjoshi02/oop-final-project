package common;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientMessageHandler
{
    private final int port;
    private final int RETRY_TIME = 10; // 10 seconds
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ClientMessageHandler(int port)
    {
        this.port = port;
        boolean isSuccessful = false;
        while (!isSuccessful)
        {
            System.out.println("Attempting to connect to the server...");
            isSuccessful = attemptToConnect();
            if (!isSuccessful)
            {
                System.out.println("Retrying in " + RETRY_TIME + " seconds...");
                try
                {
                    Thread.sleep(RETRY_TIME * 1000);
                }
                catch(Exception e)
                {
                    System.out.println("Error occurred during sleep");
                }
            }
        }
    }

    public boolean attemptToConnect()
    {
        boolean isSuccessful = false;
        try
        {
            InetAddress host = InetAddress.getLocalHost();
            socket = new Socket(host.getHostName(), port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            isSuccessful = true;
            System.out.println("Successfully connected to the the server!");
        }
        catch(Exception e)
        {
            System.out.println("Connection attempt to server was unsuccessful!");
        }
        return isSuccessful;
    }

    public void sendMessage(String messageToServer)
    {
        try
        {
            oos.writeObject(messageToServer);
        }
        catch(Exception e)
        {
            System.out.println("Error occurred sending a message");
        }
    }

    public Response retrieveMessage()
    {
        Response response = new Response();
        try
        {
            String responseString = (String) ois.readObject();
            response = parseServerMessage(responseString);
        }
        catch(Exception e)
        {
            System.out.println("Error occurred retrieving a message");
        }
        return response;
    }

    public Response parseServerMessage(String messageFromServer)
    {
        Response response = new Response();
        
        List<String> responseSegments = new ArrayList<String>(Arrays.asList(messageFromServer.split(":")));
        
        if (responseSegments.size() != 2)
        {
            new Response(false, "The response from the server is malformed");
        }
        
        boolean isSuccessful = responseSegments.get(0).equals("1");
        String responseString = responseSegments.get(1);
        return new Response(isSuccessful, responseString);
    }
}