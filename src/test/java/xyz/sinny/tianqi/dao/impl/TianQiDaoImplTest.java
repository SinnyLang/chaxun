package xyz.sinny.tianqi.dao.impl;

import org.junit.jupiter.api.Test;
import xyz.sinny.tianqi.bean.CountyAndCount;
import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.bean.TianQiConstraintCondition;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

        List<TianQi> today_ShaHais = new TianQiDaoImpl().queryRecentTianQi("大同区");
        System.out.println(today_ShaHais);
    }

    @Test
    void queryCountyByTianQi() throws ParseException {
        List<TianQiConstraintCondition> list = new ArrayList<>();
        TianQi tq = new TianQi();
        tq.setCounty("济南市");
        tq.setDate(new Date(
                new SimpleDateFormat("yyyyMMdd")
                        .parse("20230128")
                        .getTime()
            ));
//        tq.setDayTmp("23");
        tq.setDayWthr("多云");
//        tq.setNightTmp("10");
//        tq.setNightWthr("多云");
//        tq.setWindDrct("东风");
//        tq.setWindPwr("2-3");
        System.out.println(tq);

        TianQiConstraintCondition tqc = new TianQiConstraintCondition();
        tqc.setDateType((byte) 4);
        tqc.setDayTmpType((byte) 2);
        tqc.setDayType(true);
        tqc.setNightTmpType((byte) 0);
        tqc.setNightType(false);
        tqc.setWinPowerType((byte) 0);
        tqc.setWinDrctType(true);
        tqc.setTianQi(tq);

        System.out.println(tqc);

        list.add(tqc);

        TianQi tq1 = new TianQi();
        tq1.setCounty("济南市");
        tq1.setDate(new Date(
                new SimpleDateFormat("yyyyMMdd")
                        .parse("20230128")
                        .getTime()
        ));
//        tq.setDayTmp("23");
        tq1.setDayWthr("多云");
//        tq.setNightTmp("10");
//        tq.setNightWthr("多云");
//        tq.setWindDrct("东风");
//        tq.setWindPwr("2-3");
        System.out.println(tq1);

        TianQiConstraintCondition tqc1 = new TianQiConstraintCondition();
        tqc1.setDateType((byte) 0);
        tqc1.setDayTmpType((byte) 2);
        tqc1.setDayType(true);
        tqc1.setNightTmpType((byte) 0);
        tqc1.setNightType(false);
        tqc1.setWinPowerType((byte) 0);
        tqc1.setWinDrctType(true);
        tqc1.setTianQi(tq1);

        System.out.println(tqc1);
        list.add(tqc1);

        // String sqlCC = new ConstraintToSqlConstraint(list).translate();
        List<CountyAndCount> list1 = new TianQiDaoImpl().queryCountyByTianQi(list);

        System.out.println(list1);
    }
}