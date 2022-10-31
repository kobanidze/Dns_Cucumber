package ru.dns.shop.framework.steps;

import io.cucumber.java.ru.И;
import ru.dns.shop.framework.pages.blocks.TopBlock;

public class TopBlockStep {

    TopBlock topBlock = new TopBlock();

    @И("^Заполнить поисковую строку продуктом (.+)$")
    public void fillSearchBar(String productName) {
        topBlock.fillSearchBar(productName);
    }

    @И("^Выбрать пункт из списка по тэгу (.+)$")
    public void chooseProductTag(String tagName) {
        topBlock.chooseProductTag(tagName);
    }

    @И("^Переходим в корзину$")
    public void goToCart() {
        topBlock.goToCart();
    }
}
