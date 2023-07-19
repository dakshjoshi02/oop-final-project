package connections;

import java.net.ServerSocket;
import java.net.Socket;

import common.Subject;
import common.Observer;
import common.Response;
import networkmanagement.NetworkManagementController;

public class ConnectionManager implements Runnable
{
    private NetworkManagementController networkManagementController = null;
    
    public ConnectionManager(NetworkManagementController networkManagementController)
    {
        this.networkManagementController = networkManagementController;
    }
    
    @Override
    public void run()
    {
        final int PORT = 8080;
        ServerSocket serverSocket = null;
        Socket socket = null;
        
        // Create the server socket where clients will attempt to connect
        try
        {
            serverSocket = new ServerSocket(PORT);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        // The main thread will stay in this loop forever
        System.out.println("The server is awaiting new connections...");
        while(true)
        {
            try
            {
                // Blocking call, moves forward when a new connection connects
                socket = serverSocket.accept();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            // Spawn a thread for the new connection, the server thread doesn't care about the life span of the thread
            // We could store this information if we want to update the observers during runtime (but not needed for this project)
            new Thread(new Connection(socket, networkManagementController)).start();
        }
    }
}