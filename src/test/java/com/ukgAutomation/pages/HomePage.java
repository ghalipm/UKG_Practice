package com.ukgAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath="(//a[@aria-expanded='false'])[1]")
    public WebElement solutionsTab;

    @FindBy(xpath="(//a[.='Why UKG'])[2]")
    public WebElement whyUKGTab;

    @FindBy(xpath="(//a[.='Customers'])[2]")
    public WebElement customersTab;

    @FindBy(xpath="//h1")
    public WebElement customersHeader;

    @FindBy(xpath="(//a[.='Partners'])[2]")
    public WebElement partnersTab;

    @FindBy(xpath="/html/body/div[2]/div[3]/div/div[1]/div[2]/nav/ul/li[4]/div")
    public WebElement partnersName;

    @FindBy(xpath="(//a[.='About Us'])[2]")
    public WebElement aboutUsTab;

    @FindBy(xpath="(//img[@class='gartner-logo'])[2]")
    public WebElement aboutUsLogo;

    @FindBy(xpath="(//a[@href='/contact'])[1]")
    public WebElement contactTab;

    @FindBy(xpath="//h1")
    public WebElement contactHeader;



    @FindBy(xpath="(//a[@aria-expanded='false'])[1]")
    public WebElement solutionsNameList;

    /*
    @FindBy(xpath="(//ul[@class='uk-width-1-3 uk-nav uk-navbar-dropdown-nav ukg-navbar-dropdown-container'])[1]")
    public List<WebElement> solutionsDropDownList; // not a list of WebElements, but a WebElement!
     */
    @FindBy(xpath="(//ul[@class='uk-width-1-3 uk-nav uk-navbar-dropdown-nav ukg-navbar-dropdown-container'])[1]")
    public WebElement solutionsSubLinkAsOneWebElement;

    @FindBy(xpath="//h1")
    public WebElement whyUKGHeader;

    public void clickOn(WebElement webElement){
        webElement.click();
    }

}
