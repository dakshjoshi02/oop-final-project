package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class CommissionRUCommand extends Command
{
  public CommissionRUCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.COMMISSION_RU.ordinal() + ":";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}