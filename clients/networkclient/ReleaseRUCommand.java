package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class ReleaseRUCommand extends Command
{

  public ReleaseRUCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.RELEASE_RU.ordinal() + ":";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}