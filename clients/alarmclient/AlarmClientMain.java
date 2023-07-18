package alarmclient;

import common.UI;
import common.ClientMessageHandler;
import common.MessageContainer;

public class AlarmClientMain {
    private static UI ui;
    private static ClientMessageHandler clientMessageHandler;

    private static void clientLoop()
    {
        System.out.println("TEST");
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

    public static void main(String[] args)
    {
        AlarmView view = new AlarmView();
        final int PORT = 8080;
        clientMessageHandler = new ClientMessageHandler(PORT);
        while (true)
        {
            clientLoop();
        }
    }
}
