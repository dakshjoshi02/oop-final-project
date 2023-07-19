package common;

// Needs to stay as a clone of the server so that the user input & server/client messaging works properly (based off of the enum's ordinals)
// Please update both places if you change something, could probably build this and include it in both builds but then the build instructions would need to change
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

    public enum FrequencyBand {
        LTE_BAND_1("1920"),
        LTE_BAND_2("1850"),
        LTE_BAND_3("1710"),
        LTE_BAND_4("1755"),
        LTE_BAND_5("824"),
        LTE_BAND_6("830"),
        LTE_BAND_7("2500"),
        LTE_BAND_8("880"),
        WCDMA_BAND_1("2100"),
        WCDMA_BAND_2("1900"),
        WCDMA_BAND_3("1800"),
        WCDMA_BAND_4("2100/1700"),
        WCDMA_BAND_5("850US"),
        WCDMA_BAND_6("850Japan"),
        WCDMA_BAND_7("2500"),
        WCDMA_BAND_8("900");

        private String value;

        private FrequencyBand(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    public enum RUState
    {
        IDLE,
        DEACTIVATED,
        ACTIVATED
    }

    public enum RadioUnitAlarmStatusLevels
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
