package org.testinium.beymen.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseFunction {
    WebDriver driver = null;
    WebDriverWait wait = null;

    public BaseFunction(WebDriver driver){
        this.driver = driver ;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    public WebElement findElement (By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }
    public void sendKeys(By by, Keys key){
        findElement(by).sendKeys(key);
    }

    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public String getText(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public boolean checkPage(){
        String expectedTitle = "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu";
        String actualTitle = driver.getTitle();
        return actualTitle.equals(expectedTitle);
    }

    public void clearInput(By by){
        WebElement element = findElement(by);
        if (Platform.getCurrent().is(Platform.MAC)) {
            element.sendKeys(Keys.chord(Keys.COMMAND, "A"));
        } else {
            element.sendKeys(Keys.chord(Keys.CONTROL, "A"));
        }
        element.sendKeys(Keys.BACK_SPACE);
    }

    public WebElement getFirstElementInListByBy(By by){
        List<WebElement> elements = driver.findElements(by);
        return elements.get(0);
    }
}
