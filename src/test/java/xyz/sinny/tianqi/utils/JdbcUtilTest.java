package xyz.sinny.tianqi.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class JdbcUtilTest {
    static Connection conn = JdbcUtil.getConnection();

    @Test
    void assert_connection_and_close(){
        assertNotNull(conn);
        System.out.println(conn);
    }

    @AfterAll
    static void close_connection(){
        JdbcUtil.closeConnection(conn);
    }
}