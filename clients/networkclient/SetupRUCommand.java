package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class SetupRUCommand extends Command
{
    public SetupRUCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.SETUP_RU.ordinal() + ":";
        messageToBuild += super.execute();
        return messageToBuild;
    }
}