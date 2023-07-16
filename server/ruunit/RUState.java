package server;
/*
 * defines an interface for ru state machine
 */
public interface RUState {
    void setup();
    void activate();
    void deactivate();
    void release();
}
