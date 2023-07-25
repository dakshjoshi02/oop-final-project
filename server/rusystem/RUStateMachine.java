package rusystem;

import common.Carrier;

/*
 * defines an interface for ru state machine
 */
public interface RUStateMachine {
    boolean setup();
    boolean activate();
    boolean deactivate();
    boolean release();
    boolean setupCarrier(Carrier c); // input carrier
    boolean signalScaling(); 
    boolean modifyCarrier(int band, String frequency); // carrier related
    boolean removeCarrier(int carrierId); // carrier id
    boolean removeAllCarriers();
    boolean setAlarmStatus();
    boolean postActivation();
    boolean performSelfDiagnostics();
    boolean acknowledgeAlarm();
}
