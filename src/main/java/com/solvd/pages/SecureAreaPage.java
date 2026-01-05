package com.solvd.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends AbstractPage {

    @FindBy(xpath = "//*[text()=' Secure Area']")
    private ExtendedWebElement secureAreaHeader;

    @FindBy(xpath = "//*[contains(@href, '/logout')]")
    private ExtendedWebElement logoutButton;

    public SecureAreaPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(secureAreaHeader);
    }

    public void clickLogoutButton() {
        logoutButton.scrollTo();
        this.logoutButton.click();
    }
}
