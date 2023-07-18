package rusystem;

public class RUActivatedState implements RUStateMachine {

    ManagedRadioUnit ru;

    public RUActivatedState(ManagedRadioUnit ru) {
        this.ru = ru;
    }

    @Override
    public void setup() {
        System.out.println("Activated, No Action Performed");
    }

    @Override
    public void deactivate() {
        // ru.deactivate();
        ru.setCurrentState(ru.getActivatedState());
    }

    @Override
    public void activate() {
        System.out.println("Activated, No Action Performed");
    }

    @Override
    public void release() {
        System.out.println("Activated, No Action Performed");
    }

    @Override
    public void setupCarrier() {
        // TODO: set up carrier
        // ru.setupCarrier();
    }

    @Override
    public void signalScaling() {
        // TODO: signal scaling
        // ru.signalScaling();
    }

    @Override
    public void modifyCarrier(int carrierId, String bandFrequency) {
        ru.modifyCarrier(carrierId, bandFrequency);
    }

    @Override
    public void removeCarrier(int carrierId) {
        System.out.println("Activated, No Action Performed");
    }

    @Override
    public void removeAllCarriers() {
        System.out.println("Activated, No Action Performed");
    }

    @Override
    public void performSelfDiagnostics() {
        // TODO: perform self diagnostics
        ru.performSelfDiagnostics();
    }

    @Override
    public void setAlarmStatus() {
        // ru.setAlarmStatus();
    }

    @Override
    public void acknowledgeAlarm() {
        System.out.println("Activated, No Action Performed");
    }

    @Override
    public void postActivation() {
        System.out.println("Activated, No Action Performed");
    }
}
