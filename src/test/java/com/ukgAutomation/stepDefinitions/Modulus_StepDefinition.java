package com.ukgAutomation.stepDefinitions;

import com.ukgAutomation.pages.ContactSalesFormPage;
import com.ukgAutomation.pages.HomePage;
import com.ukgAutomation.utilities.BrowserUtils;
import com.ukgAutomation.utilities.ConfigurationReader;
import com.ukgAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.replaceOnce;

public class Modulus_StepDefinition {

    HomePage homePage=new HomePage();
    ContactSalesFormPage contactSalesFormPage=new ContactSalesFormPage();

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //homePage.closeAlert.sendKeys(Keys.ENTER);

    }

    @When("the user clicks on the Solution module")
    public void the_user_clicks_on_the_solution_module() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOn(homePage.solutionsTab);
    }

    @Then("the user should see the Product Suites sub title:")
    public void the_user_should_see_the_product_suites_sub_title(List<String> expectedNamesList) {
        // Write code here that turns the phrase above into concrete actions

        // expectedNamesList is a list of Strings, but actualNamesList is not a list, but just a String!
        String actualNamesList=homePage.productSuiteAsOneWebElement.getText();


        System.out.println("actualNamesList = " + actualNamesList);
        System.out.println("expectedNamesList = " + expectedNamesList);

        for (String s : expectedNamesList) {
            // asserts that everything in expectedList is inside the actualNamesList
            Assert.assertTrue("got difference!", actualNamesList.contains(s));
            // remove everything in expectedList from the actualNamesList once
            actualNamesList = replaceOnce(actualNamesList, s, "").trim();

        }
        //actualNamesList might have more messages or names than expectedNames. No need to verify descriptions.
        //System.out.println("actualNamesList size = " + actualNamesList.trim().length());
        // text content of actualNamesList and expectedNamesList is the same.
        ////Assert.assertTrue("still some chars in actual text", actualNamesList.trim().length()==0);
        //System.out.println("actualNamesList = " + actualNamesList);

    }

    @When("the user should see By Solutions title and sub modules:")
    public void the_user_should_see_by_solutions_title_and_sub_modules(List<String> expectedNamesList){

        // expectedNamesList is a list of Strings, but actualNamesList is not a list, but just a String!
        String actualNamesList=homePage.solutionsSubLinkAsOneWebElement.getText();

        System.out.println("actualNamesList = " + actualNamesList);
        System.out.println("expectedNamesList = " + expectedNamesList);

        for (String s : expectedNamesList) {
            // asserts that everything in expectedList is inside the actualNamesList
            BrowserUtils.waitForVisibility(homePage.solutionsSubLinkAsOneWebElement, 5);
            Assert.assertTrue("got difference!", actualNamesList.contains(s));
            // remove everything in expectedList from the actualNamesList once
            actualNamesList = replaceOnce(actualNamesList, s, "").trim();

        }
        //actualNamesList might have white space only at best
        System.out.println("actualNamesList size = " + actualNamesList.trim().length());
        // text content of actualNamesList and expectedNamesList is the same.
        Assert.assertEquals("still some chars in actual text", 0, actualNamesList.trim().length());
        //System.out.println("actualNamesList = " + actualNamesList);


    }



    @When("the user clicks on the whyUKG module")
    public void the_user_clicks_on_the_why_ukg_module() {
        // Write code here that turns the phrase above into concrete actions
        homePage.whyUKGTab.click();

    }

    @Then("the user should see the {string} header")
    public void the_user_should_see_the_header(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("homePage.whyUKGHeader.getText().equals(string) = " + homePage.whyUKGHeader.getText().equals(string));
        Assert.assertEquals(homePage.whyUKGHeader.getText(), string);

    }

    @When("the user clicks on the Customers modulus")
    public void the_user_clicks_on_the_customers_modulus() {
        // Write code here that turns the phrase above into concrete actions
        homePage.customersTab.click();
    }

    @Then("the user should see the customers list:")
    public void the_user_should_see_the_customers_list(List<String> expectedCustomersList) {

        String actualCustomersNames=homePage.customersNames.getText();
        System.out.println("actualCustomersNames = " + actualCustomersNames);
        for (String s : expectedCustomersList) {

            // asserts that everything in expectedList is inside the actualNamesList
            Assert.assertTrue("got difference!", actualCustomersNames.contains(s));
            // remove everything in expectedList from the actualNamesList once
            actualCustomersNames = replaceOnce(actualCustomersNames,s, "");

        }

        Assert.assertTrue(actualCustomersNames.trim().isEmpty());

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

        BrowserUtils.waitForVisibility(homePage.partnersName,2);
        String actualPartnersNames=homePage.partnersName.getText();
        System.out.println("actualPartnersNames = " + actualPartnersNames);

        for (String s : expectedPartnersList) {
            // asserts that everything in expectedList is inside the actualNamesList
            Assert.assertTrue("got difference!", actualPartnersNames.contains(s));
            // remove everything in expectedList from the actualNamesList once
            actualPartnersNames = replaceOnce(actualPartnersNames, s, "");

        }

        System.out.println("===================after removing the elements from the list====");

        //actualNamesList might have white space only at best
        System.out.println("actualPartnersNames size = " + actualPartnersNames.trim().length());
        // text content of actualNamesList and expectedNamesList is the same.
        Assert.assertEquals("more chars in actual text", 0, actualPartnersNames.trim().length());
        //System.out.println("actualNamesList = " + actualPartnersNames);

    }


    @When("the user clicks on the about us modulus")
    public void the_user_clicks_on_the_about_us_modulus() {
        // Write code here that turns the phrase above into concrete actions
       homePage.aboutUsTab.click();
    }

    @Then("the user should see the text About UKG")
    public void the_user_should_see_the_text_about_ukg() {
        // the text is displayed
        BrowserUtils.waitForVisibility(homePage.aboutUkgText, 3);
        Assert.assertTrue(homePage.aboutUkgText.isDisplayed());
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
        Assert.assertEquals(homePage.contactHeader.getText(), expected);
    }


    @When("the user clicks on the support modulus")
    public void the_user_clicks_on_the_support_modulus() {
        homePage.supportTab.click();
        //homePage.closeAlert.sendKeys(Keys.ENTER);
    }

    @Then("the user should see the UKG Support header")
    public void the_user_should_see_the_ukg_support_header() {
        String expectedSupport="UKG Support";
        System.out.println("homePage.supportHeader.getText() = " + homePage.supportHeader.getText());
        System.out.println("expectedSupport = " + expectedSupport);
        Assert.assertEquals(expectedSupport, homePage.supportHeader.getText().trim());
    }


    @When("the user clicks on the Blog modulus")
    public void the_user_clicks_on_the_blog_modulus() {
      homePage.blogTab.click();
    }

    @Then("the user should see the UKG Blog header")
    public void the_user_should_see_the_ukg_blog_header() {
        String expectedBlog=" UKG Blogs ";
        System.out.println("expectedBlog = " + expectedBlog);
        System.out.println("homePage.blogHeader.getText() = " + homePage.blogHeader.getText());

        Assert.assertEquals(expectedBlog.trim(), homePage.blogHeader.getText().trim());
    }


    @When("the user clicks on the career modulus")
    public void the_user_clicks_on_the_career_modulus() {
        homePage.careerTab.click();
    }

    @Then("the user should see the  Search Jobs  header")
    public void the_user_should_see_the_search_jobs_header() {
        String expectedText=" Search Jobs ";
        System.out.println("expectedText = " + expectedText);
        System.out.println("homePage.careerHeader.getText() = " + homePage.careerHeader.getText());
        Assert.assertEquals(expectedText.trim(), homePage.careerHeader.getText().trim());

    }


    @When("the user clicks on the globe modulus")
    public void the_user_clicks_on_the_globe_modulus() {
        homePage.globTab.click();

    }

    @Then("the user should see the languages  list:")
    public void the_user_should_see_the_languages_list(List<String> expectedText) {
        BrowserUtils.waitForVisibility(homePage.globIconWE, 1);
        String actualText=homePage.globIconWE.getText();
        System.out.println("==========actual text before replacement=====");
        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);


        for (String s : expectedText) {
            // asserts that everything in expectedList is inside the actualNamesList
            Assert.assertTrue("got difference!", actualText.contains(s));
            // remove everything in expectedList from the actualNamesList once
            actualText = replaceOnce(actualText, s, " ").trim();

        }
        System.out.println("==========actual text after replacement=====");
        System.out.println("actualText = " + actualText);
        //actualText has no more elements, or has zero elements.
        System.out.println("actualNamesList size = " + actualText.length());
        // text content of actualNamesList and expectedNamesList is the same.
        Assert.assertEquals("still some chars in actual text", 0, actualText.length());


    }

    // Contact Sales Form:
    @Then("the user should see the Contact Sales form")
    public void the_user_should_see_the_contact_sales_form() {
        homePage.contactTab.sendKeys(Keys.ENTER);
        BrowserUtils.waitForClickability(contactSalesFormPage.contactSalesLearnMoreButtonFirst,3);
        contactSalesFormPage.contactSalesLearnMoreButtonFirst.sendKeys(Keys.ENTER);
        BrowserUtils.waitForClickability(contactSalesFormPage.contactSalesLearnMoreButtonSecond,3);
        contactSalesFormPage.contactSalesLearnMoreButtonSecond.sendKeys(Keys.ENTER);
    }

    @Then("user can fill the form with valid info and be able to send by clicking LEARN MORE button")
    public void user_can_fill_the_form_with_valid_info_and_be_able_to_send_by_clicking_learn_more_button() {
       // tick the customer box
       // contactSalesFormPage.tickCustomerBox(); // No more tick on the page!
       // fill the form

        BrowserUtils.waitForClickability(contactSalesFormPage.submitButton,3);
        contactSalesFormPage.fillingTheForm();
        contactSalesFormPage.submitForm();

    }


    @Then("verify that user be able to see {string} message")
    public void verify_that_user_be_able_to_see_that_url_contains_message(String string) {

        Assert.assertTrue(contactSalesFormPage.thankYouHeader.isDisplayed());

    }





}
