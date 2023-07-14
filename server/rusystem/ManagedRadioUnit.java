package rusystem;

import common.Response;

public class ManagedRadioUnit
{
    State currentState;
    
    public ManagedRadioUnit()
    {
        currentState = State.IDLE;
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