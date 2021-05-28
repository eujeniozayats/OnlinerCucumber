package pageobjects.pages;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private final String menuLocator = "//span[text()='%s' and @class='b-main-navigation__text']";

    public MainPage() {
        super(By.xpath("//div[@class='b-top-logo']"), "Main Page");
    }

    public void navigateSection(String section) {
        Button btnMenuItem = new Button(By.xpath(String.format(menuLocator, section)), "Menu Item Button");
        btnMenuItem.clickAndWait();
    }
}