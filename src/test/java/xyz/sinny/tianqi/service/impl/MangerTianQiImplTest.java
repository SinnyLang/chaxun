package xyz.sinny.tianqi.service.impl;

import org.junit.jupiter.api.Test;
import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.service.MangerTianQi;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MangerTianQiImplTest {

    @Test
    void queryRecentTianQi() {
        MangerTianQi mangerTianQi = new MangerTianQiImpl();
        List<TianQi> list = mangerTianQi.queryRecentTianQi("历城区");
        System.out.println(list);
    }
}