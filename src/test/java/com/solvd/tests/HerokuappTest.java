package com.solvd.tests;

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

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(getDriver());
        loginPage.open();
    }

    @Test
    public void successfulLoginTest(){
        softAssert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");

        loginPage.fillLoginForm(R.TESTDATA.get("USERNAME"), R.TESTDATA.get("PASSWORD"));
        secureAreaPage = loginPage.clickLoginButton();

        softAssert.assertTrue(secureAreaPage.isPageOpened(), "Secure Area Page is not opened");
        softAssert.assertAll();
    }

    @Test
    public void unsuccessfulLoginTest(){
        softAssert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");

         loginPage.fillLoginForm(R.TESTDATA.get("invalid_username"), R.TESTDATA.get("invalid_password"));

        secureAreaPage = loginPage.clickLoginButton();

        softAssert.assertFalse(secureAreaPage.isPageOpened(), "Secure Area Page should not be opened");

        softAssert.assertTrue(loginPage.isAlertMessageDisplayed(),
                "Alert message should be displayed");

        softAssert.assertAll();
    }
}
