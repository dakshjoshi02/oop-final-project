package rusystem;

import java.util.Map;

import carriermanagement.Carrier;

import java.util.HashMap;

import common.RUVender;
import common.Response;
import common.FrequencyBand;
import common.RAT;

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
    
    public Response setupRU(String ipAddress, Carrier carrier)
    {
        if (managedRadioUnits.get(ipAddress) != null)
        {
            Response response = new Response(false, "A managedRadioUnit already exists associated with that ip address.");
            return response;
        }
        
        ManagedRadioUnit managedRadioUnit = null;
        RUVender ruVender = carrier.getVender();
        RAT ratType = carrier.getRAT();
        if(ruVender == RUVender.ERICSSON)
        {
            if(ratType == RAT.LTE_FDD)
            {
                managedRadioUnit = new EricssonLteRus();
            }
            else if(ratType == RAT.LTE_FDD)
            {
                managedRadioUnit = new EricssonWcdmaRus();
            }
            else
            {
                managedRadioUnit = new ManagedRadioUnit();
            }
        }
        else if(ruVender == RUVender.NOKIA)
        {
            if(ratType == RAT.LTE_FDD)
            {
                managedRadioUnit = new NokiaLteRus();
            }
            else if(ratType == RAT.LTE_FDD)
            {
                managedRadioUnit = new NokiaWcdmaRus();
            }
            else
            {
                managedRadioUnit = new ManagedRadioUnit();
            }
        }
        else
        {
            managedRadioUnit = new ManagedRadioUnit();
        }
        managedRadioUnits.put(ipAddress, managedRadioUnit);
        Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.SETUP);
        return response;
    }

    public boolean RemoveRadioUnitOnRU(String ipAddress)
    {
        managedRadioUnits.remove(ipAddress);
        return true;
    }

    public Response addRadioUnit(String ipAddress, Carrier carrier)
    {
        return setupRU(ipAddress, carrier);
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
    
    public Response setupCarrierOnRU(String ipAddress, Carrier carrier)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.SETUP_CARRIER);
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

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with: " + ipAddress);
        return response;
    }
    
    public Response removeCarrierOnRU(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.REMOVE_CARRIER);
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with: " + ipAddress);
        return response;
    }

    
    public Response releaseRU(String ipAddress)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            Response response = managedRadioUnit.triggerEvent(ManagedRuEvent.RELEASE);
            return response;
        }

        Response response = new Response(false, "Failed to find the managedRadioUnit associated with: " + ipAddress);
        return response;
    }
    
    public Response modifyCarrierOnRu(String ipAddress, Integer carrierId, FrequencyBand freqBand)
    {
        ManagedRadioUnit managedRadioUnit = managedRadioUnits.get(ipAddress);
        if (managedRadioUnit != null)
        {
            managedRadioUnit.modifyCarrier(carrierId, null);

            Response response = new Response(true, "Successfully executed ModifyCarrierOnRucommand");
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