package rusystem;

public class RUIdleState implements RUStateMachine {

    ManagedRadioUnit ru;

    public RUIdleState(ManagedRadioUnit ru) {
        this.ru = ru;
    }

    @Override
    public void setup() {
        System.out.println("setup");
        ru.setCurrentState(ru.getActivatedState());
    }

    @Override
    public void activate() {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void deactivate() {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void release() {
        System.out.println("Idled, No Action Performed");
    }
    
    @Override
    public void setupCarrier() {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void signalScaling() {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void modifyCarrier(int carrierId, String bandFrequency) {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void removeCarrier(int carrierId) {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void removeAllCarriers() {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void performSelfDiagnostics() {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void setAlarmStatus() {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void acknowledgeAlarm() {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public void postActivation() {
        System.out.println("Idled, No Action Performed");
    }

    @Override
    public String toString() {
        return "Idle State";
    }
}
