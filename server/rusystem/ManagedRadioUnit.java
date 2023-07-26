package rusystem;

import java.util.HashMap;

import common.*;
import carriermanagement.Carrier;

public class ManagedRadioUnit
{
    protected RUStateMachine activatedState;
    protected RUStateMachine idleState;
    protected RUStateMachine deactivatedState;

    protected void setDeactivatedState(RUStateMachine deactivatedState) {
        this.deactivatedState = deactivatedState;
    }

    protected RUStateMachine currentState;

    protected String ipAddress;
    protected String radioUnitName;
    protected RUVender ruVender;
    protected RAT ratType;
    protected HashMap<Integer, Carrier> carrierList; // or Carriers?
    protected RUAlarmStatusLevels alarmStatus;

    public ManagedRadioUnit()
    {
        this.activatedState = new RUActivatedState(this);
        this.idleState = new RUIdleState(this);
        this.deactivatedState = new RUDeactivatedState(this);
        this.currentState = idleState;
        this.alarmStatus = RUAlarmStatusLevels.NO_ALARM;
        // this.radioUnitName
        // this.radioVendor
        // this.ratType
    }

    public ManagedRadioUnit(RAT ratType, RUVender vender, String unitName, String ipAddress)
    {
        this.activatedState = new RUActivatedState(this);
        this.idleState = new RUIdleState(this);
        this.deactivatedState = new RUDeactivatedState(this);
        this.currentState = idleState;
        this.alarmStatus = RUAlarmStatusLevels.NO_ALARM;
        this.radioUnitName = unitName;
        this.ruVender = vender;
        this.ratType = ratType;
        this.ipAddress = ipAddress;
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
                break;
            case SETUP_CARRIER:
                currentState.setupCarrier();
                break;
            case SIGNAL_SCALING:
                currentState.signalScaling();
                break;
            case MODIFY_CARRIER:
                //currentState.modifyCarrier(0, "asdas");
                break;
            case REMOVE_CARRIER:
                currentState.removeCarrier(0);
                break;
            case SELF_DIAGNOSTICS:
                currentState.performSelfDiagnostics();
                break;
            case REMOVE_ALL_CARRIERS:
                currentState.removeAllCarriers();
                break;
            case SET_ALARM_STATUS:
                currentState.setAlarmStatus();
                break;
            case ACKNOWLEDGE_ALARM:
                currentState.acknowledgeAlarm();
                break;
            case POST_ACTIVATION:
                currentState.postActivation();
                break;
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

    public boolean setup()
    {

        return true;
    }

    public boolean signalScaling()
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

    protected boolean removeCarrier(int carrierId) {
        if (!this.carrierList.containsKey(carrierId)) {
            return false;
        }

        carrierList.remove(carrierId);
        return true;
    }

    protected boolean removeAllCarriers() {
        carrierList.clear();
        return true;
    }

    protected boolean modifyCarrier(int carrierId, FrequencyBand frequencyBand) {
        // TODO: Waiting for Carrier to be completed
        if(carrierList.containsKey(carrierId))
        {
            Carrier carrier = carrierList.get(carrierId);
            carrier.setBand(frequencyBand);
            carrierList.put(carrierId, carrier);

            return true;
        }

        return true;
    }

    protected boolean setupCarrier(Carrier carrier) {
        // TODO: Waiting for Carrier to be completed
        carrierList.put(carrier.getID(), carrier);

        return true;
    }

    public boolean postActivation()
    {
        return true;
    }

    protected boolean performSelfDiagnostics() {
        // TODO: perform self diagnostics
        return true;
    }

    public boolean acknowledgeAlarm() 
    {
        return true;
    }

    // ------------- comment ------------

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

    protected String getIpAddress() {
        return this.ipAddress;
    }

    protected void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    protected String getRadioUnitName() {
        return this.radioUnitName;
    }

    protected void setRadioUnitName(String radioUnitName) {
        this.radioUnitName = radioUnitName;
    }

    protected RUVender getRadioVendor() {
        return this.ruVender;
    }

    protected void setRadioVendor(RUVender ruVender) {
        this.ruVender = ruVender;
    }

    protected RAT getRatType() {
        return this.ratType;
    }

    protected void setRatType(RAT rat) {
        this.ratType = rat;
    }

    protected HashMap<Integer, Carrier> getCarriers() {
        return this.carrierList;
    }

    protected void setCarriers(HashMap<Integer, Carrier> carriers) {
        this.carrierList = carriers;
    }

    protected RUAlarmStatusLevels getAlarmStatus() {
        return this.alarmStatus;
    }

    protected void setAlarmStatus(RUAlarmStatusLevels alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    protected RUStateMachine getCurrentState() {
        return this.currentState;
    }

    protected void setCurrentState(RUStateMachine currentState) {
        this.currentState = currentState;
    }

    protected RUStateMachine getActivatedState() {
        return this.activatedState;
    }

    protected RUStateMachine getIdleState() {
        return this.idleState;
    }

    protected RUStateMachine getDeactivatedState() {
        return this.deactivatedState;
    }
}