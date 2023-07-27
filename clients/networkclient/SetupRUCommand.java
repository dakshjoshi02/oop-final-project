package networkclient;

import common.Command;
import common.FrequencyBand;
import common.MenuOption;
import java.util.List;

public class SetupRUCommand extends Command
{
    public SetupRUCommand(String outputText, List<String> inputs)
    {
        super(outputText, inputs);
    }

    @Override
    public String execute()
    {
        String messageToBuild = MenuOption.SETUP_RU.ordinal() + ":";
        
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

        System.out.println("Please choose the vendor of the radio unit from the following:");
        System.out.println("0 -> Ericsson");
        System.out.println("1 -> Nokia");
        System.out.println("2 -> Unknown");
        String vendor = System.console().readLine();
        messageToBuild += vendor + ";";
        
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