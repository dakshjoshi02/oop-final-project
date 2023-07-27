package networkclient;

import common.Command;
import common.MenuOption;
import common.FrequencyBand;
import java.util.List;

public class ModifyCarrierOnRUCommand extends Command
{
    public ModifyCarrierOnRUCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.MODIFY_CARRIER_ON_RU.ordinal() + ":";
        
        // IP Address
        System.out.print("Please enter the \'" + inputs.get(0) + "\': ");
        String ipAddress = System.console().readLine();
        messageToBuild += ipAddress + ":";
        
        // Carrier Id
        System.out.print("Please enter the \'" + inputs.get(1) + "\': ");
        String carrierId = System.console().readLine();
        messageToBuild += carrierId + ":";
        
        // Frequency Band
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