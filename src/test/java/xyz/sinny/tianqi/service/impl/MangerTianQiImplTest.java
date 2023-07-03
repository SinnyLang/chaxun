package xyz.sinny.tianqi.service.impl;

import org.junit.jupiter.api.Test;
import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.service.MangerTianQi;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MangerTianQiImplTest {

    MangerTianQi mangerTianQi = new MangerTianQiImpl();

    @Test
    void queryRecentTianQi() {
        List<TianQi> list = mangerTianQi.queryRecentTianQi("历城区");
        System.out.println(list);
    }

    @Test
    void queryCountyFromTianQi() {

        mangerTianQi.queryCountyFromTianQi(json);
    }


    private String json = "{\n" +
            "    \"statue\": \"200\",\n" +
            "    \"links\": [\n" +
            "        {\n" +
            "            \"tianQi\": {\n" +
            "                \"dayWthr\": \"SUNNY\",\n" +
            "                \"date\": 2022-01-02,\n" +
            "                \"dayTmp\": 23,\n" +
            "                \"nightWthr\": \"CLOUDY\",\n" +
            "                \"nightTmp\": 13,\n" +
            "                \"windPwr\": \"POWER_2_\",\n" +
            "                \"windDrct\": \"N\"\n" +
            "            },\n" +
            "            \"isForward\": false,\n" +
            "            \"dateType\": 0,\n" +
            "            \"dayType\": false,\n" +
            "            \"dayTmpType\": 0,\n" +
            "            \"nightType\": false,\n" +
            "            \"nightTmpType\": 0,\n" +
            "            \"windPowerType\": 0,\n" +
            "            \"windDrctType\": false\n" +
            "        },\n" +
            "        {\n" +
            "            \"tianQi\": {\n" +
            "                \"dayWthr\": \"SUNNY\",\n" +
            "                \"date\": 2022-01-03,\n" +
            "                \"dayTmp\": 23,\n" +
            "                \"nightWthr\": \"CLOUDY\",\n" +
            "                \"nightTmp\": 13,\n" +
            "                \"windPwr\": \"POWER_2_\",\n" +
            "                \"windDrct\": \"N\"\n" +
            "            },\n" +
            "            \"isForward\": false,\n" +
            "            \"dateType\": 0,\n" +
            "            \"dayType\": true,\n" +
            "            \"dayTmpType\": 0,\n" +
            "            \"nightType\": true,\n" +
            "            \"nightTmpType\": 0,\n" +
            "            \"windPowerType\": 0,\n" +
            "            \"windDrctType\": true\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}