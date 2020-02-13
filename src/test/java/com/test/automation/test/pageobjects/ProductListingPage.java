package com.test.automation.test.pageobjects;

import com.test.automation.utils.DefaultWebDriver;
import org.openqa.selenium.By;

public class ProductListingPage extends Page {

    public ProductListingPage(DefaultWebDriver driver) {
        super(driver);
    }

    public boolean isProductListingPageDisplayed() {
        return driver.isElementPresent(By.className("breadcrumbContainer"));
    }

    public void sortProductsByPrice(String sort){
        switch (sort.toLowerCase()) {
            case "asc":
                driver.click(By.xpath("//*[@id=\'P_breakPrice1\']/button[1]"));
                break;

            case "desc":
                driver.click(By.xpath("//*[@id=\'P_breakPrice1\']/button[2]"));
                break;
            default:
                throw new RuntimeException(" Sort type not found " + sort);
        }
    }

}
