import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Header;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.*;
import static pageObjects.BasePage.wait;

public class LoginLogoutTests extends BaseTest {
    private Header header;
    private LoginPage loginPage;


        @Test
        public void testLoginWithValidData() {
            loginWithValidData();
            header = new Header(driver);
            header.verifyChattyLogoIsDisplayed();
        }

        @Test // возможно бага в требованиях?
        public void testLoginWithEmptyEmailField() {
            loginPage.inputPassword("Qwerty12345");
            assertFalse(loginPage.loginButton.isEnabled());
    }
    // public void emptyUsernameField() {
    //        loginPage.enterUsername("");
    //        loginPage.enterPassword("Qwerty12345");
    //        loginPage.clickOnLoginButton();
    //        loginPage.getErrorMessage().shouldBe(visible).shouldHave(text("Invalid email or password. Please try again."));
    //    }

        @Test
        public void testLoginWithEmptyPasswordField() {
            loginPage.inputEmail("tatsenko.tetiana@gmail.com");
            loginPage.submitForm();
            wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
            assertTrue(loginPage.errorMessage.isDisplayed());
    }

        @Test // возможно бага в реализации?
        public void testLoginWithEmptyAllFields() {
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
            loginWithValidData();
            header = new Header(driver);
            header.verifyChattyLogoIsDisplayed();
            header.helloUsernameTab.isDisplayed();
            header.logout();
    }

        @Test
        public void testLoginWithValidDataMultipleTimes() {
            for (int i = 0; i < 3; i++) {
                loginWithValidData();
                header = new Header(driver);
                header.verifyChattyLogoIsDisplayed();
                header.logout();
        }
    }
//    public void testLoginWithValidDataMultipleTimes() {
//        // Первая попытка входа и выхода
//        header = loginPage.loginWithValidData("tatsenko.tetiana@gmail.com", "Qwerty12345");
//        wait.until(ExpectedConditions.visibilityOf(header.chattyLogo));
//        assertTrue(header.chattyLogo.isDisplayed());
//        header.logout();
//
//        // Вторая попытка входа и выхода
//        header = loginPage.loginWithValidData("tatsenko.tetiana@gmail.com", "Qwerty12345");
//        wait.until(ExpectedConditions.visibilityOf(header.chattyLogo));
//        assertTrue(header.chattyLogo.isDisplayed());
//        header.logout();
//
//        // Третья попытка входа
//        header = loginPage.loginWithValidData("tatsenko.tetiana@gmail.com", "Qwerty12345");
//        wait.until(ExpectedConditions.visibilityOf(header.chattyLogo));
//        assertTrue(header.chattyLogo.isDisplayed());
//    }


}