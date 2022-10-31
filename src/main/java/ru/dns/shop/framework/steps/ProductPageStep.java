package ru.dns.shop.framework.steps;

import io.cucumber.java.ru.И;
import ru.dns.shop.framework.managers.PageManager;

public class ProductPageStep {

    PageManager pageManager = PageManager.getInstance();


    @И("^Выбираем гарантию на продукт$")
    public void chooseGuarantee() {
        pageManager.getProductPage().chooseGuarantee();
    }

    @И("^Нажимаем на кнопку купить$")
    public void pressBuyButton() {
        pageManager.getProductPage().pressBuyButton();
    }
}
