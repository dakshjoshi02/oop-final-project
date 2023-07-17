package rusystem;

public enum RURFPorts {
    RF_0("A"),
    RF_1("B"),
    RF_2("C"),
    RF_3("D"),
    RF_4("E"),
    RF_5("F"),
    RF_6("G"),
    RF_7("H");

    // HashMap<Character, RURFPorts> RFPortMap;

    private String value;

    private RURFPorts(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


