package org.testinium.beymen.constants;

import org.openqa.selenium.By;

public class CaseStudyConstants {

    public static final By GENDER_WOMAN_BUTTON = By.id("genderWomanButton");
    public static final By GENDER_MAN_BUTTON = By.id("genderManButton");
    public static final By COOKIES_BUTTON = By.id("onetrust-accept-btn-handler");
    public static final By SEARCH_INPUT = By.xpath("//input[@placeholder='Ürün, Marka Arayın']");
    public static final By PRODUCT = By.className("m-productCard");
    public static final By DESCRIPTION_TEXT = By.className("o-productDetail__description");
    public static final By PRICE_TEXT = By.id("priceNew");
    public static final By SIZE_BUTTON = By.xpath("//span[normalize-space()='S']");
    public static final By ADD_BASKET_BUTTON = By.id("addBasket");
    public static final By MY_BASKET_BUTTON = By.xpath("//a[@title='Sepetim']//span[@class='o-header__userInfo--text']");
    public static final By PRICE_TEXT_IN_BASKET = By.className("m-productPrice__salePrice");
    public static final By QUANTITY_DROPDOWN = By.id("quantitySelect0-key-0");
    public static final By DELETE_ITEM_BUTTON = By.id("removeCartItemBtn0-key-0");
    public static final By EMPTY_BASKET_AREA = By.id("emtyCart");
}

