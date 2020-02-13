package com.test.automation.test.steps;

import com.test.automation.utils.envConfig;
import io.cucumber.java.en.Given;

public class HomePageSteps extends StepCache {

    public HomePageSteps() {}

    @Given("^the user is on homepage$")
    public void userOnHomepage() {
        getHomePage().launch(envConfig.HOST_URL);
    }

    @Given("^user searches for (.*)$")
    public void searchesForKeyWord(String keyWord){
        getHomePage().search(keyWord);
    }



}
