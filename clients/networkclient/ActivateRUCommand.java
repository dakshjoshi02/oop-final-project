package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class ActivateRUCommand extends Command
{

  public ActivateRUCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ACTIVATE_RU.ordinal() + ":";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}