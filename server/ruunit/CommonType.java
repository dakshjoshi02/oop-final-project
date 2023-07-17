package ruunit;

public class CommonType
{
    public enum RAT
    {
        Bluetooth,
        WiFi,
        LTE_FDD,
        GSM,
        WCDMA
    };

    public enum RusVender
    {
        ERICSSON,
        NOKIA
    }

    public enum RFPort
    {
        RF_0,
        RF_1,
        RF_2,
        RF_3,
        RF_4,
        RF_5,
        RF_6,
        RF_7,
    }

    public static final String RF_0 = "A";
    public static final String RF_1 = "B";
    public static final String RF_2 = "C";
    public static final String RF_3 = "D";
    public static final String RF_4 = "E";
    public static final String RF_5 = "F";
    public static final String RF_6 = "G";
    public static final String RF_7 = "H";

    public enum RusBand
    {
        LTE_BAND_1,
        LTE_BAND_2,
        LTE_BAND_3,
        LTE_BAND_4,
        LTE_BAND_5,
        LTE_BAND_6,
        LTE_BAND_7,
        LTE_BAND_8,

        WCDMA_BAND_1,
        WCDMA_BAND_2,
        WCDMA_BAND_3,
        WCDMA_BAND_4,
        WCDMA_BAND_5,
        WCDMA_BAND_6,
        WCDMA_BAND_7,
        WCDMA_BAND_8
    }

    public static final  int LTE_BAND_1 = 1920;
    public static final  int LTE_BAND_2 = 1850;
    public static final  int LTE_BAND_3 = 1710;
    public static final  int LTE_BAND_4 = 1755;
    public static final  int LTE_BAND_5 = 824;
    public static final  int LTE_BAND_6 = 830;
    public static final  int LTE_BAND_7 = 2500;
    public static final  int LTE_BAND_8 = 880;

    public static final  int WCDMA_BAND_1 = 2100;
    public static final  int WCDMA_BAND_2 = 1900;
    public static final  int WCDMA_BAND_3 = 1800;
    public static final  int WCDMA_BAND_4 = 1700;
    public static final  int WCDMA_BAND_5 = 850;
    public static final  int WCDMA_BAND_6 = 850;
    public static final  int WCDMA_BAND_7 = 2500;
    public static final  int WCDMA_BAND_8 = 900;

    public enum RUAlarmStatusLevel
    {
        CRITICAL,
        MAJOR,
        MINOR,
        NO_ALARM,
        CRITICAL_ACKNOWLEDGED,
        MAJOR_ACKNOWLEDGED,
        MINOR_ACKNOWLEDGED
    }
}
