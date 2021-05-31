package pageobjects.menu;

import framework.BasePage;
import framework.elements.Checkbox;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class FilterForm extends BasePage {

    private final String checkboxLocator = "//li/label[@class='schema-filter__checkbox-item']/span[text()='%s']";
    private final Label lblProductTitle = new Label(By.xpath("//div[@class='schema-product__title']"), "Title Label");
    private final TextBox txbPriceToField = new TextBox(By.xpath("//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price'][@placeholder='до']"), "Price Field");

    public FilterForm() {
        super(By.xpath("//div[@class='b-top-logo']"), "Filter Form");
    }

    public void setPrice(String price) {
        txbPriceToField.sendKeys(price);
    }

    public void selectCheckbox(String checkboxName) {
        Checkbox checkbox = new Checkbox(By.xpath(String.format(checkboxLocator, checkboxName)), checkboxName);
        checkbox.check();
        lblProductTitle.waitTillElementNotStale();
    }
}
