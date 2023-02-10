package xyz.sinny.tianqi.dao.impl;

import org.junit.jupiter.api.Test;
import xyz.sinny.tianqi.bean.TianQi;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseDaoTest extends BaseDao {

    @Test
    void query() throws SQLException {
        System.out.println();

        String sql = "select * from t_weather";

        List<TianQi> list = super.queryList(sql, TianQi.class);
        System.out.println(list);

        System.out.println();
    }
}