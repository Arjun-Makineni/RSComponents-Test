package com.test.automation.test.steps;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;

import io.cucumber.java.After;

public class Hook {

    @After()
    public void after() {
       StepCache.quitDriverAndRefreshCache();
    }
}
