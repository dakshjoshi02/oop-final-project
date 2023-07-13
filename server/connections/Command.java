package connections;

import java.util.List;

public abstract class Command
{
    private String commandText;
    
    // Needed for stub command
    public Command()
    {
    }
    
    public Command(String commandText)
    {
        this.commandText = commandText;
    }

    public abstract String execute();
}