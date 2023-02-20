package xyz.sinny.tianqi.bean;

public class CountyAndCount {
    private String County;
    private Integer count;

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CountyAndCount{" +
                "County='" + County + '\'' +
                ", count=" + count +
                '}' + '\n';
    }
}
