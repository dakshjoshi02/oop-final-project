package common;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
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

  public MessageContainer retrieveMessage()
  {
    MessageContainer messageContainer = new MessageContainer();
    try
    {
      String responseMessageFromServer = (String) ois.readObject();
      messageContainer = parseServerMessage(responseMessageFromServer);
    }
    catch(Exception e)
    {
      System.out.println("Error occurred retrieving a message");
    }
    System.out.println("message retrieved from server: " + messageContainer.menuOption + " " + messageContainer.messageContents);
    return messageContainer;
  }

  public MessageContainer parseServerMessage(String messageFromServer)
  {
    MessageContainer messageContainer = new MessageContainer();
    boolean isSuccessful = false;
    try
    {
      String messageOption = "20";
      System.out.println("message length: " + messageFromServer.length());
      for (int i = 0; i < messageFromServer.length(); i++) {
        System.out.println("message char: " + messageFromServer.charAt(i));
        if (messageFromServer.charAt(i) == '=') {
          messageOption = messageFromServer.substring(0, i);
          MenuOption selectedOption = MenuOption.values()[Integer.parseInt(messageOption)];
          messageContainer.menuOption = selectedOption;
          isSuccessful = (Integer.parseInt(messageFromServer.substring(i + 1, i + 2)) == 1);
          System.out.println("message from server: " + messageFromServer + " isSuccessful: " + isSuccessful);
          messageContainer.isSuccessful = isSuccessful;
          String msg = messageFromServer.substring(i + 3, messageFromServer.length());
          System.out.println("messages part only: " + msg);
          messageContainer.messageContents = new ArrayList<String>(Arrays.asList(msg.split(" ")));
          break;
        }
      }

      System.out.println("messageOption: " + messageOption);
      System.out.println("message successful: " + isSuccessful);
      System.out.println("messageContents: " + messageContainer.messageContents);
    }
    catch(Exception e)
    {
      System.out.println("Error parsing the message from the server");
    }
    return messageContainer;
  }
}