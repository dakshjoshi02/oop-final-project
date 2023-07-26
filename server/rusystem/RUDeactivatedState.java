package rusystem;

import common.FrequencyBand;

public class RUDeactivatedState implements RUStateMachine {

    ManagedRadioUnit ru;

    public RUDeactivatedState(ManagedRadioUnit ru) {
        this.ru = ru;
    }

    @Override
    public void setup() {
        System.out.println("setup");
        ru.setCurrentState(ru.getActivatedState());
    }

    @Override
    public void activate() {
        ru.setCurrentState(ru.getActivatedState());
    }

    @Override
    public void deactivate() {
        System.out.println("Deactivated, No Action Performed");
    }

    @Override
    public void release() {
        ru.setCurrentState(ru.getIdleState());
    }

    @Override
    public void setupCarrier() {
        System.out.println("Deactivated, No Action Performed");
    }

    @Override
    public void signalScaling() {
        System.out.println("Deactivated, No Action Performed");
    }

    @Override
    public void modifyCarrier(int carrierId, FrequencyBand bandFrequency) {
        System.out.println("Deactivated, No Action Performed");
    }

    @Override
    public void removeCarrier(int carrierId) {
        ru.removeCarrier(carrierId);
    }

    @Override
    public void removeAllCarriers() {
        ru.removeAllCarriers();
    }

    @Override
    public void performSelfDiagnostics() {
        System.out.println("Deactivated, No Action Performed");
    }

    @Override
    public void setAlarmStatus() {
        System.out.println("Deactivated, No Action Performed");
    }

    @Override
    public void acknowledgeAlarm() {
        System.out.println("Deactivated, No Action Performed");
    }

    @Override
    public void postActivation() {
        System.out.println("Deactivated, No Action Performed");
    }
}
