package com.libraryAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
