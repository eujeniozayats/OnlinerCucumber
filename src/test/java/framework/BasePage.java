package framework;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

public abstract class BasePage extends BaseEntity {

    protected String title;

    public BasePage(final By locator, final String pageTitle) {
        title = pageTitle;
        Label pageTarget = new Label(locator, pageTitle);
        Assert.assertTrue(pageTarget.isPresent());

    }


    protected String formatLogMsg(final String message) {
        return message;
    }
}