package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class SignalScalingOnRUCommand extends Command
{

  public SignalScalingOnRUCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.SIGNAL_SCALING_ON_RU.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}