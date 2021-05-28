package framework.elements;

import framework.BaseEntity;
import framework.Logger;
import framework.browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseElement extends BaseEntity {

    private static final int TIMEOUT_WAIT_0 = 0;
    private static final int IMPLICITLY = 30;
    protected String elementName;
    protected By locator;
    protected WebElement element;

    protected BaseElement(final By loc, final String name) {
        locator = loc;
        elementName = name;
    }

    public void waitTillElementNotStale() {
        (new WebDriverWait(browser.getDriver(), IMPLICITLY)).until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = (new WebDriverWait(browser.getDriver(), IMPLICITLY)).until(ExpectedConditions.presenceOfElementLocated(locator));
        (new WebDriverWait(browser.getDriver(), IMPLICITLY)).until(ExpectedConditions.stalenessOf(element));
        (new WebDriverWait(browser.getDriver(), IMPLICITLY)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected abstract String getElementType();

    protected String formatLogMsg(final String message) {
        return String.format("%1$s '%2$s' %3$s %4$s", getElementType(), elementName, Logger.logDelimiterString, message);
    }

    public void sendKeys(String key) {
        waitForIsElementPresent();
        browser.getDriver().findElement(locator).sendKeys(key);
    }

    public void waitForIsElementPresent() {

        isPresent(Integer.parseInt(propReader.getProperty("defaultConditionTimeout")));
        if (!element.isDisplayed()) {
            Assert.fail();
        }
        Assert.assertTrue(element.isDisplayed());
    }

    public void check() {
        waitForIsElementPresent();
        (new WebDriverWait(browser.getDriver(), IMPLICITLY)).until(ExpectedConditions.elementToBeClickable(element));
        final JavascriptExecutor js = (JavascriptExecutor) browser.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        (new WebDriverWait(BrowserManager.getInstance().getDriver(), IMPLICITLY)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) browser.getDriver()).executeScript("return document.readyState").equals("complete"));
    }


    public void clickAndWait() {
        waitForIsElementPresent();
        (new WebDriverWait(browser.getDriver(), IMPLICITLY)).until(ExpectedConditions.elementToBeClickable(element));
        final JavascriptExecutor js = (JavascriptExecutor) browser.getDriver();
        //info(getLocale("loc.clicking"));
        element.click();
        (new WebDriverWait(browser.getDriver(), IMPLICITLY)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) browser.getDriver()).executeScript("return document.readyState").equals("complete"));
        WebDriverWait wait = new WebDriverWait(BrowserManager.getInstance().getDriver(), Long.parseLong(propReader.getProperty("defaultPageLoadTimeout")));

        try {
            wait.until((ExpectedCondition<Boolean>) d -> {
                if (!(d instanceof JavascriptExecutor)) {
                    return true;
                }
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                return result instanceof Boolean && (Boolean) result;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        waitForIsElementPresent();
        return element.getText();
    }

    public boolean isPresent() {

        return isPresent(TIMEOUT_WAIT_0);
    }


    public boolean isPresent(int timeout) {

        WebDriverWait wait = new WebDriverWait(BrowserManager.getInstance().getDriver(), timeout);
        browser.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(propReader.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        try {
            wait.until((ExpectedCondition<Boolean>) driver -> {
                try {
                    List<WebElement> list = driver.findElements(locator);
                    for (WebElement el : list) {
                        if (el != null && el.isDisplayed()) {
                            element = el;
                            return element.isDisplayed();
                        }
                    }
                    element = driver.findElement(locator);
                } catch (Exception e) {
                    return false;
                }
                return element.isDisplayed();
            });
        } catch (Exception e) {
            return false;
        }
        try {
            browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(propReader.getProperty("defaultConditionTimeout")), TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}






