package alarmclient;

public enum MenuOptionAlarm
{
    GET_NETWORK_ALARMS,
    ACKNOWLEDGE_ALARM;

    public int getValue()
    {
        // For converting to MenuOption
        return ordinal() + 21;
    }
}