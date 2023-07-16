package server;
public class RadioUnit {
    private RUIdleState idleState;
    private RUActivatedState activatedState;
    private RUDeactivatedState deactivatedState;

    private RUState state;
    private String ipAddr;
    private String name;
    private String vendor;
    private String ratType;
    // private List<Carrier> carriers;
    private RadioUnitAlarmStatusLevels alarmStatus = RadioUnitAlarmStatusLevels.NO_ALARM;



    public RadioUnit() {

    }

    public boolean setup() {

        return false;
    }

    public boolean activate() {

        return false;
    }

    public boolean deactivate() {

        return false;
    }

    public boolean setupCarrier(Carrier) {

        return false;
    }

    public boolean signalScaling() {

        return false;
    }

    public boolean modifyCarrier() {

        return false;
    }

    public boolean removeCarrier() {
        return false;
    }

    public boolean removeAllCarriers() {
        return false;
    }

    public void postActivation() {
        
    }

    public void performSelfDiagnostics() {

    }

    public void acknowledgeAlarm() {

    }
}