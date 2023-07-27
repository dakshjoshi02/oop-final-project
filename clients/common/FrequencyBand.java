package common;

public enum FrequencyBand
 {
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

    private FrequencyBand(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}