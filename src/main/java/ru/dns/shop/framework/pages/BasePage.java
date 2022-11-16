package ru.dns.shop.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.dns.shop.framework.managers.DriverManager;

import java.time.Duration;

public class BasePage {

    @FindBy(xpath = "//div[@class='header-menu-wrapper']//a[contains(@class, 'ui-link')]//span[@class='cart-link__lbl']")
    private WebElement cartButton;



    protected DriverManager driverManager = DriverManager.getINSTANCE();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(1000));

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public void fulfillBar(WebElement xpath, String object){
        xpath.click();
        xpath.sendKeys(object);
    }


    FluentWait<WebDriver> fluentWait = new FluentWait<>(driverManager.getDriver())
            .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(200))
                            .ignoring(NoSuchElementException.class);

    public void pressCartButton(){
//        WebElement element = (new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10)))
//                .until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }


}
