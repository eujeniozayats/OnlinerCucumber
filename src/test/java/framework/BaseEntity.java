package framework;

import framework.browser.BrowserManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BaseEntity {

    static final String propFile = "selenium.properties";
    public static PropReader propReader;
    protected static BrowserManager browser;
    protected static Logger logger = Logger.getInstance();

    @BeforeClass
    public static void before() {
        propReader = new PropReader(propFile);
        browser = BrowserManager.getInstance();
        browser.getDriver().manage().window().maximize();
        browser.getDriver().manage().deleteAllCookies();
        browser.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(propReader.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        browser.getDriver().manage().timeouts().pageLoadTimeout(Long.parseLong(propReader.getProperty("defaultPageLoadTimeout")), TimeUnit.SECONDS);
        browser.navigate(propReader.getProperty("url"));
    }

    @AfterClass
    public static void after() {

        browser.exit();

    }

    protected abstract String formatLogMsg(String message);

    protected void info(final String message) {
        logger.info(formatLogMsg(message));
    }
}