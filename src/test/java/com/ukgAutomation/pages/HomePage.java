package com.ukgAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath="//span[.='Disagree and close']")
    public WebElement popUpDisagreeAndClose;

    @FindBy(xpath="//span[.='Solutions']")
    public WebElement solutionsTab;

    @FindBy(xpath="(//a[.='Why UKG'])[2]")
    public WebElement whyUKGTab;

    @FindBy(xpath="(//a[.='Customers'])[2]")
    public WebElement customersTab;

    @FindBy(xpath="//h1")
    public WebElement customersHeader;

    @FindBy(xpath="(//a[@aria-expanded='false'])[1]")
    public WebElement partnersTab;

    @FindBy(xpath="(//ul[@class='uk-width-1-3 uk-nav uk-navbar-dropdown-nav ukg-navbar-dropdown-container'])[1]")
    public WebElement partnersName;

    @FindBy(xpath="(//a[.='About Us'])[2]")
    public WebElement aboutUsTab;

    @FindBy(xpath="(//img[@class='gartner-logo'])[2]")
    public WebElement aboutUsLogo;

    @FindBy(xpath="(//a[@href='/contact'])[1]")
    public WebElement contactTab;

    @FindBy(xpath="//h1")
    public WebElement contactHeader;

    @FindBy(xpath="(//a[@href='/support'])[1]")
    public WebElement supportTab;

    @FindBy(xpath="//h1[.=' UKG Support ']")
    public WebElement supportHeader;

    @FindBy(xpath="(//a[.='Blogs'])[1]")
    public WebElement blogTab;

    @FindBy(xpath="(//h1[.=' UKG Blogs '])[1]")
    public WebElement blogHeader;

    @FindBy(xpath="(//a[.='Careers'])[1]")
    public WebElement careerTab;

    @FindBy(xpath="(//h2[.=' Search Jobs '])[1]")
    public WebElement careerHeader;


   // globe icon tab:
   @FindBy(xpath="//a[@class='coh-link uk-navbar-toggle icon-globe ukg-icon-primary']")
    public WebElement globTab;

   // text field of the globe icon
    @FindBy(xpath="//ul[@class='links uk-nav  uk-navbar-dropdown-nav']")
    public WebElement globIconWE;



    /*
    @FindBy(xpath="(//ul[@class='uk-width-1-3 uk-nav uk-navbar-dropdown-nav ukg-navbar-dropdown-container'])[1]")
    public List<WebElement> solutionsDropDownList; // not a list of WebElements, but a WebElement!
     */
    @FindBy(xpath="(//ul[@class='uk-width-1 uk-nav uk-navbar-dropdown-nav ukg-navbar-dropdown-container'])[2]")
    public WebElement solutionsSubLinkAsOneWebElement;

    @FindBy(xpath="(//ul[@class='uk-width-1 uk-nav uk-navbar-dropdown-nav ukg-navbar-dropdown-container'])[1]")
    public WebElement productSuiteAsOneWebElement;


    @FindBy(xpath="//h1")
    public WebElement whyUKGHeader;


    public void clickOn(WebElement webElement){
        webElement.click();
    }

}
