package framework.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.naming.NamingException;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class BrowserFactory {

    public static WebDriver initialize(final BrowserTypes type) {

        WebDriver driver = null;

        switch (type) {

            case firefox:
                File firefoxFile = null;

                URL firefoxUrl = ClassLoader.getSystemResource("geckodriver.exe");
                try {
                    firefoxFile = new File(firefoxUrl.toURI());
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                assert firefoxFile != null;
                System.setProperty("webdriver.gecko.driver", firefoxFile.getAbsolutePath());

                driver = new FirefoxDriver();
                break;

            case chrome:
                File chromeFile = null;

                URL chromeUrl = ClassLoader.getSystemResource("chromedriver.exe");
                try {
                    chromeFile = new File(chromeUrl.toURI());
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                assert chromeFile != null;
                System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());

                driver = new ChromeDriver();
                break;

            default:
                break;

        }
        return driver;
    }

    public static WebDriver initialize(final String type) throws NamingException {
        for (BrowserTypes t : BrowserTypes.values()) {
            if (t.toString().equalsIgnoreCase(type)) {
                return initialize(t);
            }
        }
        throw new NamingException();
    }
}