package common;

import alarmclient.CommandFactoryAlarm;
import networkclient.CommandFactoryNetwork;;

public abstract class CommandFactory
{
    public abstract Command createCommand(MenuOption menuOption);

    public static CommandFactory getInstance(String type)
    {
        if ("Network".equalsIgnoreCase(type))
        {
            return new CommandFactoryNetwork();
        }
        else if ("Alarm".equalsIgnoreCase(type))
        {
            return new CommandFactoryAlarm();
        }
        else
        {
            throw new IllegalArgumentException("Invalid CommandFactory type");
        }
    }
}