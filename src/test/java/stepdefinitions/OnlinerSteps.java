package stepdefinitions;

import framework.BaseEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.menu.Filter;
import pageobjects.pages.CatalogPage;
import pageobjects.pages.MainPage;
import pageobjects.pages.SearchResultsPage;


public class OnlinerSteps extends BaseEntity {


    @Given("user is on main page")
    public void user_is_on_main_page() {

        MainPage mainPage = new MainPage();

    }

    @When("^user goes to menu section (.*)$")
    public void user_goes_to_catalog(String manuCategory) {

        MainPage mainPage = new MainPage();
        mainPage.navigateSection(manuCategory);

    }

    @And("^selects category (.*) and subcategory(.*)$")
    public void selects_category_electronics(String category, String subcategory) {

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateMenu(category, subcategory);

    }

    @And("^chooses item (.*)$")
    public void chooses_item_tv(String item) {

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.selectDropdownItem(item);

    }

    @And("^sets min (.*) diagonal$")
    public void sets_min_min_diagonal(String min) {
        Filter menu = new Filter();
        menu.selectCheckbox(min);
    }

    @And("^sets max (.*) diagonal$")
    public void sets_max_max_diagonal(String max) {
        Filter menu = new Filter();
        menu.selectCheckbox(max);
    }

    @And("^sets brand (.*)$")
    public void sets_brand(String brand) {
        Filter menu = new Filter();
        menu.selectCheckbox(brand);
    }

    @And("^sets price (.*)$")
    public void sets_price(String price) {
        Filter menu = new Filter();
        menu.setPrice(price);

    }

    @And("^sets resolution (.*)$")
    public void sets_resolution(String resolution) {
        Filter menu = new Filter();
        menu.selectCheckbox(resolution);

    }

    @Then("^search result matches desired brand (.*)$")
    public void search_result_matches_desired_brand(String brand) {

        SearchResultsPage search = new SearchResultsPage();
        search.validateSearchList(search.titleResultsList, brand);

    }

    @Then("^search result matches desired price (.*)$")
    public void search_result_matches_desired_price(String price) {

        SearchResultsPage search = new SearchResultsPage();
        search.validateSearchPrices(search.descriptionResultsPrice, price);

    }

    @Then("^search result matches desired resolution (.*)$")
    public void search_result_matches_desired_resolution(String resolution) {

        SearchResultsPage search = new SearchResultsPage();
        search.validateSearchList(search.descriptionResultsList, resolution);

    }

    @Then("^search result matches desired diagonal from (.*) to (.*)$")
    public void search_result_matches_desired_diagonal(String min, String max) {

        SearchResultsPage search = new SearchResultsPage();
        search.validateSearchInches(search.descriptionResultsList, min, max);

    }

    @Override
    protected String formatLogMsg(String message) {
        return null;
    }
}
