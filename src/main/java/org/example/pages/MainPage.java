package org.example.pages;

import org.example.pages.loading.LoadingPage;
import org.example.pages.login.LoginFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    @FindBy(linkText = "Form Authentication")
    WebElement formAuthLink;

    @FindBy(linkText = "Horizontal Slider")
    WebElement sliderLink;

    @FindBy(linkText = "Dropdown")
    WebElement dropdownLink;

    @FindBy(linkText = "Dynamic Loading")
    WebElement dynamicContentLink;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SliderPage openSliderPage() {
        sliderLink.click();
        return new SliderPage(driver);
    }

    public LoginFormPage openLoginFormPage() {
        formAuthLink.click();
        return new LoginFormPage(driver);
    }

    public DropdownPage openDropdownPage() {
        dropdownLink.click();
        return new DropdownPage(driver);
    }

    public LoadingPage openLoadingPage() {
        dynamicContentLink.click();
        return new LoadingPage(driver);
    }
}
