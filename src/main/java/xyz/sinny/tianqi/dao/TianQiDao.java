package xyz.sinny.tianqi.dao;

import xyz.sinny.tianqi.bean.CountyAndCount;
import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.bean.TianQiConstraintCondition;

import java.util.List;

public interface TianQiDao {
    // 实现查询某地今天天气的方法
    // implement rtn:  String of county -> JavaBean Data
    TianQi queryTodayByCounty(String county);

    // 实现根据天气查询某地的方法
    // implement rtn:  class of constraint condition -> JavaBean List
    /**
     * query county
     * @param listTianQiCC list of class of TianQi constraint condition
     * @return List of all bean of county satisfies the constraint conditions and
     * its count
     */
    List<CountyAndCount> queryCountyByTianQi(List<TianQiConstraintCondition> listTianQiCC);
}
