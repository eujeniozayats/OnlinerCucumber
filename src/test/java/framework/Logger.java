package framework;

import org.testng.Reporter;

public final class Logger {


    public static final String logDelimiterString = "::";
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);
    private static final boolean logSteps = true;
    private static Logger instance = null;


    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void step(final int step) {
        logDelimiter(BaseEntity.getLocale("logger.step") + step);
    }


    private void logDelimiter(final String msg) {
        if (logSteps) {
            info(String.format("......::[ %1$s ]::......", msg));
        }
    }

    public void info(final String message) {
        logger.info(message);
        Reporter.log(message + "<br>");
    }

}

