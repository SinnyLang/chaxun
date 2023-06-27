package xyz.sinny.tianqi.bean;

import java.sql.Date;

public class TianQi {
    private String county;
    private Date date;
    private TianQiEnum dayWthr = TianQiEnum.NULL;
    private String dayTmp;
    private TianQiEnum nightWthr = TianQiEnum.NULL;
    private String nightTmp;
    private WindPowerEnum windPwr = WindPowerEnum.NULL;
    private WindDrcEnum windDrct = WindDrcEnum.NULL;

    @Override
    public String toString() {
        return "TianQi{" +
                "county='" + county + '\'' +
                ", date=" + date +
                ", dayWthr='" + dayWthr + '\'' +
                ", dayTmp='" + dayTmp + '\'' +
                ", nightWthr='" + nightWthr + '\'' +
                ", nightTmp='" + nightTmp + '\'' +
                ", windPwr='" + windPwr + '\'' +
                ", windDrct='" + windDrct + '\'' +
                '}' + '\n';
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDayWthr() {
        return dayWthr.getName();
    }

    public void setDayWthr(String dayWthr) {
        this.dayWthr = TianQiEnum.getTianQiEnum(dayWthr);
    }

    public String getDayTmp() {
        return dayTmp;
    }

    public void setDayTmp(String dayTmp) {
        this.dayTmp = dayTmp;
    }

    public String getNightWthr() {
        return nightWthr.getName();
    }

    public void setNightWthr(String nightWthr) {
        this.nightWthr = TianQiEnum.getTianQiEnum(nightWthr);
    }

    public String getNightTmp() {
        return nightTmp;
    }

    public void setNightTmp(String nightTmp) {
        this.nightTmp = nightTmp;
    }

    public String getWindPwr() {
        return windPwr.getName();
    }

    public void setWindPwr(String windPwr) {
        this.windPwr = WindPowerEnum.getWindPower(windPwr);
    }

    public String getWindDrct() {
        return windDrct.getName();
    }

    public void setWindDrct(String windDrct) {
        this.windDrct = WindDrcEnum.getWindDrcEnum(windDrct);
    }
}
