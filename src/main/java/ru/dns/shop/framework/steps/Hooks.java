package ru.dns.shop.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.dns.shop.framework.managers.InitManager;

public class Hooks {




    @Before
    public void before(){
        InitManager.initFramework();
    }

    @After
    public void after() {
        InitManager.quitFramework();
    }

}
