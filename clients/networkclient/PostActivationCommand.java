package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class PostActivationCommand extends Command
{
    public PostActivationCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.POST_ACTIVATION.ordinal() + ":";
        messageToBuild += super.execute();
        return messageToBuild;
    }
}