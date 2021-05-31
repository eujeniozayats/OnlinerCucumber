package framework;

import framework.browser.BrowserManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public abstract class BaseEntity {

    static final String propFile = "selenium.properties";
    public static String resourceBundlePath = "logger/logger";
    public static PropReader propReader;
    protected static ResourceBundle resourceBundle;
    protected static BrowserManager browser;
    protected static Logger logger = Logger.getInstance();

    @BeforeClass
    public static void before() {
        resourceBundle = ResourceBundle.getBundle(resourceBundlePath, Locale.forLanguageTag("en"));
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

    protected static String getLocale(final String key) {
        return resourceBundle.getString(key);
    }

    protected abstract String formatLogMsg(String message);

    protected void info(final String message) {
        logger.info(formatLogMsg(message));
    }
}