package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends AbstractPage {

    @FindBy(linkText = "Secure Area")
    private ExtendedWebElement secureAreaHeader;

    @FindBy(xpath = "//*[contains(@href, '/logout')]")
    private ExtendedWebElement logoutButton;

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSecureAreaHeaderDisplayed() {
        return secureAreaHeader.isDisplayed();
    }

    public void clickLogoutButton() {
        logoutButton.scrollTo();
        this.logoutButton.click();
    }
}
