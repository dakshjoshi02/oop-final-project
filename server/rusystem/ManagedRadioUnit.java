package rusystem;

import java.util.HashMap;
import java.util.HashSet;

import common.Carrier;
import common.CommonType.FrequencyBand;
import common.CommonType.RadioUnitAlarmStatusLevels;
import common.Response;

public class ManagedRadioUnit
{
    private RUStateMachine activatedState;
    private RUStateMachine idleState;
    private RUStateMachine deactivatedState;

    protected void setDeactivatedState(RUStateMachine deactivatedState) {
        this.deactivatedState = deactivatedState;
    }

    private RUStateMachine currentState;

    private String ipAddress;
    private String radioUnitName;
    private String radioVendor;
    private String ratType;
    private HashMap<Integer, Carrier> carriers; // or Carriers?
    private RadioUnitAlarmStatusLevels alarmStatus;
    private HashSet<String> frequencySet;

    public ManagedRadioUnit()
    {
        this.activatedState = new RUActivatedState(this);
        this.idleState = new RUIdleState(this);
        this.deactivatedState = new RUDeactivatedState(this);
        this.currentState = idleState;
        this.alarmStatus = RadioUnitAlarmStatusLevels.NO_ALARM;
        this.frequencySet = FrequencyBand.getEnums();
    }
    
    public Response triggerEvent(ManagedRuEvent managedRuEvent)
    {   
        switch(managedRuEvent) {
            case SETUP:
                currentState.setup();
                break;
            case ACTIVATE:
                currentState.activate();
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
                currentState.modifyCarrier(0, "asdas");
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

    protected boolean removeCarrier(int carrierId) {
        if (!this.carriers.containsKey(carrierId)) {
            return false;
        }

        carriers.remove(carrierId);
        return true;
    }

    protected boolean removeAllCarriers() {
        carriers.clear();
        return true;
    }

    protected boolean modifyCarrier(int carrierId, String frequencyBand) {
        if (!carriers.containsKey(carrierId) || !this.frequencySet.contains(frequencyBand)) {
            return false;
        }

        Carrier c = carriers.get(carrierId);
        c.setFreqBand(frequencyBand);
        return true;
    }

    protected boolean setupCarrier(Carrier c) {
        if (carriers.containsKey(c.getInteger())) {
            return false;
        }

        carriers.put(c.getInteger(), c);
        return true;
    }

    protected boolean performSelfDiagnostics() {
        // TODO: perform self diagnostics
        return true;
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

    protected String getRadioVendor() {
        return this.radioVendor;
    }

    protected void setRadioVendor(String radioVendor) {
        this.radioVendor = radioVendor;
    }

    protected String getRatType() {
        return this.ratType;
    }

    protected void setRatType(String ratType) {
        this.ratType = ratType;
    }

    protected HashMap<Integer, Carrier> getCarriers() {
        return this.carriers;
    }

    protected void setCarriers(HashMap<Integer, Carrier> carriers) {
        this.carriers = carriers;
    }

    protected RadioUnitAlarmStatusLevels getAlarmStatus() {
        return this.alarmStatus;
    }

    protected void setAlarmStatus(RadioUnitAlarmStatusLevels alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    protected RUStateMachine getCurrentState() {
        return this.currentState;
    }

    protected void setCurrentState(RUStateMachine currentState) {
        System.out.println("RU state is set from " + this.currentState.toString() + " to " + currentState.toString());
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