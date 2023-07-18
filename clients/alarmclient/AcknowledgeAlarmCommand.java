package alarmclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class AcknowledgeAlarmCommand extends Command
{

  public AcknowledgeAlarmCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ACKNOWLEDGE_ALARM.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}