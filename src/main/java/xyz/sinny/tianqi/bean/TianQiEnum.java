package xyz.sinny.tianqi.bean;
import java.lang.Enum;

public enum TianQiEnum {
    // 晴，多云，阴，雷雨，小雨，中雨，大雨，暴雨，大暴雨
    SUNNY("晴"),
    CLOUDY("多云"),
    THUNDER("雷雨"),
    LIGHT("小雨"),
    MODERATE("中雨"),
    HEAVY("大雨");

    private String name;

    TianQiEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TianQiEnum getTianQiEnum(String name) {
        for (TianQiEnum tq :
                TianQiEnum.values()) {
            if (tq.name.equals(name)) {
                return tq;
            }
        }
        return null;
    }

}
