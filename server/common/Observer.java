package common;

import java.util.List;

import connections.Command;

public interface Observer
{
    public String processEvent(Command command);
}
