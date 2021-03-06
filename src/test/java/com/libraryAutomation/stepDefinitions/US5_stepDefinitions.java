package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.pages.DashboardPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US5_stepDefinitions extends BasePage {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    UsersPage usersPage=new UsersPage();
    Select select=new Select(usersPage.recordsDropDown);

    @Then("show records default value should be {string}")
    public void show_records_default_value_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement firstRecordsWE= select.getFirstSelectedOption();
        String firstRecordsText=firstRecordsWE.getText();
        System.out.println("firstRecordsText = " + firstRecordsText);
        Assert.assertEquals(firstRecordsText,string);
    }

    @Then("show records should  have following count options:")
    public void show_records_should_have_following_count_options(List<String> expectedOptions) {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> recordsWE= select.getOptions();
        List<String> recordsText=new ArrayList<>();

        for (WebElement each: recordsWE) {
            recordsText.add(each.getText());
        }

        System.out.println("recordsText = " + recordsText);
        System.out.println("expectedOptions = " + expectedOptions);
        Assert.assertEquals(recordsText, expectedOptions);

    }





}
