package ruunit;

import ruunit.CommonType.*;
import java.util.HashMap;
import java.util.Map;

public class ManagedRadioUnit
{
    private RUIdleState idleState;
    private RUActivatedState activatedState;
    private RUDeactivatedState deactivatedState;
    private RUState state;

    public String ipAddr;

    public String radioUnitName = "Legacy";

    public RusVender rusVender;

    public RAT ratType;

    Map<Integer, Carrier> carrierList = new HashMap<>();

    public RUAlarmStatusLevel alarmStatus = RUAlarmStatusLevel.NO_ALARM;

    public ManagedRadioUnit()
    {

    }    

    public boolean setup()
    {

        return true;
    }

    public boolean activate()
    {

        return true;
    }

    public boolean deactivate()
    {

        return true;
    }

    public boolean release()
    {
        return true;
    }

    public boolean setupCarrier(Carrier carrier)
    {
        carrierList.put(carrier.id, carrier);

        return true;
    }

    public boolean signalScaling() {

        return true;
    }

    public boolean modifyCarrier(int id, RusBand band)
    {
        if(carrierList.containsKey(id))
        {
            Carrier carrier = carrierList.get(id);
            carrier.band = band;
            carrierList.put(id, carrier);

            return true;
        }

        return true;
    }

    public boolean removeCarrier(int id)
    {
        if(carrierList.containsKey(id))
        {
            carrierList.remove(id);
        }

        return true;
    }

    public boolean removeAllCarriers()
    {
        carrierList.clear();

        return true;
    }

    public void postActivation()
    {
        
    }

    public void performSelfDiagnostics()
    {

    }

    public void acknowledgeAlarm() {

    }
}