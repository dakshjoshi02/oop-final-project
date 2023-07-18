package common;

import java.util.List;

public class Command
{
  public String outputText;
  public List<String> inputs;

  public Command()
  {
  }

  public Command(String outputText, List<String> inputs)
  {
    this.outputText = outputText;
    this.inputs = inputs;
  }

  public String execute()
  {
    String messageToBuild = "";
    for (String input : inputs)
    {
      System.out.print("Please enter your \'" + input + "\': ");
      String userInput = System.console().readLine();
      messageToBuild += userInput + ";";
    }
    return messageToBuild;
  }
}