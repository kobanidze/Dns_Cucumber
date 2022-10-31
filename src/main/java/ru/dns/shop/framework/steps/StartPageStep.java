package ru.dns.shop.framework.steps;

import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import ru.dns.shop.framework.managers.PageManager;
import ru.dns.shop.framework.pages.blocks.TopBlock;

public class StartPageStep {


    PageManager pageManager = PageManager.getInstance();

    @И("^Проверить наличие кнопки подтверждения города$")
    public void confirmCityBlockIsPresent() {
        pageManager.getStartPage().confirmCityBlockIsPresent();
    }

    @И("^Нажать кнопку сменить город$")
    public void changeCity() {
        pageManager.getStartPage().changeCity();
    }

    @И("^Написать в поисковой строке город (.+)$")
    public void fillSearchCityBar(String cityName) {
        pageManager.getStartPage().fillSearchCityBar(cityName);
    }

    @И("^Нажать на кнопку с названием города$")
    public void pressCityButton() throws InterruptedException {
        pageManager.getStartPage().pressCityButton();
    }

}
