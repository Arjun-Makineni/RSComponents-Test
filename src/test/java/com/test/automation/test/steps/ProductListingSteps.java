package com.test.automation.test.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProductListingSteps extends StepCache {

    @Then("product listings page with filters displayed")
    public void productListingsPageWithFiltersDisplayed() {
        Assert.assertTrue(getProductListingPage().isProductListingPageDisplayed());
    }
}
