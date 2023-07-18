package networkclient;

import common.UI;
import common.ClientMessageHandler;
import common.MessageContainer;

public class NetworkClientMain {
    private static UI ui;
    private static ClientMessageHandler clientMessageHandler;

    /*
     * @brief The client loop that will loop forever
     */
    private static void clientLoop()
    {
        ui.printUI();
        String messageToServer = ui.retrieveUserInput();

        if (!messageToServer.isEmpty())
        {
        clientMessageHandler.sendMessage(messageToServer);
        MessageContainer messageContainer = clientMessageHandler.retrieveMessage();
        System.out.println("message container before display response: " + messageContainer.menuOption + " " + messageContainer.messageContents);
        ui.displayResponse(messageContainer);
        }
    }

    /*
     * @brief The main function that starts the program
     */
    
    public static void main(String[] args) {
        NetworkView view = new NetworkView();
        int port = 1234;
        clientMessageHandler = new ClientMessageHandler(port);
        while (true) {
        clientLoop();
        }
    }
}
