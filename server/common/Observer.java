package common;

import java.util.List;

public interface Observer
{
    public String processEvent(Event event, List<String> parameters);
}
