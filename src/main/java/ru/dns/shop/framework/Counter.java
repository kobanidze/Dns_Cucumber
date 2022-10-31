package ru.dns.shop.framework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.dns.shop.framework.pages.BasePage;

import java.time.Duration;

public class Counter extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'product-buy__price')]")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='header-menu-wrapper']/div[@class='buttons']/a[@class='ui-link cart-link']//span[@class='cart-link__price']")
    private WebElement priceInCart;

    public Counter(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    String string = "//div[contains(@class, 'product-buy__price')]";

    int productPrice1 = 0;
    int productPrice2 = 0;
    int totalPrice = 0;
    int cartPrice = 0;

    public void pressCartButton(){
        WebElement element = (new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(priceInCart));
        element.click();
    }

    public void waiter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(productPrice))));
    }

    public void rememberPriceForProduct1(){
        productPrice1 = shower(productPrice);
        System.out.println(productPrice1);
    }

    public void rememberPriceForProduct2(){
        productPrice2 = shower(productPrice);
        System.out.println(productPrice2);
    }

    public void rememberTotalPrice() {
        totalPrice += productPrice1 + productPrice2;
        System.out.println(totalPrice);
    }

    public void priceInCartShower() throws InterruptedException {
        cartPrice += shower(priceInCart);
        Thread.sleep(1500);
        //добавить ожидание появления фрейма
    }


    public int shower(WebElement priceElement){
        WebElement str = (new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(3))).
                until(ExpectedConditions.visibilityOf(priceElement));
        String s = str.getText();
        String[] parts = s.split(" ₽");
        String firstPart = parts[0].replaceAll(" ", "");
        return Integer.parseInt(firstPart);
    }





}
