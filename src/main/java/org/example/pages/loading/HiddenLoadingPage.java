package org.example.pages.loading;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HiddenLoadingPage extends AbstractPage {

    @FindBy(tagName = "button")
    WebElement startLoadingButton;

    @FindBy(css = "#finish > h4")
    WebElement hiddenElementHeader;

    public HiddenLoadingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickStartLoadingButton() {
        startLoadingButton.click();
    }

    public String getHiddenElementHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(hiddenElementHeader));
        return hiddenElementHeader.getText();
    }
}
