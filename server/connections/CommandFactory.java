package connections;

import java.util.List;
import java.util.Arrays;

import common.Event;

public class CommandFactory
{  
    private static CommandFactory instance = null;

    private CommandFactory()
    {
    }

    public static synchronized CommandFactory getInstance()
    {
        if (instance == null)
        {
            instance = new CommandFactory();
        }
        return instance;
    }
  
    public Command createCommand(Event event, List<String> parameters)
    {
        switch(event)
        {
            case COMMISSION_RU:
                return new CommissionRuCommand("Commission RU", parameters);

            default:
                System.out.println("Invalid event");
                return new StubCommand();
        }
    }
}