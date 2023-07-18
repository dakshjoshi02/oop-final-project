package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class ModifyCarrierOnRUCommand extends Command
{

  public ModifyCarrierOnRUCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.MODIFY_CARRIER_ON_RU.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}