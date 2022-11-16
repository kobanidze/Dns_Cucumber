package ru.dns.shop.framework.pages.blocks;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.dns.shop.framework.pages.BasePage;

import java.time.Duration;
import java.util.List;

public class TopBlock extends BasePage {



    @FindBy(xpath = "//nav//input[contains(@class, 'ui-input-search__input')]")
    private WebElement searchProductBar;

    @FindBy(xpath = "//a[@class='ui-link presearch__suggest']")
    private List<WebElement> listOfProductsInSearchBar;

    @FindBy(xpath = "//div[@class='header-menu-wrapper']/div[@class='buttons']/a")
    private WebElement topThreeButtons;

    public TopBlock(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public void fillSearchBar(String productName){
        WebElement searBar = (new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(3))).
                until(ExpectedConditions.elementToBeClickable(searchProductBar));
        searBar.click();
        fulfillBar(searBar, productName);
    }

    public void chooseProductTag(String tagName){
        for (WebElement tagsOfProducts : listOfProductsInSearchBar) {
            WebElement titleProduct = tagsOfProducts.findElement(By.xpath("//span[contains(@class,'category-suffix')]"));
            if (titleProduct.getText().contains(tagName)) {
                titleProduct.click();
                return;
            }
        }
        Assert.fail("Тэг с именем " + tagName + " не найден в списке поиска товаров");
    }

    public void goToCart() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driverManager.getDriver()).
                executeScript("document.evaluate(\"//div[@class='header-menu-wrapper']/div[@class='buttons']/a[@class='ui-link cart-link']\", document).iterateNext().click()");
            }

}
