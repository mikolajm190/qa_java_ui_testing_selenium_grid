package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends AbstractPage {

    @FindBy(tagName = "input")
    WebElement slider;

    @FindBy(id = "range")
    WebElement sliderValue;

    public SliderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void moveSliderNTimesRight(int n) {
        for (int i = 0; i < n; i++) {
            slider.sendKeys(Keys.RIGHT);
        }
    }

    public String getSliderValue() {
        return sliderValue.getText();
    }
}
