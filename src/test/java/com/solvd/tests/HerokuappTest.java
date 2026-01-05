package com.solvd.tests;

import com.solvd.components.AlertMessage;
import com.solvd.pages.LoginPage;
import com.solvd.pages.SecureAreaPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HerokuappTest extends AbstractTest {
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;
    private AlertMessage alertMessage;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void successfulLoginTest(){
        loginPage = new LoginPage(getDriver());
        loginPage.open();
        softAssert.assertTrue(loginPage.isPageOpened());

        loginPage.fillLoginForm(R.TESTDATA.get("USERNAME"), R.TESTDATA.get("PASSWORD"));
        secureAreaPage = loginPage.clickLoginButton();

        softAssert.assertTrue(secureAreaPage.isPageOpened());
        softAssert.assertAll();
    }

//    @Test
//    public void unsuccessfulLoginTest(){
//        loginPage.openLoginPage();
//        softAssert.assertTrue(loginPage.isPageOpened());
//
//        loginPage.fillLoginForm(R.CONFIG.get("invalid_username"), R.CONFIG.get("invalid_password"));
//        softAssert.assertTrue(alertMessage.isAlertMessageDisplayed());
//    }
}
