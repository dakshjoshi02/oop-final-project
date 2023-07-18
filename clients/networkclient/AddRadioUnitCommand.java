package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class AddRadioUnitCommand extends Command
{
  public AddRadioUnitCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ADD_RADIO_UNIT.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}