package alarmclient;

import common.*;
import java.util.Arrays;

public class CommandFactoryAlarm extends CommandFactory {
    public Command createCommand(MenuOption menuOption) {
        switch (menuOption) {
            case GET_NETWORK_ALARMS:
                return new GetNetworkAlarmsCommand("Get Network Alarms", Arrays.asList("IP Address"));
            case ACKNOWLEDGE_ALARM:
                return new AcknowledgeAlarmCommand("Acknowledge Alarm", Arrays.asList("IP Address"));
            default:
                System.out.println("Invalid menuOption");
                return new StubCommand();
        }
    }
}