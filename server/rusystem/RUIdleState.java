package rusystem;

import common.Carrier;

public class RUIdleState implements RUStateMachine {

    ManagedRadioUnit ru;

    public RUIdleState(ManagedRadioUnit ru) {
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
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean deactivate() {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean release() {
        System.out.println("Idled, No Action Performed");
        return true;
    }
    
    @Override
    public boolean setupCarrier(Carrier c) {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean signalScaling() {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean modifyCarrier(int carrierId, String bandFrequency) {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean removeCarrier(int carrierId) {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean removeAllCarriers() {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean performSelfDiagnostics() {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean setAlarmStatus() {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean acknowledgeAlarm() {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public boolean postActivation() {
        System.out.println("Idled, No Action Performed");
        return false;
    }

    @Override
    public String toString() {
        return "Idle State";
    }
}
