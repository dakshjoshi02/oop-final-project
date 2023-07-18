package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class RemoveAllCarriersOnRUCommand extends Command
{

  public RemoveAllCarriersOnRUCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.REMOVE_ALL_CARRIERS_ON_RU.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}