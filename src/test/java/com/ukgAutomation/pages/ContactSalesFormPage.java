package com.ukgAutomation.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ContactSalesFormPage extends BasePage{
    HomePage homePage=new HomePage();
    Random random=new Random();

    @FindBy(xpath="//input[@id='edit-ukg-customer']")
    //@FindBy(id="input#edit-ukg-customer")
    public WebElement customerTickBox;

    @FindBy(xpath="//input[@id='edit-ukg-first-name']")
    public WebElement firstNameField;

    @FindBy(xpath="//input[@id='edit-ukg-last-name']")
    public WebElement lastNameField;

    @FindBy(xpath="//input[@id='edit-ukg-business-email']")
    public WebElement emailField;

    @FindBy(xpath="//input[@id='edit-ukg-business-phone']")
    public WebElement phoneField;

    @FindBy(xpath="//input[@id='edit-ukg-title']")
    public WebElement titleField;

    @FindBy(xpath="//input[@id='edit-ukg-company-name']")
    public WebElement companyNameField;

    @FindBy(xpath="//*[@id='edit-ukg-country']")
    public WebElement countryNameDropDown;

    @FindBy(xpath="//input[@id='edit-ukg-address-1']")
    public WebElement addressField;

    @FindBy(xpath="//input[@id='edit-ukg-city']")
    public WebElement cityField;

    @FindBy(xpath="//*[@id='edit-ukg-state']")
    public WebElement stateDropDown;

    @FindBy(xpath="//*[@id='edit-ukg-province']")
    public WebElement provinceDropDown;

    @FindBy(xpath="//input[@id='edit-ukg-zip-code']")
    public WebElement zipCodeField;

    @FindBy(xpath="//input[@id='edit-ukg-total-employees']")
    public WebElement totalEmployeesField;

    @FindBy(xpath="//*[@id='edit-ukg-timeframe']")
    public WebElement timeFrameDropDown;

    //comment
    @FindBy(xpath="//*[@id='edit-ukg-comments']")
    public WebElement commentsField;
    // project under my GitHub: https://github.com/ghalipm/UKG_Practice


    @FindBy(xpath="//*[@id='edit-actions-submit']")
    public WebElement submitButton;

    @FindBy(xpath="//h2[.='Thank You']")
    public WebElement thankYouHeader;



    // ticking the box:
    public void tickCustomerBox(){
        customerTickBox.click();
    }

    // placing comments:
    public void commenting(){
        commentsField.clear();
        commentsField.sendKeys("Hello from Ghalipm (ghalipm@gmail.com). I automated your webpage as an example. Check out my GitHub: https://github.com/ghalipm/UKG_Practice");
    }

    // submit the form:
    public void submitForm(){
        //submitButton.click(); // click did not work, but submit did the job!
        submitButton.submit();
    }

    // filling the form:
    public void fillingTheForm() throws InterruptedException {
        Select selectCountry = new Select(countryNameDropDown);
        Select selectState = new Select(stateDropDown);
        Select selectProvince = new Select(provinceDropDown);
        Select selectTimeFrame = new Select(timeFrameDropDown);

        Faker faker=new Faker();

        String firstName = faker.name().firstName();
        firstNameField.clear();
        firstNameField.sendKeys(firstName);

        String lastName = faker.name().lastName();

        lastNameField.clear();
        lastNameField.sendKeys(lastName);

        emailField.clear();
        emailField.sendKeys(faker.internet().emailAddress());

        phoneField.clear();
        phoneField.sendKeys(faker.phoneNumber().phoneNumber());

        titleField.clear();
        titleField.sendKeys(faker.job().title());

        companyNameField.clear();
        companyNameField.sendKeys(faker.company().name());

        int numberOfCountries=selectCountry.getOptions().size();
        //numberOfCountries = 247
        //any country in the list until the index reaches 40 to avoid US and Canada
        int countryIndex=random.nextInt(40);
        int canadaIndex=40+1;
        int usIndex=235-1;
        int countryIndex_between_US_Canada = (int)Math.floor(Math.random()*(usIndex-canadaIndex+1)+canadaIndex);
        //selectCountry.selectByIndex(countryIndex);
        selectCountry.selectByIndex(countryIndex_between_US_Canada);

        //selectCountry.selectByIndex(40); // Canada
        //selectCountry.selectByIndex(235); // US


        /*
        // Canada:
        selectCountry.selectByVisibleText("Canada");
        //int upperBoundCanada=14;
        int upperBoundCanada=selectProvince.getOptions().size();
        System.out.println("upperBoundCanada = " + upperBoundCanada);
        int provinceIndex=random.nextInt(upperBoundCanada);
        //selectProvince.selectByVisibleText("Alberta");
        selectProvince.selectByIndex(provinceIndex);
         */

        /*

        // US
        selectCountry.selectByVisibleText("United States of America");
        //selectState.getFirstSelectedOption(); // does not work well
        //selectState.selectByVisibleText("Alabama"); // works well
        int upperBoundUS=selectState.getOptions().size();
        System.out.println("upperBoundUS = " + upperBoundUS);
        int stateIndex=random.nextInt(upperBoundUS);
        //selectState.selectByIndex(2); // works well
        selectState.selectByIndex(stateIndex); // works well

         */


        addressField.clear();
        addressField.sendKeys(faker.address().streetAddress());

        cityField.clear();
        cityField.sendKeys(faker.address().city());

        zipCodeField.clear();
        zipCodeField.sendKeys(faker.address().zipCode());

        totalEmployeesField.sendKeys(faker.number().digit());

        selectTimeFrame.selectByIndex(3);

        commenting();
         //submit the form
         submitForm();

    }



}
