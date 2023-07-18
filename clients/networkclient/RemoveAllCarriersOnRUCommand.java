package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

/*
 * @brief The command which will ask for details specific to AddAccountV1Command
 */
public class RemoveAllCarriersOnRUCommand extends Command
{
  /*
   * @brief The constructor that sets member variables
   * @param outputText The text prompt to be displayed 
   * @param inputs The initial inputs to be asked for 
   */
  public RemoveAllCarriersOnRUCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  /*
   * @brief The execute command which will ask for user input and build
   *        the related message to send to the server
   * @return The built message to send to the server
   */
  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.REMOVE_ALL_CARRIERS_ON_RU.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}