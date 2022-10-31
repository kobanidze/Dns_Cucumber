package ru.dns.shop.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.dns.shop.framework.managers.DriverManager;


public class StartPage extends BasePage{

    @FindBy(xpath = "(//button[contains(.,'Сменить город')])[1]")
    private WebElement changeCityButton;

    @FindBy(xpath = "//input[@class='base-ui-input-search__input']")
    private WebElement searchCityBar;

    @FindBy(xpath = "//mark[contains(., Москва)]")
    private WebElement cityButton;

    @FindBy(xpath = "//nav//input[contains(@class, 'ui-input-search__input')]")
    private WebElement searchProductBar;

    @FindBy(xpath = "//span[contains(@class, 'v-confirm-city') and text()='Ваш город']")
    private WebElement confirmCityBlock;


    public StartPage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public boolean confirmCityBlockIsPresent() {
        return confirmCityBlock.isDisplayed();
    }

    public void changeCity(){
        changeCityButton.click();
    }

    public void fillSearchCityBar(String cityName){
        waitUntilAvailible();
        fulfillBar(searchCityBar, cityName);
    }

    public void pressCityButton() throws InterruptedException {
        cityButton.click();
        // ожидать появления элемента "Москва"
        Thread.sleep(2000);
    }

    public void waitUntilAvailible() {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return searchCityBar.isEnabled();
            }
        });
    }


}