package ua.net.itlabs.operations;

import com.codeborne.selenide.Configuration;

public class BaseTest {

    static {
        Configuration.browser = System.getProperty("driver.browser");
        Configuration.pageLoadStrategy = "normal";
    }
}
