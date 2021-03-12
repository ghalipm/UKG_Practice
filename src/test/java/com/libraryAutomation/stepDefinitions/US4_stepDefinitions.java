package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.pages.DashboardPage;
import com.libraryAutomation.pages.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US4_stepDefinitions extends BasePage {

    UsersPage usersPage=new UsersPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Then("user can add users with all valid info")
    public void user_can_add_users_with_all_valid_info()  {
        // Write code here that turns the phrase above into concrete actions
        usersPage.addUser();
        usersPage.saveChanges();
        /*
        BrowserUtils.waitForClickability(usersPage.dashBoardInUserTab, 2);
        usersPage.dashBoardInUserTab.click();
        int afterNum=dashboardPage.getUserNumbers();
        Assert.assertTrue(afterNum>beforeNum);

         */
    }

    @Then("user able to close the add user window with {string} button")
    public void user_able_to_close_the_add_user_window_with_button(String string)  {
        // Write code here that turns the phrase above into concrete actions
        usersPage.addUser();
        //usersPage.closeButton.click();
        usersPage.closeAddUser(); // this option also works the same way.

    }

    @Then("Librarians able to edit user info")
    public void librarians_able_to_edit_user_info() {
        // Write code here that turns the phrase above into concrete actions
        List<String> keyBefore=usersPage.getUserKey();
        String nonKeyBefore=usersPage.getUserUpdatableInfo();
        System.out.println("keyBefore = " + keyBefore);
        System.out.println("nonKeyBefore = " + nonKeyBefore);

        // info collected, now click to "Edit User" - open inside the method, then changes and saves.
        usersPage.editUserStatusUpdate();
        //wait until Alerts disappear and user rows become available.
        // IF IT IS 1 SECOND IT COULD FAIL: STALE EXCEPTION, IT HAS TO BE 2 OR MORE
        BrowserUtils.waitForClickability(usersPage.editFifthRowUser, 5);

        List<String> keyAfter=usersPage.getUserKey();
        System.out.println("keyAfter = " + keyAfter);

        //String nonKeyAfter=usersPage.getUserUpdatableInfo();
        BrowserUtils.waitForPageToLoad(5);
        //Driver.getDriver().navigate().refresh();
        String nonKeyAfter=usersPage.fifthRowUserInfo.get(4).getText();
        System.out.println("nonKeyAfter = " + nonKeyAfter);
        Assert.assertEquals(keyBefore,keyAfter);
        Assert.assertNotEquals(nonKeyBefore,nonKeyAfter);

    }


}
