package connections;

import java.util.List;

import rusystem.ManagedNetwork;
import rusystem.ManagedRadioUnit;
import common.Response;
import common.RAT;
import common.RUVender;

public class AddRadioUnitCommand extends Command
{
    private String ipAddress;
    private RAT ratType;
    private RUVender vender;
    private String unitName;

    public AddRadioUnitCommand(String commandText, List<String> inputs) throws Exception
    {
        super(commandText);
        
        if (inputs.size() == 4)
        {
            String ratString = inputs.get(0).toLowerCase();
            String venderString = inputs.get(1).toLowerCase();
            switch (ratString)
            {
                case "bluetooth":
                    ratType = RAT.Bluetooth;
                    break;

                case "wifi":
                    ratType = RAT.WiFi;
                    break;

                case "ltd_fdd":
                    ratType = RAT.LTE_FDD;
                    break;
                    
                case "gsm":
                    ratType = RAT.GSM;
                    break;

                case "wcdma":
                    ratType = RAT.WCDMA;
                    break;

                case "unknown":
                    ratType = RAT.Unknown;
                    break;
                
                default:
                    throw new Exception("Chosen rat type is not available or does not exist.");
            }

            switch (venderString)
            {
                case "ericsson":
                    vender = RUVender.ERICSSON;
                    break;

                case "nokia":
                    vender = RUVender.NOKIA;
                    break;

                case "ltd_fdd":
                    vender = RUVender.Unknown;
                    break;
                
                default:
                    throw new Exception("Chosen vendor is not available or does not exist.");
            }

            unitName = inputs.get(2);
            ipAddress = inputs.get(3);
        }
        else
        {
            throw new Exception("ABN: Wrong number of input strings passed to ctor()");
        }
    }

    @Override
    public Response execute()
    {
        ManagedNetwork managedNetwork = ManagedNetwork.getInstance();
        ManagedRadioUnit radioUnit = new ManagedRadioUnit(ratType, vender, unitName, ipAddress);
        Response response = managedNetwork.addRadioUnit(radioUnit);
        if (response.isSuccessful)
        {
            response = new Response(true, "Successfully executed AddRadioUnitCommand");
        }
        return response;
    }
}