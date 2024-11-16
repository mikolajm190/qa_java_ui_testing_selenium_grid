package dropdown;

import base.BaseTests;
import org.example.pages.DropdownPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {

    @Test(groups = { "ui", "dropdown" })
    public void testDropdown() {
        // open dropdown page
        DropdownPage dropdownPage = mainPage.openDropdownPage();

        // select dropdown option
        dropdownPage.selectDropdownOption("1");

        // verify that option is selected
        assertEquals(
                "Option 1",
                dropdownPage.getSelectedDropdownOption(),
                "Wrong option selected."
        );
    }
}
