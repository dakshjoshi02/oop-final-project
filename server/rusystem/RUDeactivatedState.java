package rusystem;

public class RUDeactivatedState implements RUStateMachine {

    ManagedRadioUnit ru;

    public RUDeactivatedState(ManagedRadioUnit ru) {
        this.ru = ru;
    }

    @Override
    public boolean setup() {
        System.out.println("setup");
        ru.setCurrentState(ru.getActivatedState());
        return true;
    }

    @Override
    public boolean activate() {
        ru.setCurrentState(ru.getActivatedState());
        return true;
    }

    @Override
    public boolean deactivate() {
        System.out.println("Deactivated, No Action Performed");
        return false;
    }

    @Override
    public boolean release() {
        ru.setCurrentState(ru.getIdleState());
        return true;
    }

    @Override
    public boolean setupCarrier(String msg) {
        System.out.println("Deactivated, No Action Performed");
        return false;
    }

    @Override
    public boolean signalScaling() {
        System.out.println("Deactivated, No Action Performed");
        return false;
    }

    @Override
    public boolean modifyCarrier(String idAndFrequency) {
        System.out.println("Deactivated, No Action Performed");
        return false;
    }

    @Override
    public boolean removeCarrier(String carrierId) {
        ru.removeCarrier(carrierId);
        return true;
    }

    @Override
    public boolean removeAllCarriers() {
        ru.removeAllCarriers();
        return true;
    }

    @Override
    public boolean performSelfDiagnostics() {
        System.out.println("Deactivated, No Action Performed");
        return false;
    }

    @Override
    public boolean setAlarmStatus(String alarm) {
        System.out.println("Deactivated, No Action Performed");
        return false;
    }

    @Override
    public boolean acknowledgeAlarm() {
        System.out.println("Deactivated, No Action Performed");
        return false;
    }

    @Override
    public boolean postActivation() {
        System.out.println("Deactivated, No Action Performed");
        return false;
    }

    @Override
    public String toString() {
        return "Deactivated State";
    }
}
