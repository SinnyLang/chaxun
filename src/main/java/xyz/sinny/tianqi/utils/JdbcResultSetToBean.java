package xyz.sinny.tianqi.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;

/**
 * Unused Class.
 * Because this translation of ResultSet->Bean is completed
 * by common-dbutils.
 */
public class JdbcResultSetToBean {


    public static <T> List<T> getList(ResultSet rs, Class<T> clazz){
        Field[] fields = clazz.getDeclaredFields();
        return null;
    }
}
