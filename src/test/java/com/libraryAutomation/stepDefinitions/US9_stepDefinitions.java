package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class US9_stepDefinitions {
    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();


    @When("the user click user group dropdown")
    public void the_user_click_user_group_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        usersPage.userGroupDropdown.click();

    }

    @Then("the user should see the following user group dropdown options")
    public void the_user_should_see_the_following_user_group_dropdown_options(List<String> expectedUserGroupDropdownOptions) {
        // Write code here that turns the phrase above into concrete actions
        // whenever there is a dropdown option, one must use Select
        Select select=new Select(usersPage.userGroupDropdown);
        List<WebElement> userGroupDropdownWE=select.getOptions();

        /*
        //option1:
        List<String> actualUserGroupDropdownText= BrowserUtils.getElementsText(userGroupDropdownWE);
         */

        //option2:
        List<String> actualUserGroupDropdownText=new ArrayList<>();
        for (WebElement each : userGroupDropdownWE ) {
            actualUserGroupDropdownText.add(each.getText());
        }

        System.out.println("actualUserGroupDropdownText = " + actualUserGroupDropdownText);
        System.out.println("expectedUserGroupDropdownOptions = " + expectedUserGroupDropdownOptions);
        Assert.assertEquals(expectedUserGroupDropdownOptions,actualUserGroupDropdownText);
    }


}
