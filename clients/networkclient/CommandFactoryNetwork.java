package networkclient;

import common.Command;
import common.MenuOption;
import common.CommandFactory;
import common.StubCommand;
import java.util.Arrays;

public class CommandFactoryNetwork extends CommandFactory
{
    public Command createCommand(MenuOption menuOption)
    {
        switch (menuOption)
        {
            case COMMISSION_RU:
                return new CommissionRUCommand("Commission RU", Arrays.asList("IP Address"));
            case DECOMMISSION_RU:
                return new DecommissionRUCommand("Decommission RU", Arrays.asList("IP Address"));
            case ADD_RADIO_UNIT:
                return new AddRadioUnitCommand("Add Radio Unit", Arrays.asList("IP Address"));
            case REMOVE_RADIO_UNIT:
                return new RemoveRadioUnitCommand("Remove Radio Unit", Arrays.asList("IP Address"));
            case SETUP_RU:
                return new SetupRUCommand("Setup RU", Arrays.asList("IP Address"));
            case RELEASE_RU:
                return new ReleaseRUCommand("Release RU", Arrays.asList("IP Address"));
            case ACTIVATE_RU:
                return new ActivateRUCommand("Activate RU", Arrays.asList("IP Address"));
            case DEACTIVATE_RU:
                return new DeactivateRUCommand("Deactivate RU", Arrays.asList("IP Address"));
            case SETUP_CARRIER_ON_RU:
                return new SetupCarrierOnRUCommand("Setup Carrier On RU", Arrays.asList("IP Address"));
            case MODIFY_CARRIER_ON_RU:
                return new ModifyCarrierOnRUCommand("Modify Carrier On RU", Arrays.asList("IP Address"));
            case REMOVE_CARRIER_ON_RU:
                return new RemoveCarrierOnRUCommand("Remove Carrier On RU", Arrays.asList("IP Address"));
            case REMOVE_ALL_CARRIERS_ON_RU:
                return new RemoveAllCarriersOnRUCommand("Remove All Carriers On RU", Arrays.asList("IP Address"));
            case SIGNAL_SCALING_ON_RU:
                return new SignalScalingOnRUCommand("Signal Scaling On RU", Arrays.asList("IP Address"));
            case POST_ACTIVATION:
                return new PostActivationCommand("Post Activation", Arrays.asList("IP Address"));
            case PERFORM_SELF_DIAGNOSTICS:
                return new PerformSelfDiagnosticsCommand("Perform Self Diagnostics", Arrays.asList("IP Address"));
            case LIST_NETWORK_INVENTORY:
                return new ListNetworkInventoryCommand("List Network Inventory", Arrays.asList("IP Address"));
            case LIST_RUS_BY_STNADARD:
                return new ListRUsByStandardCommand("List RUs By Standard", Arrays.asList("IP Address"));
            case LIST_RUS_BY_STATE:
                return new ListRUsByStateCommand("List RUs By State", Arrays.asList("IP Address"));
            case LIST_RUS_BY_BAND:
                return new ListRUsByBandCommand("List RUs By Band", Arrays.asList("IP Address"));
            case LIST_RADIO_UNIT_DETAILS:
                return new ListRadioUnitDetailsCommand("List Radio Unit Details", Arrays.asList("IP Address"));
            case SET_ALARM_ON_RU:
                return new SetAlarmOnRUCommand("Set Alarm on RU", Arrays.asList("IP Address"));
            default:
                System.out.println("Invalid menuOption");
                return new StubCommand();
        }
    }
}