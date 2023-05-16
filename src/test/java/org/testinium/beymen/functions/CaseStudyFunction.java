package org.testinium.beymen.functions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testinium.beymen.base.BaseFunction;

import java.time.Duration;

import static org.testinium.beymen.constants.CaseStudyConstants.*;

public class CaseStudyFunction extends BaseFunction {
    public CaseStudyFunction(WebDriver driver) {
        super(driver);
    }

    public CaseStudyFunction chooseGender(String gender)
    {
       try {
           if (gender.equals("KADIN"))
               click(GENDER_WOMAN_BUTTON);
           else
               click(GENDER_MAN_BUTTON);
       } finally {
           return this;
       }
    }
    public CaseStudyFunction acceptCookies() {
        try {
            click(COOKIES_BUTTON);
        } finally {
            return this;
        }
    }

    public CaseStudyFunction search(String searchText){
        sendKeys(SEARCH_INPUT,searchText);
        return this;
    }

    public CaseStudyFunction clearSearch(){
        clearInput(SEARCH_INPUT);
        return this;
    }

    public CaseStudyFunction pressEnterOnSearch(){
        sendKeys(SEARCH_INPUT, Keys.ENTER);
        return this;
    }

    public CaseStudyFunction clickProduct(){
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement firstProduct = getFirstElementInListByBy(PRODUCT);
        firstProduct.click();
        return this;
    }

    public CaseStudyFunction writeProductInfoToTxt(){
        String productName = getText(DESCRIPTION_TEXT);
        String productPrice = getText(PRICE_TEXT);

        // txtye yazılacak.

        return this;
    }

    public CaseStudyFunction addBasket(){
        click(SIZE_BUTTON);
        click(ADD_BASKET_BUTTON);
        return this;
    }

    public CaseStudyFunction comparePriceWithBasket(){
        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String productPrice = getText(PRICE_TEXT);
        click(MY_BASKET_BUTTON);
        String productPriceOnBasket = getText(PRICE_TEXT_IN_BASKET);

        if (productPrice.equals(productPriceOnBasket)){
            // log yazılacak.
        }
        else {
            // log yazılacak.
        }
        return this;
    }
    public CaseStudyFunction increaseQuantity(){
        Select quantityDropDown = new Select(findElement(QUANTITY_DROPDOWN));
        quantityDropDown.selectByIndex(1);
        return this;
    }

    public CaseStudyFunction checkQuantity(){
        Select quantityDropDown = new Select(findElement(QUANTITY_DROPDOWN));
        String quantityValue = quantityDropDown.getFirstSelectedOption().getText();
        if (quantityValue.equals("2 adet")){
            // log yazılacak.
        }
        else {
            // log yazılacak.
        }
        return this;
    }
    public CaseStudyFunction deleteItem(){
        click(DELETE_ITEM_BUTTON);
        return this;
    }

    public CaseStudyFunction checkBasket(){
        if (getText(EMPTY_BASKET_TEXT).equals("Sepetinizde Ürün Bulunmamaktadır")){
            // log yazılacak.
        }
            else {
            // log yazılacak.
        }
        return this;
    }
}
