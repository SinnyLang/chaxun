package xyz.sinny.tianqi.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import xyz.sinny.tianqi.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BaseDao {
    // 提供查询操作 提供删除操作
    // implement rtn:  SQL Data -> ResultSet Data -> Object<T>

    QueryRunner queryRunner = new QueryRunner();

    /**
     * Execute an SQL SELECT without any replacement parameters.
     * @return javaBean List
     * */
    public <T> List<T> queryList(String sql, Class<T> type){
        Connection conn = JdbcUtil.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeConnection(conn);
        }
        return null;
    }

    public <T>T queryOne(String sql, Class<T> type){
        Connection conn = JdbcUtil.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeConnection(conn);
        }
        return null;
    }

    //
    public void delete(String sql){
        Connection conn = JdbcUtil.getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
