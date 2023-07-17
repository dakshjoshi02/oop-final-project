package rusystem.RadioUnitState;

import rusystem.ManagedRadioUnit;

public class RUIdleState implements RUState {

    ManagedRadioUnit ru;

    public RUIdleState(ManagedRadioUnit ru) {
        this.ru = ru;
    }

    @Override
    public void setup() {
        System.out.println("setup");
    }

    @Override
    public void activate() {
        System.out.println("activate");
    }

    @Override
    public void deactivate() {
        System.out.println("deactivate");
    }

    @Override
    public void release() {
        System.out.println("release");
    }
    
    @Override
    public void setupCarrier() {

    }

    @Override
    public void signalScaling() {

    }

    @Override
    public void modifyCarrier(int carrierId, String bandFrequency) {

    }

    @Override
    public void removeCarrier(int carrierId) {

    }

    @Override
    public void removeAllCarriers() {

    }

    @Override
    public void postActivation() {

    }

    @Override
    public void performSelfDiagnostics() {

    }

    @Override
    public void acknowledgeAlarm() {

    }
}
