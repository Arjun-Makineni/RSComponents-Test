package com.test.automation.test.steps;

import com.test.automation.test.pageobjects.*;
import com.test.automation.utils.DefaultWebDriver;

abstract class StepCache {

    //Web Driver
    private static DefaultWebDriver driver;

    private DefaultWebDriver getDriver() {
        if (driver == null) {
            driver = DefaultWebDriver.createChromeDriver();
        }
        return driver;
    }

    static void quitDriverAndRefreshCache() {
        driver.getDefault().quit();
        System.out.println("Quitting driver");
        driver = null;
        homePage = null;
        categorySelectionPage = null;
    }

    //Home Page
    private static HomePage homePage;

    HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(getDriver());
        }
        return homePage;
    }

    //Category Selection Page
    private static CategorySelectionPage categorySelectionPage;

    CategorySelectionPage getCategorySelectionPage() {
        if (categorySelectionPage == null) {
            categorySelectionPage = new CategorySelectionPage(getDriver());
        }
        return categorySelectionPage;
    }

    //Product Listing Page
    private static ProductListingPage productListingPage;

    ProductListingPage getProductListingPage() {
        if (productListingPage == null) {
            productListingPage = new ProductListingPage(getDriver());
        }
        return productListingPage;
    }

}
