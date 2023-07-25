package rusystem;

/*
 * defines an interface for ru state machine
 */
public interface RUStateMachine {
    boolean setup();
    boolean activate();
    boolean deactivate();
    boolean release();
    boolean setupCarrier(String msg); // input carrier information, frequency, vendor, name etc...
    boolean signalScaling(); 
    boolean modifyCarrier(String msg); // carrier id + frequency related
    boolean removeCarrier(String carrierId); // carrier id
    boolean removeAllCarriers();
    boolean setAlarmStatus(String alarm);
    boolean postActivation();
    boolean performSelfDiagnostics();
    boolean acknowledgeAlarm();
}
