package networkclient;

import common.Command;
import common.MenuOption;
import common.FrequencyBand;
import java.util.List;

public class SetupCarrierOnRUCommand extends Command
{
    public SetupCarrierOnRUCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.SETUP_CARRIER_ON_RU.ordinal() + ":";
        
        // IP Address
        System.out.print("Please enter the \'" + inputs.get(0) + "\': ");
        String ipAddress = System.console().readLine();
        messageToBuild += ipAddress + ":";
        
        // Start of Carrier
        System.out.println("Please fill in the following information to construct a carrier");
        System.out.println("-----------------------------------------------------------");
        
        // RF Ports (Ends with ; since it's not the last part of the carrier)
        System.out.print("Please enter the carrier RF ports in the following format (ie. \"ABCDEFGH\", \"abc\", \"HGfe\"): ");
        String rfPorts = System.console().readLine();
        char[] charArr = rfPorts.toUpperCase().toCharArray();
        String formattedRfPorts = "";
        for (int i = 0; i < charArr.length; ++i)
        {
            formattedRfPorts += (int)charArr[i] - (int)'A';
            if (i != charArr.length - 1)
            {
                formattedRfPorts += "-";
            }
        }
        messageToBuild += formattedRfPorts + ";";
        
        // Frequency Band (Ends with ; since it's not the last part of the carrier)
        System.out.println("The below options are the available frequency bands");
        System.out.println("---------------------------------------------------");
        for (FrequencyBand freqBand : FrequencyBand.values())
        { 
            System.out.println(freqBand.ordinal() + " => " + freqBand + "(" + freqBand.getValue() + ")");
        }
        System.out.print("Please select the frequency band (ie. \"0\", \"4\", \"7\"): ");
        String freqBand = System.console().readLine();
        messageToBuild += freqBand + ";";
        
        // Transmitting Power (Last part of the carrier ends with :)
        System.out.print("Please enter the transmitting power (ie. \"10\", \"40\", \"80\"): ");
        String transmittingPower = System.console().readLine();
        
        messageToBuild += transmittingPower + ":";
        // End of Carrier
        
        return messageToBuild;
    }
}