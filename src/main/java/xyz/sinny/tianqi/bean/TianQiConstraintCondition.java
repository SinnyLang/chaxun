package xyz.sinny.tianqi.bean;

public class TianQiConstraintCondition {
    private TianQi tianQi;
    private Boolean isForward;
    private Byte dateType;
    private Boolean dayType; // 只有等于和不等于
    private Byte dayTmpType;
    private Boolean nightType;
    private Byte nightTmpType;
    private Byte windPowerType;
    private Boolean windDrctType;

    public Boolean getWindDrctType() {
        return windDrctType;
    }

    public void setWindDrctType(Boolean winDrctType) {
        this.windDrctType = winDrctType;
    }

    public Boolean getDayType() {
        return dayType;
    }

    public void setDayType(Boolean dayType) {
        this.dayType = dayType;
    }

    public Boolean getNightType() {
        return nightType;
    }

    public void setNightType(Boolean nightType) {
        this.nightType = nightType;
    }

    public Byte getNightTmpType() {
        return nightTmpType;
    }

    public void setNightTmpType(Byte nightTmpType) {
        this.nightTmpType = nightTmpType;
    }

    public TianQi getTianQi() {
        return tianQi;
    }

    public void setTianQi(TianQi tianQi) {
        this.tianQi = tianQi;
    }

    public Boolean getForward() {
        return isForward;
    }

    public void setForward(Boolean forward) {
        isForward = forward;
    }

    public Byte getDateType() {
        return dateType;
    }

    public void setDateType(Byte dateType) {
        this.dateType = dateType;
    }

    public Byte getDayTmpType() {
        return dayTmpType;
    }

    public void setDayTmpType(Byte dayTmpType) {
        this.dayTmpType = dayTmpType;
    }

    public Byte getWindPowerType() {
        return windPowerType;
    }

    public void setWindPowerType(Byte winPowerType) {
        this.windPowerType = winPowerType;
    }

    @Override
    public String toString() {
        return "TianQiConstraintCondition{" +
                "tianQi=" + tianQi +
                ", isForward=" + isForward +
                ", dateType=" + dateType +
                ", dayType=" + dayType +
                ", dayTmpType=" + dayTmpType +
                ", nightType=" + nightType +
                ", nightTmpType=" + nightTmpType +
                ", winPowerType=" + windPowerType +
                ", winDrctType=" + windDrctType +
                '}';
    }
}
