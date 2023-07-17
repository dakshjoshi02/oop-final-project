// Placeholder for testing the server while the proper client is developped: TO BE DELETED
public class Client
{
  private static ClientMessageHandler clientMessageHandler;

  /*
   * @brief The client loop that will loop forever
   */
  private static void clientLoop()
  {
    // Format will be the following...
    // Start with the command ENUM (Event.java - COMMISSION_RU => 0, DECOMMISSION_RU => 1)
    // Seperate all fields with a ':'
    // If it is a complex type, seperate the inner fields with ;
    // Example: COMMISSION_RU - COMMISSION_RU => 0, IP => 192.168.0.1
    //String messageToServer = "0:192.168.0.1:";
    
    // Another example: SETUP_CARRIER_ON_RU => 8, IP => 192.168.0.1, RfPort A; 0 => Frequency LTE_BAND_1; TX Power 80
    String messageToServer = "8:192.168.0.1:A;0;80:";

    if (!messageToServer.isEmpty())
    {
      clientMessageHandler.sendMessage(messageToServer);
    }
  }

  /*
   * @brief The main function that starts the program
   */
  public static void main(String[] args) 
  {
    int port = 8080;
    clientMessageHandler = new ClientMessageHandler(port);

    while (true)
    {
      clientLoop();
      try
      {
        Thread.sleep(10000);
      }
      catch(Exception e)
      {
        System.out.println("Error occurred during sleep");
      }
    }
  }
}