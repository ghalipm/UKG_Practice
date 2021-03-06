package com.libraryAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//a[@href='#users']")
    public WebElement usersModuleTab;

    @FindBy(xpath = "//span[@class='title']")
    public List<WebElement> librarianModules;


}
