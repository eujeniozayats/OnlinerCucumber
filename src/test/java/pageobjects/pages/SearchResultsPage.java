package pageobjects.pages;

import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {


    private Label lblResultDescriptions = new Label(By.xpath("//div[@class='schema-product__description']"), "Descriptions");
    private Label lblResultPrices = new Label(By.xpath("//a[@class='schema-product__price-value schema-product__price-value_primary']"), "Prices");
    private Label lblResultTitles = new Label(By.xpath("//div[@class='schema-product__title']"), "Titles");

    public SearchResultsPage() {
        super(By.xpath("//div[@class='b-top-logo']"), "Search Results Page");
    }


    public void validateSearchDescriprions(String text) {
        lblResultDescriptions.validateLabelContainsText(text);
    }

    public void validateTitles(String text) {

        lblResultTitles.validateLabelContainsText(text);

    }

    public void validatePrices(String number) {
        lblResultPrices.validateIfLessThanNumber(number);
    }

    public void validateDimes(String min, String max) {
        lblResultDescriptions.validateNumberRange(min, max);
    }
}
