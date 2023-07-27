package networkclient;

import common.Command;
import common.MenuOption;
import common.RAT;
import java.util.List;

public class ListRUsByStandardCommand extends Command
{
    public ListRUsByStandardCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.LIST_RUS_BY_STANDARD.ordinal() + ":";
        
        System.out.println("The below options are the available RAT types");
        System.out.println("---------------------------------------------------");
        for (RAT ratType : RAT.values())
        { 
            System.out.println(ratType.ordinal() + " => " + ratType);
        }
        System.out.print("Please select the RAT type (ie. \"0\", \"3\", \"4\"): ");
        String ratType = System.console().readLine();
        messageToBuild += ratType + ":";
        
        return messageToBuild;
    }
}