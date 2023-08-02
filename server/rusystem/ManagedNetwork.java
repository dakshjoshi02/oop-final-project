package rusystem;

import java.util.Map;
import java.util.HashMap;

import carriermanagement.*;
import common.*;

public class ManagedNetwork
{
    private static ManagedNetwork instance = null;
    private Map<String, ManagedRadioUnit> managedRadioUnits;

    private ManagedNetwork()
    {
        managedRadioUnits = new HashMap<String, ManagedRadioUnit>();
    }

    public static synchronized ManagedNetwork getInstance()
    {
        if (instance == null)
        {
            instance = new ManagedNetwork();
        }
        return instance;
    }
    
    public Response setupRU(String ipAddress)
    {
        if (managedRadioUnits.get(ipAddress) != null)
        {
            Response response = new Response(false, "A managedRadioUnit already exists associated with that ip address.");
            return response;
        }
        
        ManagedRadioUnit managedRadioUnit = new ManagedRadioUnit(ipAddress);
        managedRadioUnits.put(ipAddress, managedRadioUnit);
        Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.SETUP);
        return response;
    }
    
    public Response activateRU(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.ACTIVATE);
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with: " + ipAddress);
        return response;
    }

    public Response postActivation(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.POST_ACTIVATION);
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with: " + ipAddress);
        return response;
    }
    
    public Response performSignalScaling(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.SIGNAL_SCALING);
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with: " + ipAddress);
        return response;
    }
    
    public Response performSelfDiagnostics(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.SELF_DIAGNOSTICS);
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with: " + ipAddress);
        return response;
    }

    public Response deactivateRU(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.DEACTIVATE);
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with: " + ipAddress);
        return response;
    }

    public Response removeAllCarriersOnRU(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.REMOVE_ALL_CARRIERS);
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with " + ipAddress);
        return response;
    }

    public Response releaseRU(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.RELEASE);
            managedRadioUnit.removeAllCarriers();
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with " + ipAddress);
        return response;
    }

    public Response addRadioUnit(ManagedRadioUnit radioUnit)
    {
        if (radioUnit != null)
        {
            ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(radioUnit.getIpAddress());
            if (managedRadioUnit != null)
            {
                Response response = new Response(false, "Radio unit associated with that ip address has already been added.");
                return response;
            }

            managedRadioUnits.put(radioUnit.getIpAddress(), radioUnit);
            Response response = radioUnit.triggerEvent(ManagedRuEvent.SETUP); // ?
            return response;
        }
        return new Response(false, "Radio Unit does not exist/cannot be null value.");
    }

    public Response removeRadioUnit(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit == null)
        {
            Response response = new Response(false, "Radio unit associated with that ip address does not exist.");
            return response;
        }

        managedRadioUnits.remove(ipAddress);
        Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.DEACTIVATE); // ?
        return response;
    }

    public Response listNetworkInventory()
    {
        String returnMsg = "";

        for (Map.Entry<String, ManagedRadioUnit> entry : managedRadioUnits.entrySet())
        {
            returnMsg += "[" + entry.getValue().toString() + "] ";
        }
        
        if (returnMsg == "")
        {
            return new Response(true, "There are no registered radio units at this time.");
        }

        return new Response(true, returnMsg);
    }

    public Response setupCarrierOnRu(String ipAddress, Carrier carrier)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit == null)
        {
            Response response = new Response(false, "Radio unit associated with that ip address does not exist.");
            return response;
        }

        managedRadioUnit.setupCarrier(carrier);
        Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.SETUP_CARRIER);
        return response;
    }
}