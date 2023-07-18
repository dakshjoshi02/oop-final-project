package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class SetupCarrierOnRUCommand extends Command
{

  public SetupCarrierOnRUCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.SETUP_CARRIER_ON_RU.ordinal() + ":";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}