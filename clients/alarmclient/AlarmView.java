package alarmclient;

import java.util.Map;
import java.util.TreeMap;
import common.UI;
import common.MessageContainer;
import common.Command;
import common.CommandFactory;
import common.MenuOption;

public class AlarmView implements UI {
    private Map<MenuOption, Command> alarmClientMap;

    public AlarmView()
    {
        alarmClientMap = createMap();
    }

    @Override
    public void printUI()
    {
        System.out.println();
        System.out.println("========== Please Enter A Menu Option ==========");
        for (Map.Entry<MenuOption, Command> mapEntry : alarmClientMap.entrySet())
        {
            System.out.print(mapEntry.getKey().ordinal() + 1 + ". ");
            System.out.print(mapEntry.getValue().outputText + " ");

            if (mapEntry.getValue().inputs.size() != 0)
            {
                System.out.print("<");
                for (int i = 0; i < mapEntry.getValue().inputs.size(); ++i)
                {
                    System.out.print(mapEntry.getValue().inputs.get(i));
                    if (i != mapEntry.getValue().inputs.size() - 1)
                    {
                        System.out.print(", ");
                    }
                }
                System.out.print(">");
            }
            System.out.println();
        }
    }

    @Override
    public void displayResponse(MessageContainer messageContainer)
    {
        String messageResult = messageContainer.isSuccessful ? "SUCCESS" : "INPUT ERROR";

        System.out.println("\n==============================");
        System.out.println("OPERATION: " + messageContainer.menuOption + " = " + messageResult);
        System.out.println("Content: " + messageContainer.messageContents);
        System.out.println("==============================");
    }

    private Map<MenuOption, Command> createMap()
    {
        Map<MenuOption, Command> newMap = new TreeMap<MenuOption, Command>();
        for (MenuOptionAlarm menuOption : MenuOptionAlarm.values())
        {
            // Need to convert from MenuOptionAlarm enum to MenuOption to work with the factory
            MenuOption overallMenuOption = MenuOption.values()[menuOption.getValue()];
            Command newCommand = CommandFactory.getInstance("Alarm").createCommand(overallMenuOption);
            newMap.put(overallMenuOption, newCommand);
        }
        return newMap;
    }

    @Override
    public String retrieveUserInput()
    {
        final int lastMenuVal = MenuOptionAlarm.values()[MenuOptionAlarm.values().length - 1].ordinal() + 1;
        System.out.print(" > ");
        String userInput = System.console().readLine();
        String messageToServer = "";

        if (userInput.equalsIgnoreCase("q") || userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("exit"))
        {
            System.exit(0);
        }

        try
        {
            int menuOption = Integer.parseInt(userInput);

            if (menuOption > 0 && menuOption < (lastMenuVal + 1))
            {
                MenuOptionAlarm selectedOption = MenuOptionAlarm.values()[menuOption - 1];
                Command commandToExecute = alarmClientMap.get(selectedOption);
                messageToServer = commandToExecute.execute();
            }
            else
            {
                throw new Exception("Invalid number");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: Number expected between 1 and " + lastMenuVal);
        }
        return messageToServer;
    }
}
