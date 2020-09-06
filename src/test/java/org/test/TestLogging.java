package org.test;

import lombok.SneakyThrows;
import org.apache.log4j.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Bharath.MC
 * @since May-2020
 */
public class TestLogging {
    static Logger logger = Logger.getLogger(TestLogging.class);

    @Test
    @SneakyThrows
    public void testLogging() {
        // setting up a FileAppender dynamically...
        SimpleLayout layout = new SimpleLayout();
        PatternLayout patternLayout = new PatternLayout("%d{ISO8601} %-5p %x - %m%n");
        FileAppender fileAppender = new FileAppender(patternLayout,"logs/custom.log",true);
        ConsoleAppender consoleAppender  = new ConsoleAppender(patternLayout);
        logger.addAppender(fileAppender);
        logger.addAppender(consoleAppender);

        logger.setLevel((Level) Level.DEBUG);

        logger.debug("Here is some DEBUG");
        logger.info("Here is some INFO");
        logger.warn("Here is some WARN");
        logger.error("Here is some ERROR");
        logger.fatal("Here is some FATAL");
    }
}
