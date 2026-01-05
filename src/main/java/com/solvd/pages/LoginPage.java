package com.solvd.pages;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(linkText = "Login Page")
    private ExtendedWebElement loginHeader;

    @FindBy(id="username")
    private ExtendedWebElement username;

    @FindBy(id="password")
    private ExtendedWebElement password;

    @FindBy(xpath = "//*[contains (@type, 'submit')]")
    private ExtendedWebElement loginButton;

    public void fillLoginForm(String username, String password) {
        this.username.type(username);
        this.password.type(password);
    }

    public SecureAreaPage clickLoginButton() {
        loginButton.scrollTo();
        this.loginButton.click();
        return new SecureAreaPage(driver);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    public void openLoginPage(){
////        openURL("/login");
//        driver.get(R.CONFIG.get("url"));
//    }

    public boolean isPageOpened(){
        return loginHeader.isPresent();
    }
}
