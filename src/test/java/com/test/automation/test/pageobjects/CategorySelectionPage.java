package com.test.automation.test.pageobjects;

import com.test.automation.utils.DefaultWebDriver;
import org.openqa.selenium.By;

public class CategorySelectionPage extends Page{

    public CategorySelectionPage(DefaultWebDriver driver) {
        super(driver);
    }

    public boolean isCategoriesListDisplayed(){
        return driver.isElementPresent(By.id("sidebar"));
    }

    public boolean noResultsDisplayed() {
        return driver.isElementPresent(By.id("zeroResults"));
    }


    public String getResultsHeader(){
        String results = driver.getText(By.className("search-matches"));
        System.out.println(results);
        return results;
    }


    public void selectCategory(String catIndex, String subIndex){
        driver
        .click(By.cssSelector("#sidebar > section > div:nth-child(" + catIndex + ") > div > ul > li:nth-child(" + subIndex + ")"));

    }

}
