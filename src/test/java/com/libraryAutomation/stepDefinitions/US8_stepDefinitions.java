package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BooksPage;
import com.libraryAutomation.pages.BorrowingBooksPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US8_stepDefinitions {
    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();
    BooksPage booksPage=new BooksPage();
    BorrowingBooksPage borrowingBooksPage=new BorrowingBooksPage();

    @Given("the user student is on the homepage")
    public void the_user_student_is_on_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.login("student");
    }

    @When("the user click Borrowing Books module")
    public void the_user_click_borrowing_books_module() {
        // Write code here that turns the phrase above into concrete actions
        booksPage.borrowingBooksTab.click();
    }

    @Then("the user should see the following column names")
    public void the_user_should_see_the_following_column_names(List<String> expectedColumnNames) {
        //List<WebElement> actualColumnNamesWE= (List<WebElement>) borrowingBooksPage.borrowedBooksColumnNames;

        List<String> actualColumnNamesText= BrowserUtils.getElementsText((List<WebElement>) borrowingBooksPage.borrowedBooksColumnNames);

        System.out.println("actualColumnNamesText = " + actualColumnNamesText);
        System.out.println("expectedColumnNames = " + expectedColumnNames);

    }


}
