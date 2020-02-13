package com.test.automation.test.pageobjects;

import org.openqa.selenium.By;
import com.test.automation.utils.DefaultWebDriver;

import java.util.function.Function;

public class Page {
    DefaultWebDriver driver;

    Page(DefaultWebDriver driver){this.driver = driver;};

    Function<String, By> className = (className) -> By.cssSelector(String.format(".%s", className));

    Function<String, By> partialId = (text) -> By.cssSelector(String.format("[id*='%s']", text));

    Function<String, By> partialName = (text) -> By.cssSelector(String.format("[name*='%s']", text));

    Function<String, By> partialSelectId = (text) -> By.cssSelector(String.format("select[id*='%s']", text));

    Function<String, By> spanText = (text) -> By.xpath(String.format("//span[text()='%s']", text));

    Function<String, By> tdText = (text) -> By.xpath(String.format("//td[text()='%s']", text));

    Function<String, By> text = (text) -> By.xpath(String.format("//*[text()='%s']", text));

    Function<String, By> altText = (text) -> By.xpath(String.format("//*[@alt='%s']", text));

    Function<String, By> titleText = (text) -> By.cssSelector(String.format("[title='%s']", text));

    Function<String, By> firstPrecedingAnchorFromLabel = (label) -> By.xpath(String.format("//*[label='%s']//preceding::a[1]", label));

}
