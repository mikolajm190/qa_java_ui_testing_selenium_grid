package org.example.pages.loading;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoadingPage extends AbstractPage {

    @FindBy(xpath = ".//a[contains(text(), 'Example 1')]")
    WebElement hiddenElementPageLink;

    public LoadingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HiddenLoadingPage openHiddenElementPage() {
        hiddenElementPageLink.click();
        return new HiddenLoadingPage(driver);
    }
}
