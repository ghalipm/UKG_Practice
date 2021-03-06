package com.libraryAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudentPage extends BasePage{

    @FindBy(xpath="//span[@class='title']")
    public List<WebElement> studentModules;


}
