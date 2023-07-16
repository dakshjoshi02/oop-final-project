package server;
public class RUIdleState implements RUState {
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
}
