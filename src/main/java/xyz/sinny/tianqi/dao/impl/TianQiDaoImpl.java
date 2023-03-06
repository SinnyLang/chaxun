package xyz.sinny.tianqi.dao.impl;

import xyz.sinny.tianqi.bean.CountyAndCount;
import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.bean.TianQiConstraintCondition;
import xyz.sinny.tianqi.dao.TianQiDao;

import java.util.List;

public class TianQiDaoImpl extends BaseDao implements TianQiDao {
    // 继承 BaseDao 的查询数据库方法

    @Override
    public TianQi queryTodayByCounty(String county) {
        String sql = "SELECT * FROM t_weather WHERE TO_DAYS(date) = TO_DAYS(NOW()) AND county = \""+ county + "\" ;";
        return super.queryOne(sql, TianQi.class);
    }

    @Override
    public List<TianQi> queryRecentTianQi(String county) {
        String sql = "SELECT * FROM t_weather WHERE county = \"" + county + "\";";
        return super.queryList(sql, TianQi.class);
    }

    @Override
    public List<CountyAndCount> queryCountyByTianQi(List<TianQiConstraintCondition> listTianQiCC) {
        String constraintsCondition = new ConstraintToSqlConstraint(listTianQiCC).translate();
        String sql =
                "SELECT county, count(county) as \"count\" FROM t_weather WHERE ("
                + constraintsCondition
                + ") GROUP BY county";
        System.out.println(sql);
        return super.queryList(sql, CountyAndCount.class);
    }
}
