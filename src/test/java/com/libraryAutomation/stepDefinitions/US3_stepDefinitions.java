package com.libraryAutomation.stepDefinitions;

import com.libraryAutomation.pages.BasePage;
import com.libraryAutomation.pages.DashboardPage;
import com.libraryAutomation.pages.LoginPage;
import com.libraryAutomation.pages.StudentPage;
import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US3_stepDefinitions extends BasePage {

    LoginPage loginPage=new LoginPage();
    StudentPage studentPage=new StudentPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Given("user login as a student")
    public void user_login_as_a_student() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsStudent();
    }


    @Then("the student should be able to see books modules:")
    public void the_student_should_be_able_to_see_books_modules(List<String> expectedStudentModules) {
        // Write code here that turns the phrase above into concrete actions
        List<String> studentModulesText=new ArrayList<>();

        for (int i = 0; i <studentPage.studentModules.size(); i++) {
            studentModulesText.add(studentPage.studentModules.get(i).getText());
            Assert.assertEquals(studentPage.studentModules.get(i).getText(), expectedStudentModules.get(i));
        }

        System.out.println("studentModulesText = " + studentModulesText);
        System.out.println("expectedStudentModules = " + expectedStudentModules);



    }

    @Given("the user login as a librarian")
    public void the_user_login_as_a_librarian() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.login("librarian");
    }

    @Then("the user should be able to see dashboard modules:")
    public void the_user_should_be_able_to_see_dashboard_modules(List<String> expectedLibrarianModules) {
        // Write code here that turns the phrase above into concrete actions
        //List<String> actualLibrarianModulesText=new ArrayList<>();
        List<String> actualLibrarianModulesText=BrowserUtils.getElementsText(dashboardPage.librarianModules);
        //System.out.println("dashboardPage.librarianModules.size() = " + dashboardPage.librarianModules.size());
        /*
        for (int i = 0; i <dashboardPage.librarianModules.size() ; i++) {
            actualLibrarianModulesText.add(dashboardPage.librarianModules.get(i).getText());
            Assert.assertEquals(actualLibrarianModulesText.get(i), expectedLibrarianModules.get(i));
            System.out.println("actualLibrarianModulesText.get(i) = " + actualLibrarianModulesText.get(i));
            System.out.println("expectedLibrarianModules.get(i) = " + expectedLibrarianModules.get(i));
        }
         */

        Assert.assertEquals(actualLibrarianModulesText, expectedLibrarianModules);
        System.out.println("actualLibrarianModulesText = " + actualLibrarianModulesText);
        System.out.println("expectedLibrarianModules = " + expectedLibrarianModules);


    }


}
