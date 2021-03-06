package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.pages.UsersPage;
import io.cucumber.java.en.Then;


public class US4_stepDefinitions extends BasePage {

    UsersPage usersPage=new UsersPage();

    @Then("user can add users with all valid info")
    public void user_can_add_users_with_all_valid_info()  {
        // Write code here that turns the phrase above into concrete actions
        usersPage.addUser();
        usersPage.saveChanges();
    }

    @Then("user able to close the add user window with {string} button")
    public void user_able_to_close_the_add_user_window_with_button(String string)  {
        // Write code here that turns the phrase above into concrete actions
        usersPage.addUser();
        //usersPage.closeButton.click();
        usersPage.closeAddUser(); // this option also works the same way.

    }


}
