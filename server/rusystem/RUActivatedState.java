package rusystem;

import common.Carrier;

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
    public boolean setupCarrier(Carrier c) {
        return ru.setupCarrier(c);
    }

    @Override
    public boolean signalScaling() {
        return ru.signalScaling();
    }

    @Override
    public boolean modifyCarrier(int carrierId, String bandFrequency) {
        return ru.modifyCarrier(carrierId, bandFrequency);
    }

    @Override
    public boolean removeCarrier(int carrierId) {
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
    public boolean setAlarmStatus() {
        ru.setAlarmStatus();
        return true
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
