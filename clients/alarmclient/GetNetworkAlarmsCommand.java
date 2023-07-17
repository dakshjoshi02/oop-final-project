package alarmclient;

import common.Command;
import java.util.List;

/*
 * @brief The command which will ask for details specific to AddAccountV1Command
 */
public class GetNetworkAlarmsCommand extends Command
{
  /*
   * @brief The constructor that sets member variables
   * @param outputText The text prompt to be displayed 
   * @param inputs The initial inputs to be asked for 
   */
  public GetNetworkAlarmsCommand(String outputText)
  {
    super(outputText);
  }

  /*
   * @brief The execute command which will ask for user input and build
   *        the related message to send to the server
   * @return The built message to send to the server
   */
  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.GET_NETWORK_ALARMS.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}