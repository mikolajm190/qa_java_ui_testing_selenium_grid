package loaded;

import base.BaseTests;
import org.example.pages.loading.HiddenLoadingPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoadingHiddenElementTests extends BaseTests {

    @Test(groups = { "ui", "loading" })
    public void testHiddenLoadingElement() {
        // open hidden element page
        HiddenLoadingPage hiddenLoadingPage = mainPage.openLoadingPage()
                .openHiddenElementPage();

        // start loading element
        hiddenLoadingPage.clickStartLoadingButton();

        // get hidden element text
        assertEquals(
                "Hello World!",
                hiddenLoadingPage.getHiddenElementHeader(),
                "Invalid hidden element text."
        );
    }
}
