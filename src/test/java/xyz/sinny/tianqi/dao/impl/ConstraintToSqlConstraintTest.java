package xyz.sinny.tianqi.dao.impl;

import org.junit.jupiter.api.Test;
import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.bean.TianQiConstraintCondition;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConstraintToSqlConstraintTest {
    @Test
    void translate(){
        List<TianQiConstraintCondition> list = new ArrayList<>();
        TianQi tq = new TianQi();
        tq.setCounty("济南市");
        tq.setDate(new Date(System.currentTimeMillis()));
        tq.setDayTmp("23");
        tq.setDayWthr("晴天");
        tq.setNightTmp("10");
        tq.setNightWthr("多云");
        tq.setWindDrct("东风");
        tq.setWindPwr("2-3");
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
        list.add(tqc);

        String sqlCC = new ConstraintToSqlConstraint(list).translate();
        System.out.println(sqlCC);

    }
}