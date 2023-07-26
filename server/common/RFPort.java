package common;

public enum RFPort
{
    RF_0("A"),
    RF_1("B"),
    RF_2("C"),
    RF_3("D"),
    RF_4("E"),
    RF_5("F"),
    RF_6("G"),
    RF_7("H");

    // Constructor
   private String value;

    private RFPort(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}