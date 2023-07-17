package rusystem;

import java.util.HashSet;

import common.Response;
import rusystem.RadioUnitState.RUActivatedState;
import rusystem.RadioUnitState.RUDeactivatedState;
import rusystem.RadioUnitState.RUIdleState;
import rusystem.RadioUnitState.RUState;

public class ManagedRadioUnit
{
    RUState activatedState;
    RUState idleState;
    RUState deactivatedState;

    RUState currentState;

    private String ipAddress;
    private String radioUnitName;
    private String radioVendor;
    private String ratType;
    private HashSet<Carrier> carriers; // or Carriers?
    private String RadioVendor;
    private AlarmStatus alarmStatus;

    public ManagedRadioUnit()
    {
        activatedState = new RUActivatedState(this);
        idleState = new RUIdleState(this);
        deactivatedState = new RUDeactivatedState(this);
        currentState = idleState;
    }
    
    public Response triggerEvent(ManagedRuEvent managedRuEvent)
    {   
        switch(managedRuEvent) {
            case SETUP:
                currentState.setup();
                break;
            case ACTIVATE:
                currentState.setup();
                break;
            case DEACTIVATE:
                currentState.deactivate();
                break;
            case RELEASE:
                currentState.release();
            case SETUP_CARRIER:
                currentState.setupCarrier();

            case SIGNAL_SCALING:
                currentState.signalScalling();

            case MODIFY_CARRIER:

            case REMOVE_CARRIER:

            case SELF_DIAGNOSTICS:

            case REMOVE_ALL_CARRIERS:

            case SET_ALARM_STATUS:

            case ACKNOWLEDGE_ALARM:

            case POST_ACTIVATION:

            default:
                System.out.println("Invalid event");
        }

        Response response = isTransitionPossible();
        if (response.isSuccessful)
        {
            response = transitionState();
            return response;
        }
        
        return response;
    }
    
    private Response isTransitionPossible()
    {
        Response response = new Response(true, "That state transition is possible");
        return response;
    }
    
    private Response transitionState()
    {
        Response response = new Response(true, "Successfully transitioned the state");
        return response;
    }
}