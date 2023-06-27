package xyz.sinny.tianqi.bean;

public enum WindPowerEnum {
    NULL(null),
    POWER_0("0"),
    POWER_1("1"),
    POWER_1_("1-2"),
    POWER_2("2"),
    POWER_2_("2-3"),
    POWER_3("3"),
    POWER_3_("3-4"),
    POWER_4("4"),
    POWER_4_("4-5"),
    POWER_5("5"),
    POWER_5_("5-6"),
    POWER_6("6"),
    POWER_6_("6-7"),
    POWER_7("7"),
    POWER_7_("7-8"),
    POWER_8("8"),
    POWER_8_("8-9"),
    POWER_9("9"),
    POWER_9_("9-10"),
    POWER_10("10"),
    POWER_10_("10-11"),
    POWER_11("11"),
    POWER_11_("11-12"),
    POWER_12("12");

    private String name;

    WindPowerEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static WindPowerEnum getWindPower(String name) {
        for (WindPowerEnum tq :
                WindPowerEnum.values()) {
            if (tq.name == null)
                continue;
            if (tq.name.equals(name)) {
                return tq;
            }
        }
        return null;
    }
}
