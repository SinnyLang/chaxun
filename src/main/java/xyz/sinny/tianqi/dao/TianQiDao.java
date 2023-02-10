package xyz.sinny.tianqi.dao;

import xyz.sinny.tianqi.bean.TianQi;

public interface TianQiDao {
    // 实现查询某地今天天气的方法 实现根据天气查询地区的方法
    // implement rtn:  ResultSet Data -> JavaBean Data
    TianQi queryTodayByCounty(String county);

}
