package com.libraryAutomation.stepDefinitions;


import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.pages.BooksPage;
import com.libraryAutomation.pages.DashboardPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Login_stepDefinitions  {
    LoginPage loginPage = new LoginPage();
    BooksPage books= new BooksPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Given("user on login page")
    public void user_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("user login as a {string}")
    public void user_login_as_a(String role) {
        loginPage.login(role);
    }
    @Then("user on {string}")
    public void user_on(String page) {
        if(page.equals("books")) {
            BrowserUtils.waitForVisibility(books.booksLink, 5);
        }
        else if (page.equals("dashboard")){
            BrowserUtils.waitForVisibility(dashboardPage.librarianModules.get(0), 5);
        }
        else{
            System.out.println("Invalid page name!");
        }
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(page));

    }

}
