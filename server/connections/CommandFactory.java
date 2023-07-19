package connections;

import java.util.List;
import java.util.Arrays;

import common.Event;

public class CommandFactory
{  
    private static CommandFactory instance = null;

    private CommandFactory()
    {
    }

    public static synchronized CommandFactory getInstance()
    {
        if (instance == null)
        {
            instance = new CommandFactory();
        }
        return instance;
    }
  
    public Command createCommand(Event event, List<String> parameters)
    {
        try
        {
            switch(event)
            {
                case COMMISSION_RU:
                    return new CommissionRuCommand("Commission RU", parameters);
                case DECOMMISSION_RU:
                    return new DecommissionRuCommand("Decommission RU", parameters);
                case ADD_RADIO_UNIT:
                    return new AddRadioUnitCommand("Add Radio Unit", parameters);
                case REMOVE_RADIO_UNIT:
                    return new RemoveRadioUnitCommand("Remove Radio Unit", parameters);
                case SETUP_RU:
                    return new SetupRuCommand("Setup RU", parameters);
                case RELEASE_RU:
                    return new ReleaseRuCommand("Release RU", parameters);
                case ACTIVATE_RU:
                    return new ActivateRuCommand("Activate RU", parameters);
                case DEACTIVATE_RU:
                    return new DeactivateRuCommand("Deactivate RU", parameters);
                case SETUP_CARRIER_ON_RU:
                    return new SetupCarrierOnRuCommand("Setup carrier on RU", parameters);
                case MODIFY_CARRIER_ON_RU:
                    return new ModifyCarrierOnRuCommand("Modify Carrier on RU", parameters);
                case REMOVE_CARRIER_ON_RU:
                    return new RemoveCarrierOnRuCommand("Remove Carrier on RU Command", parameters);
                case REMOVE_ALL_CARRIERS_ON_RU:
                    return new RemoveAllCarriersOnRuCommand("Remove All Carriers on RU", parameters);
                case SINGAL_SCALING_ON_RU:
                    return new SignalScalingOnRuCommand("Signal Scaling on RU", parameters);
                case POST_ACTIVATION:
                    return new PostActivationCommand("Post Activation", parameters);
                case PERFORM_SELF_DIAGNOSTICS:
                    return new PerformSelfDiagnosticsCommand("Perform Self Diagnostics", parameters);
                case LIST_NETWORK_INVENTORY:
                    return new ListNetworkInventoryCommand("List Network Inventory", parameters);
                case LIST_RUS_BY_STANDARD:
                    return new ListRusByStandardCommand("List RUs by Standard", parameters);
                case LIST_RUS_BY_STATE:
                    return new ListRusByStateCommand("List RUs by State", parameters);
                case LIST_RUS_BY_BAND:
                    return new ListRusByBandCommand("List RUs by Band", parameters);
                case LIST_RADIO_UNIT_DETAILS:
                    return new ListRadioUnitDetailsCommand("List Radio Unit Details", parameters);
                case SET_ALARM_ON_RU:
                    return new SetAlarmOnRuCommand("Set Alarm on RU", parameters);
                case GET_NETWORK_ALARMS:
                    return new GetNetworkAlarmsCommand("Get Network Alarms", parameters);
                case ACKNOWLEDGE_ALARM:
                    return new AcknowledgeAlarmCommand("Acknowledge Alarm", parameters);
                default:
                    return new StubCommand("Invalid Input");
            }
        }
        catch (Exception e)
        {
            // Need to respond to the client that the input was invalid
            return new StubCommand("Invalid Input");
        }
    }
}
