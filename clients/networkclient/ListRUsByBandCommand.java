package networkclient;

import common.Command;
import common.MenuOption;
import common.FrequencyBand;
import java.util.List;

public class ListRUsByBandCommand extends Command
{
    public ListRUsByBandCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.LIST_RUS_BY_BAND.ordinal() + ":";
        
        System.out.println("The below options are the available frequency bands");
        System.out.println("---------------------------------------------------");
        for (FrequencyBand freqBand : FrequencyBand.values())
        { 
            System.out.println(freqBand.ordinal() + " => " + freqBand + "(" + freqBand.getValue() + ")");
        }
        System.out.print("Please select the frequency band (ie. \"0\", \"4\", \"7\"): ");
        String freqBand = System.console().readLine();
        messageToBuild += freqBand + ":";
        
        return messageToBuild;
    }
}