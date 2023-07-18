package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class DecommissionRUCommand extends Command
{
  public DecommissionRUCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.DECOMMISSION_RU.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}