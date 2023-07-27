package rusystem;

import common.*;
import carriermanagement.Carrier;

public class EricssonLteRus extends ManagedRadioUnit
{
    public EricssonLteRus()
    {
        radioUnitName = "Erisson LTE RUS";
        ruVender = RUVender.ERICSSON;
        ratType = RAT.LTE_FDD;
    }

    @Override
    public boolean setup()
    {
        System.out.println("Performing setup Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean activate()
    {
        System.out.println("Performing activate Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean deactivate()
    {
        System.out.println("Performing deactivate Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean release()
    {
        System.out.println("Performing release Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean setupCarrier(Carrier carrier)
    {
        super.setupCarrier(carrier);

        System.out.println("Performing setupCarrier Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean signalScaling()
    {
        System.out.println("Performing SignalScaling Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean modifyCarrier(Integer id, FrequencyBand band)
    {
        super.modifyCarrier(id, band);

        System.out.println("Performing modifyCarrier Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean removeCarrier(Integer id)
    {
        super.removeCarrier(id);

        System.out.println("Performing modifyCarrier Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean removeAllCarriers()
    {
        super.removeAllCarriers();

        System.out.println("Performing modifyCarrier Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean postActivation()
    {
        System.out.println("Performing modifyCarrier Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean performSelfDiagnostics()
    {
        System.out.println("Performing modifyCarrier Procedure on: " + this.toString());

        return true;
    }

    @Override
    public boolean acknowledgeAlarm()
    {
        System.out.println("Performing modifyCarrier Procedure on: " + this.toString());

        return true;
    }    
}
