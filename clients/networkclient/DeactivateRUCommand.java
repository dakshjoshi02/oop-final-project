package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class DeactivateRUCommand extends Command
{
    public DeactivateRUCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.DEACTIVATE_RU.ordinal() + ":";
        messageToBuild += super.execute();
        return messageToBuild;
    }
}