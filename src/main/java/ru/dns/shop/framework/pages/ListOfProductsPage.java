package ru.dns.shop.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ListOfProductsPage extends BasePage{

    @FindBy(xpath = "//div[@data-id='product' and @data-preview-slider-inited]")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//span[text()='Игра Elden Ring (PS5) [16+, ролевая игра, дата выхода: 25.02.2022, язык озвучки: английский, стандартное издание]']")
    private WebElement gameShortCut;

    public ListOfProductsPage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public void chooseProduct(String nameProduct) throws InterruptedException {                         //String... nameProduct
        for (WebElement itemProductBlock :listOfProducts) {
            WebElement titleProduct = itemProductBlock.findElement(By.xpath("./a[contains(@class, 'product__name')]/span"));
            WebElement buyButton = itemProductBlock.findElement(By.xpath("./div/button"));
            if (titleProduct.getText().contains(nameProduct) || buyButton.getText().contains("Купить")) {
                titleProduct.click();
                return;
            }
        }
        Assert.fail("Продукт с именем " + nameProduct + " не найден в списке товаров");
    }

    public void chooseGame(){
        gameShortCut.click();
    }


}
