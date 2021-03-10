package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
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

public class US10_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();


    @Given("the user librarian is on the homepage")
    public void the_user_librarian_is_on_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.login("librarian");
    }

    @When("the user click users module")
    public void the_user_click_users_module() {
        // Write code here that turns the phrase above into concrete actions
        usersPage.usersLink.click();

    }

    @Then("the user should see the following column names:")
    public void the_user_should_see_the_following_column_names(List<String> expectedColumnNames) {
        // option1:
         /*
        for (int i = 0; i < usersPage.tableHeaders.size(); i++) {
            Assert.assertEquals(usersPage.tableHeaders.get(i).getText(), expectedColumnNames.get(i));
        }
         */

        //option2:
        List<String> actualColumnNames = BrowserUtils.getElementsText(usersPage.tableHeaders);
        Assert.assertEquals(actualColumnNames, expectedColumnNames);
        System.out.println("actualColumnNames = " + actualColumnNames);
        System.out.println("expectedColumnNames = " + expectedColumnNames);

    }


    @When("the user click Status dropdown")
    public void the_user_click_status_dropdown() {
        // Write code here that turns the phrase above into concrete actions
            usersPage.userStatusDropDown.click();
    }

    @Then("the user should see the following options on user status:")
    public void the_user_should_see_the_following_options_on_user_status(List<String> expectedOptionsStatus) {
        // Write code here that turns the phrase above into concrete actions
        Select select=new Select(usersPage.userStatusDropDown);
        BrowserUtils.waitForClickability(usersPage.userStatusDropDown,2);
        List<WebElement> statusOptions= select.getOptions();
        List<String> statusOptionsText=new ArrayList<>();
        // option1:
        statusOptionsText= BrowserUtils.getElementsText(statusOptions);

        // option2:
        //for (WebElement each : statusOptions) { statusOptionsText.add(each.getText()); }

        // option3:
        //for (int i = 0; i <statusOptions.size() ; i++) { statusOptionsText.add(statusOptions.get(i).getText()); }

        System.out.println("============to see if expected options are the same as the actual options==================");
        System.out.println("statusOptionsText = " + statusOptionsText);
        System.out.println("expectedOptionsStatus = " + expectedOptionsStatus);

        Assert.assertEquals(expectedOptionsStatus,statusOptionsText);

    }

}
