package org.example.pages.login;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends AbstractPage {

    @FindBy(id = "flash")
    WebElement loginConfirmationPopUp;

    @FindBy(className = "button")
    WebElement logoutButton;

    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLoginConfirmationMessage() {
        return loginConfirmationPopUp.getText();
    }

    public LoginFormPage clickLogoutButton() {
        logoutButton.click();
        return new LoginFormPage(driver);
    }
}
