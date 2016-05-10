package ua.net.itlabs.testconfig;

import com.codeborne.selenide.Configuration;

public class BaseTest {

    static {
        Configuration.browser = System.getProperty("driver.browser");
        Configuration.pageLoadStrategy = "normal";
    }
}
