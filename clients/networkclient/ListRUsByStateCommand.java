package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class ListRUsByStateCommand extends Command
{

  public ListRUsByStateCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_RUS_BY_STATE.ordinal() + ":";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}