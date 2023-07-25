package rusystem;

import java.util.List;

/*
 * defines an interface for ru state machine
 */
public interface RUStateMachine {
    boolean setup();
    boolean activate();
    boolean deactivate();
    boolean release();
    boolean setupCarrier(List<String> msg); // input carrier information, frequency, vendor, name etc...
    boolean signalScaling(); 
    boolean modifyCarrier(List<String> msg); // carrier id + frequency related
    boolean removeCarrier(int carrierId); // carrier id
    boolean removeAllCarriers();
    boolean setAlarmStatus(String alarm);
    boolean postActivation();
    boolean performSelfDiagnostics();
    boolean acknowledgeAlarm();
}
