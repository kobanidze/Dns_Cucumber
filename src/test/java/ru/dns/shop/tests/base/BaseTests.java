package ru.dns.shop.tests.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.dns.shop.framework.managers.*;
import ru.dns.shop.framework.utils.PropConst;


public class BaseTests {


    private DriverManager driverManager = DriverManager.getINSTANCE();
    private TestPropManager propManager = TestPropManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();


    @BeforeClass
    public static void beforeClass() {
        InitManager.initFramework();
    }


    @Before
    public void before(){
        driverManager.getDriver().get(propManager.getProperty(PropConst.BASE_URL));
    }

    @AfterClass
    public void after(){
        InitManager.quitFramework();
    }
}