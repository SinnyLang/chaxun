package xyz.sinny.tianqi.bean;

import java.sql.Date;

public class TianQi {
    private String county;
    private Date date;
    private String dayWthr;
    private String dayTmp;
    private String nightWthr;
    private String nightTmp;
    private String windPwr;
    private String windDrct;

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
        return dayWthr;
    }

    public void setDayWthr(String dayWthr) {
        this.dayWthr = dayWthr;
    }

    public String getDayTmp() {
        return dayTmp;
    }

    public void setDayTmp(String dayTmp) {
        this.dayTmp = dayTmp;
    }

    public String getNightWthr() {
        return nightWthr;
    }

    public void setNightWthr(String nightWthr) {
        this.nightWthr = nightWthr;
    }

    public String getNightTmp() {
        return nightTmp;
    }

    public void setNightTmp(String nightTmp) {
        this.nightTmp = nightTmp;
    }

    public String getWindPwr() {
        return windPwr;
    }

    public void setWindPwr(String windPwr) {
        this.windPwr = windPwr;
    }

    public String getWindDrct() {
        return windDrct;
    }

    public void setWindDrct(String windDrct) {
        this.windDrct = windDrct;
    }
}
