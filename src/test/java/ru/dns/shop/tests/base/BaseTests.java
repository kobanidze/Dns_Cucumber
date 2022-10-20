package ru.dns.shop.tests.base;

import org.junit.Before;
import ru.dns.shop.framework.managers.DriverManager;


public class BaseTests {


    private DriverManager driverManager = DriverManager.getINSTANCE();


    @Before
    public void before(){
        driverManager.getDriver().get("https://www.dns-shop.ru/");
    }

//    @After
//    public void after(){
//        driverManager.getDriver().quit();
//    }
}