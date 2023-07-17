package rusystem.RadioUnitState;

import rusystem.ManagedRadioUnit;

public class RUDeactivatedState implements RUState {

    ManagedRadioUnit ru;

    public RUDeactivatedState(ManagedRadioUnit ru) {
        this.ru = ru;
    }

    @Override
    public void setup() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void activate() {

    }

    @Override
    public void release() {

    }
}
