package pageobjects.menu;

import framework.BasePage;
import framework.elements.Checkbox;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class Filter extends BasePage {

    private final String checkboxLocator = "//li/label[@class='schema-filter__checkbox-item']/span[text()='%s']";
    private final Label lblProductTitle = new Label(By.xpath("//div[@class='schema-product__title']"), "Title Label");
    private final TextBox txbPriceToField = new TextBox(By.xpath("//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price'][@placeholder='до']"), "Price Field");

    public Filter() {
        super(By.xpath("//div[@class='b-top-logo']"), "Catalog Page");
    }

    public void setPrice(String price) {
        txbPriceToField.sendKeys(price);
    }

    public void selectCheckbox(String checkboxName) {
        Checkbox checkbox = new Checkbox(By.xpath(String.format(checkboxLocator, checkboxName)), "Filtering checkbox");
        checkbox.check();
        lblProductTitle.waitTillElementNotStale();
    }
}
