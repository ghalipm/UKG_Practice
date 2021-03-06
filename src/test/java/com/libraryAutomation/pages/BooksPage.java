package com.libraryAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BooksPage extends BasePage {
    @FindBy(xpath = "//a[@href='#books']")
    public WebElement booksLink;

    @FindBy(id = "book_categories")
    public WebElement booksCategoryDropDown;

    @FindBy(xpath = "//table//tbody//tr")
    public WebElement tableBooks;

    @FindBy(xpath = "//table//tbody//tr//td[5]")
    public WebElement categoryInBooksTable;

    @FindBy(xpath = "//a[@href='#borrowing-books']")
    public WebElement borrowingBooksTab;

    @FindBy(xpath = "//th")
    // here it is about elements on a row -- column names,
    // so if you miss "List", it is a big problem.
    // Do not use "public WebElement"!
    public List<WebElement> booksColumnNames;

}
