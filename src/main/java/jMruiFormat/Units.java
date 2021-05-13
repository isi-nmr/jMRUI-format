package jMruiFormat;

public enum Units {
    SEC ("s"),
    MSEC ("ms"),
    USEC ("us"),
    METER ("m"),
    MM ("mm"),
    MICRON ("um"),
    Hz ("Hz"),
    KHz ("KHz"),
    MHz ("MHz"),
    PPM ("ppm"),
    RPS ("rps");
    private final String name;
    Units(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
