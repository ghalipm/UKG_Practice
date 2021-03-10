package com.libraryAutomation.pages;

import com.github.javafaker.Faker;
import com.libraryAutomation.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UsersPage extends BasePage {
    DashboardPage dashboardPage=new DashboardPage();


    @FindBy(xpath = "//span[.='Users']" )
         public WebElement usersLink;

    @FindBy(tagName = "th")
    public List<WebElement> tableHeaders;

    @FindBy(id = "user_status")
    public WebElement userStatusDropDown;

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement recordsDropDown;

    Faker faker = new Faker();

    @FindBy(xpath = "//a[@href='#users']")
    private WebElement usersPageLink;

    //@FindBy(xpath = "//a[@href='tpl/add-user.html']")
    @FindBy(xpath = "//*[.=' Add User']")
    private WebElement addUserLink;

    @FindBy(xpath = "//input[@name='full_name']")
    private WebElement fullNameBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='start_date']")
    private WebElement startDateBox;

    @FindBy(xpath = "//input[@name='end_date']")
    private WebElement endDateBox;

    @FindBy(xpath = "//select[@id='user_group_id']")
    private WebElement userGroupDropDown;

    @FindBy(id = "status")
    private WebElement statusDropDown;

    @FindBy(id = "address")
    private WebElement addressBox;

    @FindBy(xpath = "//button[.='Save changes']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "(//a[.=' Edit User'])[5]")
    public WebElement editFifthRowUser;

    @FindBy(xpath = "//button[.='Close']")
    public WebElement closeButton;

    @FindBy(xpath = "(//tr)[6]/td" )
    public List<WebElement> fifthRowUserInfo;

    @FindBy(xpath = "//h3")
    public WebElement userManagementTitle;

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashBoardInUserTab;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement editUserInfoTable;


    private String name = faker.name().fullName();

    public void navigateToUsersPage (){
        usersPageLink.click();
    }

    public void addUser(){

        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusYears(2);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BrowserUtils.waitForClickability(addUserLink,5);
        addUserLink.click();
        Select selectUserGroup = new Select(userGroupDropDown);
        Select selectStatus = new Select(statusDropDown);
        BrowserUtils.waitForClickability(fullNameBox, 2);
        fullNameBox.sendKeys(name);
        passwordBox.sendKeys(faker.internet().password());
        emailBox.sendKeys(faker.internet().emailAddress());
        BrowserUtils.waitForClickability(statusDropDown,1);
        selectUserGroup.selectByVisibleText("Students");
        BrowserUtils.waitForClickability(userGroupDropDown,1);
        selectStatus.selectByVisibleText("INACTIVE");
        endDateBox.sendKeys(futureDate.format(df),Keys.ENTER);
        addressBox.sendKeys(faker.address().fullAddress());
    }

    public void saveChanges(){saveChangesButton.click();}

    public void closeAddUser(){
        closeButton.click();
    }


    public List<String>  getUserKey(){

        String user_ID=fifthRowUserInfo.get(1).getText();
        String user_FullName=fifthRowUserInfo.get(2).getText();

        List<String> userKey=new ArrayList<>();
        userKey.add(user_ID);
        userKey.add(user_FullName);
        //System.out.println("userKey = " + userKey);

        return userKey;
    }

    public String getUserUpdatableInfo(){
        return fifthRowUserInfo.get(4).getText();
    }

    public void editUserStatusUpdate(){
        String userStatusOld=fifthRowUserInfo.get(4).getText();
        //System.out.println("userStatusOld = " + userStatusOld);
        BrowserUtils.waitForClickability(editFifthRowUser,5);
        editFifthRowUser.click();
        Select selectUserGroup = new Select(userGroupDropDown);

        if(userStatusOld.equals("Students")) {
            selectUserGroup.selectByIndex(0);
        }
        if(userStatusOld.equals("Librarian"))
        {selectUserGroup.selectByIndex(1);}
        BrowserUtils.waitForClickability(userGroupDropDown,1);

        //BrowserUtils.sleep(1);
        saveChanges();
    }




    /*
    @FindBy(xpath = "//select[@id='user_groups']")
    public WebElement UserGroupDropdown;
     */

    @FindBy(id = "user_groups")
    public WebElement userGroupDropdown;


    public WebElement getAddUserLink(){
        return addUserLink;
    }

}
