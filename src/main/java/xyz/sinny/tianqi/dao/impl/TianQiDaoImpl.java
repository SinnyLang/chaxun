package xyz.sinny.tianqi.dao.impl;

import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.dao.TianQiDao;

public class TianQiDaoImpl extends BaseDao implements TianQiDao {
    // 继承 BaseDao 的查询数据库方法

    @Override
    public TianQi queryTodayByCounty(String county) {
        String sql = "SELECT * FROM t_weather WHERE TO_DAYS(date) = TO_DAYS(NOW()) AND county = \""+ county + "\" ;";
        return super.queryOne(sql, TianQi.class);
    }
}
