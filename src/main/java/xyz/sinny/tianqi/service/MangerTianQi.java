package xyz.sinny.tianqi.service;

import xyz.sinny.tianqi.bean.CountyAndCount;
import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.bean.TianQiConstraintCondition;

import java.util.List;

public interface MangerTianQi {
    // 查询天气
    TianQi queryTianQi(String county);
    List<TianQi> queryRecentTianQi(String county);

    // 查询地区
    List<CountyAndCount> queryCountyFromTianQi(String tianQiConstraintCondition);
    List<CountyAndCount> queryCountyFromTianQi(List<TianQiConstraintCondition> cc);

}
