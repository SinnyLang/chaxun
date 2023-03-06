package xyz.sinny.tianqi.utils.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DateTypeAdapter extends TypeAdapter<Object> {
    private final TypeAdapter<Object> delegate = new Gson().getAdapter(Object.class);

    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public Object read(JsonReader in) throws IOException {
        JsonToken token = in.peek();
        switch (token){
            case BEGIN_ARRAY:
                List<Object> list = new ArrayList<>();
                in.beginArray();
                while (in.hasNext()){
                    list.add(read(in));
                }
                in.endArray();
                return list;

            case BEGIN_OBJECT:
                Map<String, Object> map = new LinkedTreeMap<>();
                in.beginObject();
                while (in.hasNext()){
                    map.put(in.nextName(), read(in));
                }
                in.endObject();

            case STRING:
                return in.nextString();

            case NUMBER:
                Double dbNum = in.nextDouble();

                if (dbNum > Long.MAX_VALUE){
                    return dbNum;
                }

                Long lNum = Double.doubleToLongBits();
                /**
                 *  Json转化为Obj，因为Gson自动将int转化成了double，导致
                 *  spring的beanMapTianQi对象了
                 */

        }
        return null;
    }
}
