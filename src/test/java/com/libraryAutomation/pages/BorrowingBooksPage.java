package com.libraryAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BorrowingBooksPage extends BasePage{

    @FindBy(xpath = "//th")
    public WebElement borrowedBooksColumnNames;

}
