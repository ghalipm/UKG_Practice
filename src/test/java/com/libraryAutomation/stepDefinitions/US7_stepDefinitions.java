package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BooksPage;
import com.libraryAutomation.pages.BorrowingBooksPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US7_stepDefinitions {
    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();
    BooksPage booksPage=new BooksPage();
    BorrowingBooksPage borrowingBooksPage=new BorrowingBooksPage();

/*
    @Given("user on login page")
    public void user_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @Given("user login as a {string}")
    public void user_login_as_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.login(string);
    }

 */

    @Then("user can search books with categories")
    public void user_can_search_books_with_categories(List<String> expectedBooksCategoryText) {
        // Write code here that turns the phrase above into concrete actions
        Select select=new Select(booksPage.booksCategoryDropDown);
        // if Select used twice in one method, it causes Stale or No such Element exception!
        List<WebElement> actualBooksCategoryWE=select.getOptions();

        List<String> actualBooksCategoryText=new ArrayList<>();
        for (int i = 0; i < actualBooksCategoryWE.size(); i++) {
            actualBooksCategoryText.add(actualBooksCategoryWE.get(i).getText());
            actualBooksCategoryWE.get(i).click();
        }

        Assert.assertEquals("Category did not show up in books table",actualBooksCategoryText, expectedBooksCategoryText);
        System.out.println("===============ActualBooksCategoryInTable===========");
        System.out.println("actualBooksCategoryText = " + actualBooksCategoryText);
        System.out.println("expectedBooksCategoryText = " + expectedBooksCategoryText);


    }


}
