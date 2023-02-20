package xyz.sinny.tianqi.dao.impl;

import xyz.sinny.tianqi.bean.TianQiConstraintCondition;

import java.util.ArrayList;
import java.util.List;

public class ConstraintToSqlConstraint {

    private List<TianQiConstraintCondition> listTianQiCC;
    private List<String> sqlConsCond = new ArrayList<>();

    public ConstraintToSqlConstraint(List<TianQiConstraintCondition> listTianQiCC) {
        this.listTianQiCC = listTianQiCC;
    }


    /**
     *  ！！！ 为了保证转换的正确进行不发生空指针异常，条件约束的内容不得为空 ！！！
     * @return SqlCC Objects -> sqlCC String
     */
    public String translate() {
        for (TianQiConstraintCondition tianQiCC : listTianQiCC) {
            if (tianQiCC == null) throw new NullPointerException("约束条件对象是空对象，tianQiCC is null");
            String sqlConstraint = translate_1(tianQiCC);
            sqlConsCond.add(sqlConstraint);
        }

        return joinSqlConsCond();
    }

    private String joinSqlConsCond() {
        StringBuilder stringBuilder = new StringBuilder("( \n");

        int i;
        for (i = 0; i < sqlConsCond.size() - 1; i++){
            stringBuilder.append("(")
                    .append(sqlConsCond.get(i))
                    .append(")")
                    .append("\n OR \n");
        }

        // 连接最后一段字符串
        stringBuilder.append("(")
                .append(sqlConsCond.get(i))
                .append(")");

        stringBuilder.append("\n)");

        return stringBuilder.toString();
    }

    /**
    {
    "TianQiBean": { "day": "晴天", "date": 2, "dayTmp": 23, "night": "多云", "nightTmp": 13, "windPower": "2-3", "windDis": "东风"},
    "isForward": false,
    "dateType": 0,      // > < = >= <= !=
    "dayTmpType": 0,
    "nightTmpType": 0,
    "windPowerType": 0
    }
     */
    private String translate_1(TianQiConstraintCondition tianQiCC) {
        // first is date constraint
        // date = "2023-1-1"
        StringBuilder sqlStr = new StringBuilder("date");
        sqlStr.append(getSqlCompareChar(tianQiCC.getDateType()));
        sqlStr.append("\"");
            String date1 = tianQiCC.getTianQi().getDate().toString();
//            System.out.println("C2SC date = " + date1);
        sqlStr.append(date1);
        sqlStr.append("\"");

        // second is day
        // date = "2023-1-1" AND day = "晴天"
        String day = tianQiCC.getTianQi().getDayWthr();
        if(day != null){
            sqlStr.append(" AND dayWthr")
                    .append(getSqlCompareChar(tianQiCC.getDayType()))
                    .append("\"")
                    .append(day)
                    .append("\"");
        }

        // date = "2023-1-1" AND day = "晴天" AND dayTmp = 23
        String dayTmp = tianQiCC.getTianQi().getDayTmp();
        if (dayTmp != null){
            sqlStr.append(" AND dayTmp")
                    .append(getSqlCompareChar(tianQiCC.getDayTmpType()))
                    .append(dayTmp);
        }

        // date = "2023-1-1" AND day = "晴天" AND dayTmp = 23 AND night != "多云"
        String night = tianQiCC.getTianQi().getNightWthr();
        if (night != null){
            sqlStr.append(" AND nightWthr")
                    .append(getSqlCompareChar(tianQiCC.getNightType()))
                    .append("\"")
                    .append(night)
                    .append("\"");
        }

        // date = "2023-1-1" AND day = "晴天" AND dayTmp = 23 AND night != "多云
        String nightTmp = tianQiCC.getTianQi().getNightTmp();
        if (nightTmp != null){
            sqlStr.append(" AND nightTmp")
                    .append(getSqlCompareChar(tianQiCC.getNightTmpType()))
                    .append(nightTmp);
        }

        // 风力不好做比较，因为由于 "2-3"级风力这种格式的存在，致使比较困难
//        String windPwr = tianQiCC.getTianQi().getWindPwr();
//        if (windPwr != null){
//            sqlStr.append(" AND windPwr")
//                    .append(getSqlCompareChar(tianQiCC.getWinPowerType()))
//                    .append("\"")
//                    .append(night)
//                    .append("\"");
//        }

        String windDrct = tianQiCC.getTianQi().getWindDrct();
//        Boolean windDrctType = tianQiCC.getWinDrctType();
        if (nightTmp != null){
            sqlStr.append(" AND windDrct")
                    .append(getSqlCompareChar(tianQiCC.getWinDrctType()))
                    .append("\"")
                    .append(windDrct)
                    .append("\"");
        }

//        System.out.println(sqlStr);
        return sqlStr.toString();
    }

    /**
     * 根据比较类型返回比较符号，如果类型是0，则表示等于的意思
     * @param type 比较类型，约束条件中应该包含比较类型
     * @return 比较符
     */
    private String getSqlCompareChar(Byte type){
        switch (type){
            case 0:
                return " = ";
            case 1:
                return " > ";
            case 2:
                return " < ";
            case 3:
                return " >= ";
            case 4:
                return " <= ";
            case 5:
                return " != ";
        }
        return null;
    }

    // 天气只能是或者不是晴天，不能大于晴天
    private String getSqlCompareChar(Boolean type){
//        if (type == null) return " = ";
        return type?" = ":" != ";
    }
}
