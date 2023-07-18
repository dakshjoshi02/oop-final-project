package networkclient;

import common.Command;
import common.MenuOption;
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
    messageToBuild += super.execute();
    return messageToBuild;
  }
}