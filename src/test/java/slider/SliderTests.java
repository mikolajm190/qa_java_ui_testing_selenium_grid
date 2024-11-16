package slider;

import base.BaseTests;
import org.example.pages.SliderPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SliderTests extends BaseTests {

    @Test(groups = { "slider", "ui" })
    public void testSlider() {

        // open slider page
        SliderPage sliderPage = mainPage.openSliderPage();

        // move slider
        sliderPage.moveSliderNTimesRight(5);

        // verify slider value
        assertEquals(
                "2.5",
                sliderPage.getSliderValue(),
                "Incorrect slider value."
        );
    }
}
