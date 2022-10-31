package ru.dns.shop.framework.steps;

import io.cucumber.java.ru.И;
import ru.dns.shop.framework.managers.PageManager;

public class ListOfProductPageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Выбрать продукт по названию (.+)$")
    public void chooseProduct(String nameProduct) throws InterruptedException {
        pageManager.getListOfProductsPage().chooseProduct(nameProduct);
    }
}
