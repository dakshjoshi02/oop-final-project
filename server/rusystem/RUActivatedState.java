package rusystem;

public class RUActivatedState implements RUStateMachine {

    ManagedRadioUnit ru;

    public RUActivatedState(ManagedRadioUnit ru) {
        this.ru = ru;
    }

    @Override
    public boolean setup() {
        System.out.println("Activated, No Action Performed");
        return false;
    }

    @Override
    public boolean deactivate() {
        // ru.deactivate();
        ru.setCurrentState(ru.getActivatedState());
        return true;
    }

    @Override
    public boolean activate() {
        System.out.println("Activated, No Action Performed");
        return false;
    }

    @Override
    public boolean release() {
        System.out.println("Activated, No Action Performed");
        return false;
    }

    @Override
    public boolean setupCarrier(String msg) {
        return ru.setupCarrier(msg);
    }

    @Override
    public boolean signalScaling() {
        return ru.signalScaling();
    }

    @Override
    public boolean modifyCarrier(String idAndFrequency) {
        return ru.modifyCarrier(idAndFrequency);
    }

    @Override
    public boolean removeCarrier(String carrierId) {
        System.out.println("Activated, No Action Performed");
        return false;
    }

    @Override
    public boolean removeAllCarriers() {
        System.out.println("Activated, No Action Performed");
        return false;
    }

    @Override
    public boolean performSelfDiagnostics() {
        // TODO: perform self diagnostics
        ru.performSelfDiagnostics();
        return true;
    }

    @Override
    public boolean setAlarmStatus(String alarm) {
        ru.setAlarmStatus(alarm);
        return true;
    }

    @Override
    public boolean acknowledgeAlarm() {
        ru.acknowledgeAlarm();
        return true;
    }

    @Override
    public boolean postActivation() {
        System.out.println("Activated, No Action Performed");
        return true;
    }

    @Override
    public String toString() {
        return "Activated State";
    }
}
