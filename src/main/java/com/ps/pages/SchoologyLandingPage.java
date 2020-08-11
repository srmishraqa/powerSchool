package com.ps.pages;

import com.ps.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class SchoologyLandingPage extends TestBase {

    @FindBy(xpath="//a[@id='login-header']")
    WebElement loginLink;

    public SchoologyLandingPage(){
        PageFactory.initElements(driver,this);
    }

    /**
     * This method clicks on login link and since login page gets opened in another tab
     * this is handled here
     */
    public SchoologyLoginPage clickOnLoginLink(){
        loginLink.click();
        String originalWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for(String h : handles){
            if(!h.equals(originalWindow)){
                driver.switchTo().window(h);

            }
        }
        return new SchoologyLoginPage();
    }
}
