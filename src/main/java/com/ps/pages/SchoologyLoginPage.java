package com.ps.pages;

import com.ps.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchoologyLoginPage extends TestBase {

    @FindBy(xpath="//input[@id='edit-mail']")
    WebElement userName;

    @FindBy(xpath="//input[@id='edit-pass']")
    WebElement password;

    @FindBy(xpath="//input[@id='edit-submit']")
    WebElement loginButton;

    public SchoologyLoginPage(){
        PageFactory.initElements(driver,this);
    }

    /**
     * This method uses following parameters to perform login functionality
     * @param username
     * @param pwd
     * */
    public SchoologyHomePage loginToSchoology(String username,String pwd){
        userName.sendKeys(username);
        password.sendKeys(pwd);
        loginButton.click();
        return new SchoologyHomePage();
    }
}
