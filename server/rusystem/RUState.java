package rusystem;
/*
 * defines an interface for ru state machine
 */
public interface RUState {
    void setup();
    void activate();
    void deactivate();
    void release();
    void setupCarrier(); // input carrier
    void signalScaling(); 
    void modifyCarrier(int band, String frequency); // carrier related
    void removeCarrier(int carrierId); // carrier id
    void removeAllCarriers();
    void setAlarmStatus();
    void postActivation();
    void performSelfDiagnostics();
    void acknowledgeAlarm();
}
