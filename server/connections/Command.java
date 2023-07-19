package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import common.Response;

public abstract class Command 
{
    public String commandText;
    public Integer observerId;
    
    // Needed for stub command
    public Command()
    {
    }
    
    public Command(String commandText)
    {
        this.commandText = commandText;
    }

    public abstract Response execute();
}