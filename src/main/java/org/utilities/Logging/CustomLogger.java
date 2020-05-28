package org.utilities.Logging;

import lombok.SneakyThrows;
import org.apache.log4j.*;

/**
 * @author Bharath.MC
 * @since May-2020
 */
public class CustomLogger {
    static Logger logger = Logger.getLogger(CustomLogger.class);

    @SneakyThrows
    public static Logger GetLogger(String FileName) {
        Logger logger = Logger.getLogger(CustomLogger.class);
        SimpleLayout simpleLayout = new SimpleLayout();
        PatternLayout patternLayout = new PatternLayout("%d{ISO8601} %-5p %x - %m%n");
        FileAppender appender = new FileAppender(patternLayout,FileName,true);
        logger.addAppender(appender);
        logger.setLevel((Level) Level.DEBUG);

        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("");
        logger.info("-------------------------------   CUSTOM LOGGER   ----------------------------------------------");
        logger.info("");
        logger.info("------------------------------------------------------------------------------------------------");
        return logger;
    }
}
