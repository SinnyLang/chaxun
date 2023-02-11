package xyz.sinny.tianqi.dao.impl;

import org.junit.jupiter.api.Test;
import xyz.sinny.tianqi.bean.TianQi;

import static org.junit.jupiter.api.Assertions.*;

class TianQiDaoImplTest {

    @Test
    void queryTodayByCounty() {
        TianQi today_LiChen = new TianQiDaoImpl().queryTodayByCounty("历城区");
        System.out.println(today_LiChen);

        TianQi today_DaTong = new TianQiDaoImpl().queryTodayByCounty("大同区");
        System.out.println(today_DaTong);
        assertNull(today_DaTong);

        TianQi today_ShaHai = new TianQiDaoImpl().queryTodayByCounty("上海市");
        System.out.println(today_ShaHai);
        assertNull(today_ShaHai);
    }
}