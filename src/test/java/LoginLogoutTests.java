import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Header;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.*;
import static pageObjects.BasePage.wait;

public class LoginLogoutTests extends BaseTestUser {
    private Header header;
    private LoginPage loginPage;


    @Test
    public void testLoginWithValidData() {
        loginWithValidDataUser();
        header = new Header(driver);
        header.verifyChattyLogoIsDisplayed();
    }

    @Test
    public void testLoginWithEmptyEmailField() {
        loginPage = new LoginPage(driver);
        loginPage.inputPassword("Qwerty12345");
        assertFalse(loginPage.loginButton.isEnabled());
    }

    @Test
    void testLoginWithEmptyPasswordField() {
        loginPage = new LoginPage(driver);
        loginPage.inputEmail("tatsenko.tetiana@gmail.com");
        loginPage.submitForm();
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test
    public void testLoginWithEmptyAllFields() {
        loginPage = new LoginPage(driver);
        assertFalse(loginPage.loginButton.isEnabled());
    }

    @Test
    public void passwordFieldIsMasked() {
        loginPage = new LoginPage(driver);
        loginPage.verifyPasswordEyeCloseIsDisplayed();
        loginPage.inputPassword("Qwerty12345");
        loginPage.verifyPasswordEyeCloseIsDisplayed();
    }

    @Test
    public void passwordFieldIsUnMasked() {
        loginPage = new LoginPage(driver);
        loginPage.verifyPasswordEyeCloseIsDisplayed();
        loginPage.inputPassword("Qwerty12345");
        loginPage.passwordEyeClose.click();
        loginPage.verifyPasswordEyeOpenIsDisplayed();
    }

    @Test
    public void testSuccessfulLogout() {
        loginWithValidDataUser();
        header = new Header(driver);
        header.verifyChattyLogoIsDisplayed();
        header.helloUsernameTab.isDisplayed();
        header.logout();
    }

    @Test
    public void testLoginWithValidDataMultipleTimes() {
        for (int i = 0; i < 3; i++) {
            loginWithValidDataUser();
            header = new Header(driver);
            header.verifyChattyLogoIsDisplayed();
            header.logout();
        }
    }
}