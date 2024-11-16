package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends AbstractPage {

    @FindBy(id = "dropdown")
    WebElement dropdownMenu;

    public DropdownPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectDropdownOption(String val) {
        Select dropdown = new Select(dropdownMenu);
        dropdown.selectByValue(val);
    }

    public String getSelectedDropdownOption() {
        return new Select(dropdownMenu)
                .getFirstSelectedOption()
                .getText();
    }
}
