package login;

import base.BaseTests;
import org.example.pages.login.LoginFormPage;
import org.example.pages.login.SecurePage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginFormTests extends BaseTests {

    @Test(groups = { "ui", "login" })
    public void testFormLogin() {

        // open login page
        LoginFormPage loginFormPage = mainPage.openLoginFormPage();

        // input username and password
        loginFormPage.setUsernameInput(System.getenv("TEST_USERNAME"));
        loginFormPage.setPasswordInput(System.getenv("TEST_PASSWORD"));

        // click login button
        SecurePage securePage = loginFormPage.clickLoginButton();

        // verify login confirmation message
        assertTrue(
                securePage.getLoginConfirmationMessage()
                        .contains("You logged into a secure area!"),
                "Invalid login confirmation message."
        );

        // click logout button
        loginFormPage = securePage.clickLogoutButton();

        // verify logout confirmation message
        assertTrue(
                loginFormPage.getLogoutConfirmationMessage()
                        .contains("You logged out of the secure area!"),
                "Invalid logout confirmation message."
        );

    }
}
