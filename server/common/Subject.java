package common;

import java.util.List;

import connections.Command;

public interface Subject
{
    public Integer registerObserver(Observer o);
    public void removeObserver(Integer observerId);
    public void notifyObserver(Integer observerId, Response response);
}
