package org.testinium.beymen.base;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseScenario {

    static WebDriver webDriver=null;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(options));
        getWebDriver().navigate().to("https://www.beymen.com/");
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static void setWebDriver (WebDriver webDriver){
        BaseScenario.webDriver= webDriver;
    }

    public void tearDown(){
        getWebDriver().quit();
    }
}
