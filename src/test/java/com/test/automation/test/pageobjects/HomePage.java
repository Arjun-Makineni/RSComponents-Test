package com.test.automation.test.pageobjects;

import com.test.automation.utils.DefaultWebDriver;
import org.openqa.selenium.By;

public class HomePage extends Page {

    public HomePage(DefaultWebDriver driver) {
        super(driver);
    }

    public HomePage launch(String url){
        driver.go(url);
        acceptCookieConsent();
        return this;
    }

    public void search(String keyword){
        driver.type(By.id("searchTerm"), keyword);
        driver.click(By.id("btnSearch"));
    }

    private void acceptCookieConsent() {
        if(driver.isElementPresent(By.className("cookie-consent")))
        driver.click(By.id("js-cookie-accept"));
    }
}
