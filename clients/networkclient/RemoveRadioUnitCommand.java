package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class RemoveRadioUnitCommand extends Command
{
  public RemoveRadioUnitCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.REMOVE_RADIO_UNIT.ordinal() + ":";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}