package org.example.pages.login;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFormPage extends AbstractPage {

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(tagName = "button")
    WebElement submitButton;

    @FindBy(id = "flash")
    WebElement logoutConfirmationPopup;

    public LoginFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setUsernameInput(final String USERNAME) {
        usernameInput.sendKeys(USERNAME);
    }

    public void setPasswordInput(final String PASSWORD) {
        passwordInput.sendKeys(PASSWORD);
    }

    public SecurePage clickLoginButton() {
        submitButton.click();
        return new SecurePage(driver);
    }

    public String getLogoutConfirmationMessage() {
        return logoutConfirmationPopup.getText();
    }
}
