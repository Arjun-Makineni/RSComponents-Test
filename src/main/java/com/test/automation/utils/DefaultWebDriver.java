package com.test.automation.utils;

import io.github.pramcharan.wd.binary.downloader.WebDriverBinaryDownloader;
import io.github.pramcharan.wd.binary.downloader.enums.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DefaultWebDriver {

    private WebDriver driver;

    private DefaultWebDriver(String browserType) {
        switch (browserType) {
            case "chrome":
               WebDriverBinaryDownloader.create().downloadLatestBinaryAndConfigure(Browser.CHROME);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }
    }

    public WebDriver getDefault() {
        return driver;
    }

    public static DefaultWebDriver createChromeDriver() {
        return new DefaultWebDriver(BrowserType.CHROME);
    }

    public DefaultWebDriver go(String url) {
        driver.navigate().to(url);
        return this;
    }

    public Boolean isElementPresent(By by){
        return find(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
    }

    public DefaultWebDriver click(By by) {
        find(ExpectedConditions.elementToBeClickable(by)).click();
        return  this;
    }

    public DefaultWebDriver type(By by, String input ){
        find(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(input);
        return this;
    }

    public String getText(By by) {
        return find(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

    public DefaultWebDriver checkElement(ExpectedCondition<Boolean> condition) {
        check(condition);
        return this;
    }

    private WebElement find(ExpectedCondition<WebElement> condition) {
        return new FluentWait<>(driver)
                .ignoring(WebDriverException.class)
                .withTimeout(Duration.ofSeconds(45))
                .until(condition);
    }

    private Boolean check(ExpectedCondition<Boolean> condition) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(45))
                .ignoring(WebDriverException.class)
                .until(condition);
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
