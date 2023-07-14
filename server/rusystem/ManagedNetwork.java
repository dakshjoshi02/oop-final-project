package rusystem;

import java.util.Map;
import java.util.HashMap;

import common.Response;

// This area needs to be refactored. Current IF into the managed network isn't great.
// Likely could convert each function into a command class and then just have the managed network call each command
// Then an ENUM would be passed into one function the appropriate function would be called
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
}