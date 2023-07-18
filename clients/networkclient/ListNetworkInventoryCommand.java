package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class ListNetworkInventoryCommand extends Command
{
  public ListNetworkInventoryCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_NETWORK_INVENTORY.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}