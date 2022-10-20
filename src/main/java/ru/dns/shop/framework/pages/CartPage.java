package ru.dns.shop.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

//    @FindBy(xpath = "//button[@class='count-buttons__button count-buttons__button_plus']")
//    private WebElement increaseItemsButton;

    @FindBy(xpath = "//div[@class='cart-items__product']")
    private List<WebElement> productsInCart;

    @FindBy(xpath = "//p[@class='remove-button__title']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@class='count-buttons__input']")
    private WebElement inputForNumberOfProducts;

    @FindBy(xpath = "//button//i[@class='count-buttons__icon count-buttons__icon-plus']")
    private WebElement increaseItemsButton;

    public CartPage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public void pressIncreaseItemsButtonForChosenProduct(int timesIncrease, String nameProduct) throws InterruptedException {
//        WebElement inputOfProduct = driverManager.getDriver().
//                findElement(By.xpath("("+inputForNumberOfProducts+")["+numberOfProductInList+"]"));
//        WebElement increaseButton = driverManager.getDriver().
//                findElement(By.xpath("("+increaseItemsButton+")["+numberOfProductInList+"]"));
//        int a = Integer.parseInt(inputForNumberOfProducts.getAttribute("value"));
//        int b = 0;
//        while (Integer.parseInt(inputForNumberOfProducts.getAttribute("value")) < a+timesIncrease) {
//            b = Integer.parseInt(inputForNumberOfProducts.getAttribute("value"));
//            increaseItemsButton.click();
//            while(Integer.parseInt(inputForNumberOfProducts.getAttribute("value")) < b+1) {
//                continue;
//            }
//        }
        for (WebElement productInCart: productsInCart) {
            WebElement titleProduct = productInCart.findElement(By.xpath("./div[@class='cart-items__product-name']/a"));
            if (titleProduct.getText().contains(nameProduct)) {
                int a = Integer.parseInt(inputForNumberOfProducts.getAttribute("value"));
                int b = 0;
                while (Integer.parseInt(inputForNumberOfProducts.getAttribute("value")) < a+timesIncrease) {
                    b = Integer.parseInt(inputForNumberOfProducts.getAttribute("value"));
                    increaseItemsButton.click();
                    while(Integer.parseInt(inputForNumberOfProducts.getAttribute("value")) < b+1) {
                        continue;
                    }
                }
            }

        }
        Assert.fail("Продукт с именем " + nameProduct + " не найден в списке товаров");
    }

    public void deleteProduct(String nameProduct) throws InterruptedException {                         //String... nameProduct
        for (WebElement productInCart : productsInCart) {
            WebElement titleProduct = productInCart.findElement(By.xpath("./div[@class='cart-items__product-name']"));
            if (titleProduct.getText().contains(nameProduct)) {
                deleteButton.click();
                return;
            }
        }
        Assert.fail("Продукт с именем " + nameProduct + " не найден в списке товаров");
    }

//    public void pressDeleteButton(String numberOfProductToDelete) {
//        WebElement delete = driverManager.getDriver().
//                findElement(By.xpath("("+deleteButton+")["+numberOfProductToDelete+"]"));
//        delete.click();
//    }

}
