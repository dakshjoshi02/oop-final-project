package alarmclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class GetNetworkAlarmsCommand extends Command
{

    public GetNetworkAlarmsCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.GET_NETWORK_ALARMS.ordinal() + ":";
        messageToBuild += super.execute();
        return messageToBuild;
    }
}