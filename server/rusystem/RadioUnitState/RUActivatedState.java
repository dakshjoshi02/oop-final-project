package rusystem.RadioUnitState;

import rusystem.ManagedRadioUnit;

public class RUActivatedState implements RUState {

    ManagedRadioUnit ru;

    public RUActivatedState(ManagedRadioUnit ru) {
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
