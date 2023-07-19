package alarmclient;

import common.UI;
import common.ClientMessageHandler;
import common.MessageContainer;

public class AlarmClientMain {
    private static UI ui;
    private static ClientMessageHandler clientMessageHandler;

    private static void clientLoop()
    {
        ui.printUI();
        String messageToServer = ui.retrieveUserInput();

        if (!messageToServer.isEmpty())
        {
            clientMessageHandler.sendMessage(messageToServer);
            MessageContainer messageContainer = clientMessageHandler.retrieveMessage();
            ui.displayResponse(messageContainer);
        }
    }

    public static void main(String[] args)
    {
        ui = new AlarmView();
        final int PORT = 8080;
        clientMessageHandler = new ClientMessageHandler(PORT);
        while (true)
        {
            clientLoop();
        }
    }
}
