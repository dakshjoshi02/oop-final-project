package networkclient;

import common.Command;
import common.MenuOption;
import common.RUAlarmStatusLevels;
import java.util.List;

public class SetAlarmOnRUCommand extends Command
{
    public SetAlarmOnRUCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.SET_ALARM_ON_RU.ordinal() + ":";
        
        // IP Address
        System.out.print("Please enter the \'" + inputs.get(0) + "\': ");
        String ipAddress = System.console().readLine();
        messageToBuild += ipAddress + ":";
        
        System.out.println("The below options are the available alarm statuses");
        System.out.println("---------------------------------------------------");
        for (RUAlarmStatusLevels alarmStatus : RUAlarmStatusLevels.values())
        { 
            System.out.println(alarmStatus.ordinal() + " => " + alarmStatus);
        }
        System.out.print("Please select the alarm status (ie. \"0\", \"2\", \"6\"): ");
        String alarmStatus = System.console().readLine();
        messageToBuild += alarmStatus + ":";
        
        return messageToBuild;
    }
}