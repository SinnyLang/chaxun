package xyz.sinny.tianqi.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TianQiEnumTest {

    @Test
    void getTianQi() {
        String tq1 = "小雨";
        String tq2 = "";
        String tq3 = null;
        // 未初始化的变量拿去判断，也可以
        // 但是在木星中，未初始化的变量会编译失败
        TianQiEnum tqe;
        tqe = TianQiEnum.getTianQiEnum(tq1);
        System.out.println(tqe);
        tqe = TianQiEnum.getTianQiEnum(tq2);
        System.out.println(tqe);
        tqe = TianQiEnum.getTianQiEnum(tq3);
        System.out.println(tqe);
    }
}