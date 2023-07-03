package xyz.sinny.tianqi.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.util.Objects;

public class MangerTianQiImpl implements MangerTianQi {
    private TianQiDao tianQiDao = new TianQiDaoImpl();
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

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
            List links = (List) map.get("links");
            for (Object o : links) {
                // 手动解析 links 的对象
                TianQiConstraintCondition t =
                        gson.fromJson(o.toString(), TianQiConstraintCondition.class);
                list.add(t);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return queryCountyFromTianQi(list);
    }

    @Override
    public List<CountyAndCount>
    queryCountyFromTianQi(List<TianQiConstraintCondition> cc) {
        System.out.println(cc);
        return null;
    }
}
