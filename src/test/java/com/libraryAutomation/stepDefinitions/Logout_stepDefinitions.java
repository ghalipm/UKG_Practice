package com.libraryAutomation.stepDefinitions;


import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.LogoutPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Logout_stepDefinitions {

    LogoutPage logoutPage = new LogoutPage();
    LoginPage loginPage = new LoginPage();

    @Given("user logout")
    public void user_logout() {
        logoutPage.logout();
    }

    @Then("user land on login page")
    public void user_land_on_login_page() {
        BrowserUtils.waitForVisibility(loginPage.getUsernameBox(),5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }
}
