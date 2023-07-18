package alarmclient;

public enum MenuOptionAlarm
{
    GET_NETWORK_ALARMS,
    ACKNOWLEDGE_ALARM;

    static final int CONVERSION = 21;

    public int getValue()
    {
        // For converting to MenuOption
        return ordinal() + CONVERSION;
    }
}