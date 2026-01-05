package com.solvd.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AlertMessage extends AbstractUIObject {

    @FindBy(id = "flash")
    private ExtendedWebElement flash;

    public AlertMessage(WebDriver webDriver, SearchContext searchContext) {
        super(webDriver, searchContext);
    }

    public boolean isAlertMessageDisplayed() {
        return flash.isDisplayed();
    }
}
