package xyz.sinny.tianqi;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;
import xyz.sinny.tianqi.bean.TianQi;
import xyz.sinny.tianqi.utils.ResLoader;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestGson {
    @Test
    void json_to_obj_while_json_key_more_obj_field(){
        // 这种解析方式会产生错误，因为json中由id，Bean中没有id属性
        String json = "{\"id\":999\"name\":\"张三\",\"age\":18}";
        Gson gson = new Gson();

        User zs = gson.fromJson(json, User.class);

        System.out.println(zs);
    }

    @Test
    void json_to_obj_while_json_key_fewer_obj_field(){
        String json = "{\"name\":\"张三\"}";
        Gson gson = new Gson();

        User zs = gson.fromJson(json, User.class);

        System.out.println(zs);
    }

    @Test
    void json_to_obj_one_by_one() throws IOException, URISyntaxException, IllegalAccessException, InstantiationException {
        InputStream inputStream = new ResLoader().loadJsonExample();
        String json = IOUtils.toString(inputStream, "utf-8");
        System.out.println(json);
        Gson gson = new Gson();

        Map map = gson.fromJson(json, Map.class);
        System.out.println(map);

        List<Map> links = (List<Map>) map.get("links");
        System.out.println("links= " + links);

        TianQi tianQi = new TianQi();
        BeanMap beanMap = BeanMap.create(tianQi);
        Map linkMap = links.get(0);
        System.out.println("link[0]="+linkMap);
        Map tianQiMap = (Map) linkMap.get("TianQiBean");
        tianQiMap.put("date", new java.sql.Date(System.currentTimeMillis()));
        beanMap.putAll(tianQiMap);
        System.out.println(tianQi);
    }

    class User{
        private String name;
        private String age;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
