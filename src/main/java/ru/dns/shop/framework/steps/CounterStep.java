package ru.dns.shop.framework.steps;

import io.cucumber.java.ru.И;
import ru.dns.shop.framework.Counter;

public class CounterStep {

    Counter counter = new Counter();


    @И("^Запоминаем цену первого продукта$")
    public void rememberPriceForProduct1() {
        counter.rememberPriceForProduct1();
    }

    @И("^Запоминаем цену второго продукта$")
    public void rememberPriceForProduct2() {
        counter.rememberPriceForProduct2();
    }

    @И("^Запоминаем итогововую цену$")
    public void rememberTotalPrice() {
        counter.rememberTotalPrice();
    }
}
