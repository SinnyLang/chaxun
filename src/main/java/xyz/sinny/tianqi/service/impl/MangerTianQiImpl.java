package xyz.sinny.tianqi.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import xyz.sinny.tianqi.bean.CountyAndCount;
import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.bean.TianQiConstraintCondition;
import xyz.sinny.tianqi.dao.TianQiDao;
import xyz.sinny.tianqi.dao.impl.TianQiDaoImpl;
import xyz.sinny.tianqi.service.MangerTianQi;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MangerTianQiImpl implements MangerTianQi {
    private TianQiDao tianQiDao = new TianQiDaoImpl();
    private Gson gson = new Gson();

    @Override
    public TianQi queryTianQi(String county) {
        return tianQiDao.queryTodayByCounty(county);
    }

    @Override
    public List<TianQi> queryRecentTianQi(String county) {
        return tianQiDao.queryRecentTianQi(county);
    }

    @Override
    public List<CountyAndCount>
    queryCountyFromTianQi(String tianQiConstraintCondition) {
        List<TianQiConstraintCondition> list = new ArrayList<>();
        try {
            Map map = gson.fromJson(tianQiConstraintCondition, Map.class);
            List<String> links = (List<String>) map.get("links");
            for (String s : links) {
                // 手动解析 links 的对象
                TianQiConstraintCondition t =
                        gson.fromJson(s, TianQiConstraintCondition.class);
                list.add(t);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CountyAndCount>
    queryCountyFromTianQi(List<TianQiConstraintCondition> cc) {
        return null;
    }
}
