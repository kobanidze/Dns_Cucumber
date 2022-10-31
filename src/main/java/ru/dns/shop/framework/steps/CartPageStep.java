package ru.dns.shop.framework.steps;

import io.cucumber.java.ru.И;
import ru.dns.shop.framework.managers.PageManager;

public class CartPageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Нажать на кнопку увеличить количество товара (.+) раз для продукта (.+)$")
    public void pressIncreaseItemsButtonForChosenProduct(int timesIncrease, String nameProduct) throws InterruptedException {
        pageManager.getCartPage().pressIncreaseItemsButtonForChosenProduct(timesIncrease, nameProduct);
    }

    @И("^Удаляем продукт (.+) из корзины$")
    public void deleteProduct(String nameProduct) throws InterruptedException {
        pageManager.getCartPage().deleteProduct(nameProduct);
    }
}
