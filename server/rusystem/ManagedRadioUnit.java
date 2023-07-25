package rusystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import common.Carrier;
import common.CommonType.FrequencyBand;
import common.CommonType.RFPort;
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

    public ManagedRadioUnit(String ipAddress, String radioUnitName, String radioVendor, String ratType) {
        this.ipAddress = ipAddress;
        this.radioUnitName = radioUnitName;
        this.radioVendor = radioVendor;
        this.ratType = ratType;
        this.activatedState = new RUActivatedState(this);
        this.idleState = new RUIdleState(this);
        this.deactivatedState = new RUDeactivatedState(this);
        this.currentState = idleState;
        this.alarmStatus = RadioUnitAlarmStatusLevels.NO_ALARM;
        this.frequencySet = FrequencyBand.getEnums();
    }
    
    public Response triggerEvent(ManagedRuEvent managedRuEvent, String msg)
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
                currentState.setupCarrier(msg);
                break;
            case SIGNAL_SCALING:
                currentState.signalScaling();
                break;
            case MODIFY_CARRIER:
                currentState.modifyCarrier(msg);
                break;
            case REMOVE_CARRIER:
                currentState.removeCarrier(msg);
                break;
            case SELF_DIAGNOSTICS:
                currentState.performSelfDiagnostics();
                break;
            case REMOVE_ALL_CARRIERS:
                currentState.removeAllCarriers();
                break;
            case SET_ALARM_STATUS:
                currentState.setAlarmStatus(msg.get(0));
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

    protected boolean removeCarrier(String carrierId) {
        int id = Integer.parseInt(carrierId);
        if (!CarrierManager.getInstance().carrierMap.containsKey(id)) {
            return false;
        }

        CarrierManager.getInstance().carrierMap.remove(id);
        return true;
    }

    protected boolean removeAllCarriers() {
        CarrierManager.getInstance().carrierMap.clear();
        return true;
    }

    protected boolean modifyCarrier(String idAndFrequency) {
        StringBuilder id = new StringBuilder();
        StringBuilder frequency = new StringBuilder();
        boolean isFirstPart = true;
        char[] charArr = idAndFrequency.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            while (i < charArr.length && 48 <= charArr[i] && charArr[i] <= 57 && isFirstPart) {
                id.append(charArr[i]);
                i++;
            }
            isFirstPart = false;
            i++;
            while (i < charArr.length) {
                frequency.append(charArr[i]);
            }
        }
        int carrierId = Integer.parseInt(id.toString());
        String frequencyBand = frequency.toString();
        if (!CarrierManager.getInstance().carrierMap.containsKey(carrierId) || !this.frequencySet.contains(frequencyBand)) {
            return false;
        }

        Carrier c = CarrierManager.getInstance().carrierMap.get(carrierId);
        c.setFreqBand(frequencyBand);
        return true;
    }

    protected boolean setupCarrier(String msg) {
        // List<RFPort> rfPorts, FrequencyBand frequencyBand, double transmittingPower
        List<RFPort> rfPorts = new ArrayList<RFPort>();
        StringBuilder frequencyBand = new StringBuilder();
        char[] charArr = msg.toCharArray();
        boolean ifNumReached = false;
        int transmittingPowerStartIndex = 0;
        Double transDouble = 0.0;
        for (int i = 0; i < charArr.length; i++) {
            if (48 <= charArr[i] && charArr[i] <= 57) {
                ifNumReached = true;
            }
            if (!ifNumReached) {
                for (RFPort v: RFPort.values()) {
                    if (v.name().equalsIgnoreCase(Character.toString(charArr[i]))) {
                        rfPorts.add(v);
                    }
                }
            } else {
                    if (Character.isAlphabetic(charArr[i]) || Character.isDigit(charArr[i])) {
                        frequencyBand.append(charArr[i]);
                    } else {
                        transmittingPowerStartIndex = i + 1;
                        break;
                    }
            }
            
            String transmittingPower = msg.substring(transmittingPowerStartIndex, msg.length());
            transDouble = Double.parseDouble(transmittingPower);
        }

        String frequency = frequencyBand.toString();
        boolean isLte = false;
        for (FrequencyBand value: FrequencyBand.values()) {
            if (value.getValue().equalsIgnoreCase(frequency)) {
                if (value.name().contains("LTE")) {
                    isLte = true;
                }
            }
        }
        if (isLte) {
            CarrierManager.getInstance().createLteCarrier(rfPorts, frequency, transDouble);
        } else {
            CarrierManager.getInstance().createWcdmaCarrier(rfPorts, frequency, transmittingPowerStartIndex);
        }
        return true;
    }

    protected boolean performSelfDiagnostics() {
        System.out.println("self diagnosis performed");
        return true;
    }

    protected boolean setAlarmStatus(String alarmStatus) {
        for (RadioUnitAlarmStatusLevels alarm : RadioUnitAlarmStatusLevels.values()) {
            if (alarm.name().equalsIgnoreCase(alarmStatus)) {
                this.alarmStatus = alarm;
                return true;
            }
        }
        return false;
    }

    protected boolean signalScaling() {
        System.out.println("signal is scalling");
        return true;
    }

    protected boolean acknowledgeAlarm() {
        System.out.println("acknowledge alarm");
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