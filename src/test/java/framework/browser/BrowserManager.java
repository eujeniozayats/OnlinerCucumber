package framework.browser;

import framework.BaseEntity;
import framework.PropReader;
import org.openqa.selenium.WebDriver;

import javax.naming.NamingException;

public final class BrowserManager extends BaseEntity {

    static final String propFile = "selenium.properties";
    public static BrowserTypes currentBrowser;
    private static BrowserManager browserInstance;
    private static WebDriver driver;

    private BrowserManager() {
        currentBrowser.toString();
    }

    public static BrowserManager getInstance() {

        if (browserInstance == null) {
            initBrowserProperties();
            try {
                driver = BrowserFactory.initialize(currentBrowser.toString());
            } catch (NamingException e) {
                e.printStackTrace();
            }
            browserInstance = new BrowserManager();
        }
        return browserInstance;
    }


    private static void initBrowserProperties() {

        propReader = new PropReader(propFile);
        currentBrowser = BrowserTypes.valueOf(System.getProperty("browser"));

    }


    public void exit() {
        driver.quit();
        browserInstance = null;
    }

    public void navigate(final String url) {
        driver.navigate().to(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected String formatLogMsg(String message) {
        return null;
    }
}
