package com.libraryAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    @FindBy(xpath = "//a[@id='navbarDropdown']")
    private WebElement logoutDropDrown;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    private WebElement logoutButton;



    public void logout(){
        logoutDropDrown.click();
        logoutButton.click();
    }

}


