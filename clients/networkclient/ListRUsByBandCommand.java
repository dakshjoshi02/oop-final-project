package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class ListRUsByBandCommand extends Command
{

  public ListRUsByBandCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_RUS_BY_BAND.ordinal() + ":";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}