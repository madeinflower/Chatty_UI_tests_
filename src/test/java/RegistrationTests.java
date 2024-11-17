import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class RegistrationTests extends BaseTestUser {

    private RegistrationPage registrationPage;
    private Header header;


    @BeforeEach
    public void setUpTest() {
        registrationPage = new RegistrationPage(driver);
        header = new Header(driver);
    }


    @Test
        public void successRegistrationOfTheUser() {
            loginPage.clickOnSignUpButton();
            wait.until(ExpectedConditions.visibilityOf(registrationPage.createAccountTitle));
            assertTrue(registrationPage.createAccountTitle.isDisplayed());

            String randomEmail = registrationPage.generateRandomEmail(3, 30);
            String randomPassword = registrationPage.generateRandomPassword(20);
            registrationPage.enterEmailField(randomEmail);
            registrationPage.enterPasswordField(randomPassword);
            registrationPage.enterConfirmPasswordField(randomPassword);
            registrationPage.clickOndropDownMenuUserAdmin();

            registrationPage.selectUserRole("User");

            registrationPage.clickOnRegistrationButton();
            header.verifyChattyLogoIsDisplayed();
    }

    @Test
    public void successRegistrationOfTheAdmin() {
        loginPage.clickOnSignUpButton();
        wait.until(ExpectedConditions.visibilityOf(registrationPage.createAccountTitle));
        assertTrue(registrationPage.createAccountTitle.isDisplayed());

        String randomEmail = registrationPage.generateRandomEmail(3, 30);
        String randomPassword = registrationPage.generateRandomPassword(20);
        registrationPage.enterEmailField(randomEmail);
        registrationPage.enterPasswordField(randomPassword);
        registrationPage.enterConfirmPasswordField(randomPassword);
        registrationPage.clickOndropDownMenuUserAdmin();

        registrationPage.selectUserRole("Admin");

        registrationPage.clickOnRegistrationButton();
        header.verifyChattyLogoIsDisplayed();
    }
}
