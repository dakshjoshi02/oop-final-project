package alarmclient;

import common.Command;
import common.MenuOption;
import common.CommandFactory;
import common.StubCommand;
import java.util.Arrays;
import java.util.ArrayList;

public class CommandFactoryAlarm extends CommandFactory
{
    public Command createCommand(MenuOption menuOption)
    {
        switch (menuOption)
        {
            case GET_NETWORK_ALARMS:
                return new GetNetworkAlarmsCommand("Get Network Alarms", new ArrayList<String>());
            case ACKNOWLEDGE_ALARM:
                return new AcknowledgeAlarmCommand("Acknowledge Alarm", Arrays.asList("IP Address"));
            default:
                System.out.println("Invalid menuOption");
                return new StubCommand();
        }
    }
}