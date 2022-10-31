package ru.dns.shop.tests.base;

import org.junit.Test;
import ru.dns.shop.framework.Counter;
import ru.dns.shop.framework.pages.*;
import ru.dns.shop.framework.pages.blocks.TopBlock;


public class SimpleCheckTest extends BaseTests {

    StartPage startPage = new StartPage();
    ListOfProductsPage listOfProductsPage = new ListOfProductsPage();
    ProductPage productPage = new ProductPage();
    BasePage basePage = new BasePage();
    CartPage cartPage = new CartPage();
    TopBlock topBlock = new TopBlock();
    Counter counter = new Counter();


    @Test
    public void simpleCheck() throws InterruptedException {
        if (startPage.confirmCityBlockIsPresent()) {
            startPage.changeCity();
            startPage.fillSearchCityBar("Москва");
            startPage.pressCityButton();
        }

        topBlock.fillSearchBar("playstation");
        topBlock.chooseProductTag("Консоли");

        listOfProductsPage.chooseProduct("Игровая консоль PlayStation 5 [825 ГБ SSD, геймпад - 1 шт, Bluetooth, Wi-Fi, белый]");

        counter.rememberPriceForProduct1();
        productPage.chooseGuarantee();
        counter.rememberPriceForProduct1();
        productPage.pressBuyButton();

        topBlock.fillSearchBar("elden ring");
        topBlock.chooseProductTag("Игры для PlayStation");

        listOfProductsPage.chooseProduct("Игра Elden Ring (PS5) [16+, ролевая игра, дата выхода: 25.02.2022, язык озвучки: английский, стандартное издание]");

        counter.rememberPriceForProduct2();
        productPage.pressBuyButton();
        counter.rememberTotalPrice();
        counter.priceInCartShower();


        topBlock.goToCart();

        cartPage.pressIncreaseItemsButtonForChosenProduct(2, "Игра Elden Ring (PS5)");
        cartPage.deleteProduct("Elden Ring");
    }
}