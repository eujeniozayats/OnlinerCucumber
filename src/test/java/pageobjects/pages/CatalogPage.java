package pageobjects.pages;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;


public class CatalogPage extends BasePage {

    private final String categoryLocator = "//span[text()='%s']";
    private final String subCategoryLocator = "//div[contains(text(), '%s')]";
    private final String itemLocator = "//span[contains(text(), '%s')]";

    public CatalogPage() {
        super(By.xpath("//div[@class='b-top-logo']"), "Catalog Page");
    }

    public void navigateMenu(String category, String subCategory) {
        Button btnCategory = new Button(By.xpath(String.format(categoryLocator, category)), "Category Button");
        btnCategory.clickAndWait();
        Button btnSubCategory = new Button(By.xpath(String.format(subCategoryLocator, subCategory)), "Sub category Button");
        btnSubCategory.clickAndWait();

    }

    public void selectSubCategory(String subCategory) {
        Button btnSubCategory = new Button(By.xpath(String.format(subCategoryLocator, subCategory)), "Sub category Button");
        btnSubCategory.clickAndWait();

    }

    public void selectDropdownItem(String dropItem) {
        Button btnCategory = new Button(By.xpath(String.format(itemLocator, dropItem)), "Item Button");
        btnCategory.clickAndWait();

    }

}