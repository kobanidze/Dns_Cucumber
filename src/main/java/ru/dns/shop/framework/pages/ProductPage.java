package ru.dns.shop.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

    @FindBy(xpath = "(//button[contains(text(), 'Купить')])[1]")
    private WebElement buyButton;

    @FindBy(xpath = "//div[@class='additional-sales-tabs__title' and contains(., 'Гарантия')]")
    private WebElement guaranteeButton;

    @FindBy(xpath = "//span[@class='ui-radio__content' and contains(., '24')]")
    private WebElement twoYearsGuarantee;

    @FindBy(xpath = "//nav//input[contains(@class, 'ui-input-search__input')]")
    private WebElement searchProductBar;

    @FindBy(xpath = "//span[@class='category-suffix' and contains(text(), 'PlayStation')]")
    private WebElement productTag;





    public ProductPage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public void chooseGuarantee(){
        guaranteeButton.click();
        twoYearsGuarantee.click();
    }

    public void pressBuyButton(){
        buyButton.click();
    }

    public void putGameNameInSearchBar(String gameName){
        fulfillBar(searchProductBar, gameName);
    }

    public void chooseGameTag(){
        productTag.click();
    }





}
