package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class ListRadioUnitDetailsCommand extends Command
{
    public ListRadioUnitDetailsCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.LIST_RADIO_UNIT_DETAILS.ordinal() + ":";
        messageToBuild += super.execute();
        return messageToBuild;
    }
}