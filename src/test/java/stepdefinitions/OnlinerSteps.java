package stepdefinitions;

import framework.BaseEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.menu.FilterForm;
import pageobjects.pages.CatalogPage;
import pageobjects.pages.MainPage;
import pageobjects.pages.SearchResultsPage;


public class OnlinerSteps extends BaseEntity {


    @Given("^user is on main page and goes to menu section (.*)$")
    public void selectMenuSection(String manuCategory) {

        MainPage mainPage = new MainPage();
        mainPage.navigateSection(manuCategory);

    }

    @When("^user selects category (.*) and subcategory (.*) and subcategory item (.*)$")
    public void selectCategorySubCategoryItem(String category, String subcategory, String item) {

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateMenu(category, subcategory);
        catalogPage.selectDropdownItem(item);

    }


    @And("^sets min (.*) diagonal$")
    public void setMinDiagonal(String min) {

        FilterForm menu = new FilterForm();
        menu.setFilter(min);
    }

    @And("^sets max (.*) diagonal$")
    public void setMaxDiagonal(String max) {

        FilterForm menu = new FilterForm();
        menu.setFilter(max);
    }

    @And("^sets brand (.*)$")
    public void serBrand(String brand) {

        FilterForm menu = new FilterForm();
        menu.setFilter(brand);
    }

    @And("^sets price (.*)$")
    public void setPrice(String price) {

        FilterForm menu = new FilterForm();
        menu.setPrice(price);

    }

    @And("^sets resolution (.*)$")
    public void setResolution(String resolution) {

        FilterForm menu = new FilterForm();
        menu.setFilter(resolution);

    }

    @Then("^search result matches desired brand (.*)$")
    public void valdiateBrand(String brand) {

        SearchResultsPage search = new SearchResultsPage();
        search.validateTitles(brand);

    }

    @And("^search result matches desired price (.*)$")
    public void validatePrice(String price) {

        SearchResultsPage search = new SearchResultsPage();
        search.validatePrices(price);

    }

    @And("^search result matches desired resolution (.*)$")
    public void validateResolution(String resolution) {

        SearchResultsPage search = new SearchResultsPage();
        search.validateSearchDescriprions(resolution);

    }

    @And("^search result matches desired diagonal from (.*) to (.*)$")
    public void validateDiagonal(String min, String max) {

        SearchResultsPage search = new SearchResultsPage();
        search.validateDimes(min, max);

    }

    @Override
    protected String formatLogMsg(String message) {
        return message;
    }
}
