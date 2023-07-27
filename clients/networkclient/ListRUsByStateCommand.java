package networkclient;

import common.Command;
import common.MenuOption;
import common.RUState;
import java.util.List;

public class ListRUsByStateCommand extends Command
{
    public ListRUsByStateCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.LIST_RUS_BY_STATE.ordinal() + ":";
        
        System.out.println("The below options are the available RU states");
        System.out.println("---------------------------------------------------");
        for (RUState ruState : RUState.values())
        { 
            System.out.println(ruState.ordinal() + " => " + ruState);
        }
        System.out.print("Please select the RU state (ie. \"0\", \"1\", \"2\"): ");
        String ruState = System.console().readLine();
        messageToBuild += ruState + ":";
        
        return messageToBuild;
    }
}