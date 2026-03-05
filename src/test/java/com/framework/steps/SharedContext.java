package com.framework.steps;

import org.openqa.selenium.WebDriver;
import com.framework.base.BaseClass;
import com.framework.pages.HomePage;
import com.framework.pages.productPage;

public class SharedContext {
    
    public WebDriver driver;
    public HomePage home;
    public productPage productpage;

    public void initPages() {
        this.driver = BaseClass.driver;
        this.home = new HomePage(driver);
        this.productpage = new productPage(driver);
    }
}