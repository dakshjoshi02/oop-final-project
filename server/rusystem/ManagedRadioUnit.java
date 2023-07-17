package rusystem;

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
    
    public ManagedRadioUnit()
    {
        activatedState = new RUActivatedState(this);
        idleState = new RUIdleState(this);
        deactivatedState = new RUDeactivatedState(this);
        currentState = idleState;
    }
    
    public Response triggerEvent(ManagedRuEvent managedRuEvent)
    {
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