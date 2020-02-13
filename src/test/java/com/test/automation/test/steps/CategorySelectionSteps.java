package com.test.automation.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CategorySelectionSteps extends StepCache {

    private WebDriver driver;

    @Then("^search results page displayed$")
    public void searchResultsPageDisplayed() {
        Assert.assertTrue(getCategorySelectionPage().isCategoriesListDisplayed());
        Assert.assertTrue(getCategorySelectionPage().getResultsHeader() != null);
    }

    @And("select from category index (.*) and sub index (.*)")
    public void selectFromCategoryTree(String catIndex, String subIndex) {
        getCategorySelectionPage().selectCategory(catIndex, subIndex);
    }
}
