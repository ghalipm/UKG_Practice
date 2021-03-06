package com.libraryAutomation.pages;


import com.libraryAutomation.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

@FindBy(id="inputEmail")
    private WebElement usernameBox;

@FindBy(id="inputPassword")
    private WebElement passwordBox;


@FindBy(xpath = "//button")
    private WebElement signInButton;


public void loginAsStudent (){
    usernameBox.sendKeys(ConfigurationReader.getProperty("S142username"));
    passwordBox.sendKeys(ConfigurationReader.getProperty("S142password"));
    signInButton.click();
}

public void login (String role){

    if(role.equalsIgnoreCase("student")){
        usernameBox.sendKeys(ConfigurationReader.getProperty("S142username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("S142password"));
        signInButton.click();
    }else if(role.equalsIgnoreCase("librarian")){
        usernameBox.sendKeys(ConfigurationReader.getProperty("Lusername"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("Lpassword"));
        signInButton.click();
    }else{
        System.out.println("Invalid username or password");
    }
}


public WebElement getUsernameBox(){
    return usernameBox;
}


}
