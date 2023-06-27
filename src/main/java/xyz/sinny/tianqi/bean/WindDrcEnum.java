package xyz.sinny.tianqi.bean;

public enum WindDrcEnum {
    NULL(null),
    N("北风"),
    NE("东北风"),
    E("东风"),
    SE("东南风"),
    S("南风"),
    SW("西南风"),
    W("西风"),
    NW("西北风");

    private String name;
    WindDrcEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static WindDrcEnum getWindDrcEnum(String name) {
        for (WindDrcEnum wind :
                WindDrcEnum.values()) {
            if (wind.name == null)
                continue;
            if (wind.name.equals(name)) {
                return wind;
            }
        }
        return null;
    }
}
