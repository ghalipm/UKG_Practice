package com.libraryAutomation.pages;

import com.github.javafaker.Faker;
import com.libraryAutomation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UsersPage extends com.libraryAutomation.pages.BasePage {


    @FindBy(xpath = "//span[.='Users']" )
         public WebElement usersLink;

    @FindBy(tagName = "th")
    public List<WebElement> tableHeaders;

    @FindBy(id = "user_status")
    public WebElement statusDropDown;

    Faker faker = new Faker();

    @FindBy(xpath = "//a[@href='#users']")
    private WebElement usersPageLink;

    @FindBy(xpath = "//a[@href='tpl/add-user.html']")
    private WebElement addUserLink;

    @FindBy(xpath = "//input[@name='full_name']")
    private WebElement fullNameBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailBox;

    @FindBy(xpath = "//input[@name='start_date']")
    private WebElement startDateBox;

    @FindBy(xpath = "//input[@name='end_date']")
    private WebElement endDateBox;

    @FindBy(xpath = "//select[@id='user_group_id']")
    private WebElement userGroupDropDown;

    @FindBy(id = "status")
    private WebElement statusDropDownOmer;

    @FindBy(id = "address")
    private WebElement addressBox;

    @FindBy(xpath = "//button[.='Save changes']")
    private WebElement saveChangesButton;

    @FindBy(xpath = "(//h5)[1]")
    public WebElement editUserInfoTitle;

    @FindBy(xpath = "//button[.='Close']")
    public WebElement closeButton;

    @FindBy(xpath = "(//table//td[1])[1]")
    public WebElement editFirstUser;

    @FindBy(xpath = "//h3")
    public WebElement userManagementTitle;

    private String name = faker.name().fullName();

    public void navigateToUsersPage (){
        usersPageLink.click();
    }

    public void addUser(){

        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusYears(2);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        addUserLink.click();
        Select selectUserGroup = new Select(userGroupDropDown);
        Select selectStatus = new Select(statusDropDownOmer);
        BrowserUtils.waitForVisibility(fullNameBox, 5);
        fullNameBox.sendKeys(name);
        passwordBox.sendKeys(faker.internet().password());
        emailBox.sendKeys(faker.internet().emailAddress());
        selectUserGroup.selectByVisibleText("Students");
        selectStatus.selectByVisibleText("ACTIVE");
        endDateBox.sendKeys(futureDate.format(df));
        addressBox.sendKeys(faker.address().fullAddress());
        saveChangesButton.click();
    }

    /*
    @FindBy(xpath = "//select[@id='user_groups']")
    public WebElement UserGroupDropdown;
     */

    @FindBy(id = "user_groups")
    public WebElement userGroupDropdown;

}
