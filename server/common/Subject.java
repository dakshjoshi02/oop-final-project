package common;

import java.util.List;

import connections.Command;

public interface Subject
{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(Command command);
}
