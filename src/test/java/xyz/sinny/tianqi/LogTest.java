package xyz.sinny.tianqi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.net.URL;

public class LogTest {

    // use config File
    static{
        System.setProperty("log4j.configurationFile", "log4j_config.xml");
    }

    private static Logger logger = LogManager.getLogger(LogTest.class);

    @Test
    void log_config_test(){
        logger.entry();

        logger.trace("trace msg.");
        logger.debug("debug msg.");
        logger.info("info msg.");
        logger.error("error msg.");
        logger.fatal("fatal msg.");

        logger.exit();
    }
}
