package com.ukgAutomation.stepDefinitions;

import com.ukgAutomation.pages.HomePage;
import com.ukgAutomation.utilities.ConfigurationReader;
import com.ukgAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.replaceOnce;

public class Modulus_StepDefinition {

    HomePage homePage=new HomePage();

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("the user clicks on the Solution module")
    public void the_user_clicks_on_the_solution_module() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOn(homePage.solutionsTab);
    }

    @Then("the user should see the links:")
    public void the_user_should_see_the_links(List<String> expectedNamesList) {
        // Write code here that turns the phrase above into concrete actions

        // expectedNamesList is a list of Strings, but actualNamesList is not a list, but just a String!
        String actualNamesList=homePage.solutionsSubLinkAsOneWebElement.getText();

        System.out.println("actualNamesList = " + actualNamesList);
        System.out.println("expectedNamesList = " + expectedNamesList);

        for (int i = 0; i < expectedNamesList.size(); i++) {
            // asserts that everything in expectedList is inside the actualNamesList
            Assert.assertTrue("got difference!", actualNamesList.contains(expectedNamesList.get(i)));
           // remove everything in expectedList from the actualNamesList once
            actualNamesList=replaceOnce(actualNamesList, expectedNamesList.get(i), "");

        }
        //actualNamesList might have white space only at best
        System.out.println("actualNamesList size = " + actualNamesList.trim().length());
        // text content of actualNamesList and expectedNamesList is the same.
        Assert.assertTrue("no more chars in actual text", actualNamesList.trim().length()==0);
        //System.out.println("actualNamesList = " + actualNamesList);

    }

    @When("the user clicks on the whyUKG module")
    public void the_user_clicks_on_the_why_ukg_module() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePage.whyUKGTab.click();

    }

    @Then("the user should see the {string} header")
    public void the_user_should_see_the_header(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("homePage.whyUKGHeader.getText().equals(string) = " + homePage.whyUKGHeader.getText().equals(string));
        Assert.assertTrue(homePage.whyUKGHeader.getText().equals(string));

    }

    @When("the user clicks on the Customers modulus")
    public void the_user_clicks_on_the_customers_modulus() {
        // Write code here that turns the phrase above into concrete actions
        homePage.customersTab.click();
    }

    @Then("the user should see the UKG Customers header")
    public void the_user_should_see_the_ukg_customers_header() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(homePage.customersHeader.getText().equals("UKG Customers"));
    }


    @When("the user clicks on the Partners modulus")
    public void the_user_clicks_on_the_partners_modulus() {
        // Write code here that turns the phrase above into concrete actions
       homePage.partnersTab.click();
    }

    @Then("the user should see the partner's list:")
    public void the_user_should_see_the_partner_s_list(List<String> expectedPartnersList) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("expectedPartnersList = " + expectedPartnersList);
        //System.out.println("homePage.partnersName = " + homePage.partnersName.getText());

        String actualPartnersNames=homePage.partnersName.getText();
        System.out.println("actualPartnersNames = " + actualPartnersNames);

        for (int i = 0; i < expectedPartnersList.size(); i++) {
            // asserts that everything in expectedList is inside the actualNamesList
            Assert.assertTrue("got difference!", actualPartnersNames.contains(expectedPartnersList.get(i)));
            // remove everything in expectedList from the actualNamesList once
            actualPartnersNames=replaceOnce(actualPartnersNames, expectedPartnersList.get(i), "");

        }

        System.out.println("===================after removing the elements from the list====");

        //actualNamesList might have white space only at best
        System.out.println("actualPartnersNames size = " + actualPartnersNames.trim().length());
        // text content of actualNamesList and expectedNamesList is the same.
        Assert.assertTrue("more chars in actual text", actualPartnersNames.trim().length()==0);
        //System.out.println("actualNamesList = " + actualPartnersNames);

    }


    @When("the user clicks on the about us modulus")
    public void the_user_clicks_on_the_about_us_modulus() {
        // Write code here that turns the phrase above into concrete actions
       homePage.aboutUsTab.click();
    }

    @Then("the user should see the gartner logo")
    public void the_user_should_see_the_gartner_logo() {
        // the logo is displayed
        Assert.assertTrue(homePage.aboutUsLogo.isDisplayed());
    }


    @When("the user clicks on the contact modulus")
    public void the_user_clicks_on_the_contact_modulus() {
        // Write code here that turns the phrase above into concrete actions
        homePage.contactTab.click();
    }

    @Then("the user should see the Contact UKG header")
    public void the_user_should_see_the_contact_ukg_header() {
        // Write code here that turns the phrase above into concrete actions
        String expected="Contact UKG";
        System.out.println("homePage.contactHeader.getText() = " + homePage.contactHeader.getText());
        Assert.assertTrue(homePage.contactHeader.getText().equals(expected));
    }




}
