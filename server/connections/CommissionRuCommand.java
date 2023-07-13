package connections;

import java.util.List;

public class CommissionRuCommand extends Command
{
    private String ipAddress;

    public CommissionRuCommand(String commandText, List<String> inputs)
    {
        super(commandText);
        
        if (inputs.size() == 1)
        {
            ipAddress = inputs.get(0);
        }
        else
        {
            System.out.println("ABN: Wrong number of input strings passed to ctor()");
        }
    }

    @Override
    public String execute()
    {        
        String response = "Executing CommissionRuCommand";
      
        return response;
    }
}