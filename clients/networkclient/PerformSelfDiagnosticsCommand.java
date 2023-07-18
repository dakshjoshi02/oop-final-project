package networkclient;

import common.Command;
import common.MenuOption;
import java.util.List;

public class PerformSelfDiagnosticsCommand extends Command
{
    public PerformSelfDiagnosticsCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.PERFORM_SELF_DIAGNOSTICS.ordinal() + ":";
        messageToBuild += super.execute();
        return messageToBuild;
    }
}