package rusystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Response;

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
            Response response = new Response(false, "A managedRadioUnit already exists associated with: " + ipAddress);
            return response;
        }
        
        ManagedRadioUnit managedRadioUnit = new ManagedRadioUnit();
        managedRadioUnits.put(ipAddress, managedRadioUnit);
        Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.SETUP, new ArrayList<String>());
        return response;
    }
    
    public Response activateRU(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {   
            List<String> msg = new ArrayList<String>();
            msg.add(ipAddress);
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.ACTIVATE, new ArrayList<String>());
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
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.POST_ACTIVATION, new ArrayList<String>());
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
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.SIGNAL_SCALING, new ArrayList<String>());
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
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.SELF_DIAGNOSTICS, new ArrayList<String>());
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with: " + ipAddress);
        return response;
    }
}