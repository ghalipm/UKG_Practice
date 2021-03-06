package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.pages.BooksPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;

public class US6_stepDefinitions extends BasePage {
    LoginPage loginPage = new LoginPage();
    BooksPage booksPage = new BooksPage();

    @Given("student login into library homepage")
    public void student_login_into_library_homepage() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsStudent();
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedBooksCategoryText) {
        // Write code here that turns the phrase above into concrete actions

        List<String> actualColumnNames = BrowserUtils.getElementsText(booksPage.booksColumnNames);
        Assert.assertEquals(actualColumnNames, expectedBooksCategoryText);
        System.out.println("actualColumnNames = " + actualColumnNames);
        System.out.println("expectedColumnNames = " + expectedBooksCategoryText);

    }

}



