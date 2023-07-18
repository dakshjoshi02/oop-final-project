package networkclient;

public enum MenuOptionNetwork
{
    COMMISSION_RU,
    DECOMMISSION_RU,
    ADD_RADIO_UNIT,
    REMOVE_RADIO_UNIT,
    SETUP_RU,
    RELEASE_RU,
    ACTIVATE_RU,
    DEACTIVATE_RU,
    SETUP_CARRIER_ON_RU,
    MODIFY_CARRIER_ON_RU,
    REMOVE_CARRIER_ON_RU,
    REMOVE_ALL_CARRIERS_ON_RU,
    SIGNAL_SCALING_ON_RU,
    POST_ACTIVATION,
    PERFORM_SELF_DIAGNOSTICS,
    LIST_NETWORK_INVENTORY,
    LIST_RUS_BY_STANDARD,
    LIST_RUS_BY_STATE,
    LIST_RUS_BY_BAND,
    LIST_RADIO_UNIT_DETAILS,
    SET_ALARM_ON_RU;
  
    public int getValue()
    {
        // For converting to MenuOption
        return ordinal();
    }
}