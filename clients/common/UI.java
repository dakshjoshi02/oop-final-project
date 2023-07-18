package common;

import java.util.Map;
import java.util.TreeMap;

public interface UI
{
  public void printUI();

  public void displayResponse(MessageContainer messageContainer);

  public String retrieveUserInput();
}