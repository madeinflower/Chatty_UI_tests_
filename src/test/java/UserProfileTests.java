import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Header;
import pageObjects.UserProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class UserProfileTests extends BaseTestUser {

    private Header header;
    private UserProfilePage userProfilePage;


    @BeforeEach
    public void setUpTest() {
        loginWithValidDataUser();
        header = new Header(driver);
        userProfilePage = new UserProfilePage(driver);
    }

    @Test
    public void editNameUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        userProfilePage.verifyProfileEmailIconIsDisplayed();
        userProfilePage.editPlusButton.click();
        userProfilePage.nameField.clear();
        String randomName = generateRandomName(15);
        userProfilePage.nameField.sendKeys(randomName);
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editPlusButton));
        assertTrue(userProfilePage.editPlusButton.isDisplayed());
    }

    @Test
    public void editSurnameUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        userProfilePage.verifyProfileEmailIconIsDisplayed();
        userProfilePage.editPlusButton.click();
        userProfilePage.surnameField.clear();
        String randomSurname = generateRandomSurname(15);
        userProfilePage.surnameField.sendKeys(randomSurname);
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editPlusButton));
        assertTrue(userProfilePage.editPlusButton.isDisplayed());
    }

    @Test
    public void changeGenderOption() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileEmailIcon));
        assertTrue(userProfilePage.profileEmailIcon.isDisplayed());
        userProfilePage.editPlusButton.click();
        String currentGender = userProfilePage.getCurrentGenderOption();
        if (currentGender.equals("FEMALE")) {
            userProfilePage.selectGenderOption("MALE");
        } else if (currentGender.equals("MALE")) {
            userProfilePage.selectGenderOption("FEMALE");
        }
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        assertTrue(userProfilePage.editCancelElement.isDisplayed());
    }

    @Test
    @Disabled // баг в реализации
    public void changeBirthdayOption() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileEmailIcon));
        assertTrue(userProfilePage.profileEmailIcon.isDisplayed());
        userProfilePage.editPlusButton.click();
        userProfilePage.birthdateField.click();
        userProfilePage.birthdateField.sendKeys("test");
        userProfilePage.birthdateField.click();
        userProfilePage.birthdateField.sendKeys("12/03/2000");
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        assertTrue(userProfilePage.editCancelElement.isDisplayed());
    }

    @Test
    public void editPhoneNumberUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        userProfilePage.verifyProfileEmailIconIsDisplayed();
        userProfilePage.editPlusButton.click();
        userProfilePage.phoneField.clear();
        String randomPhoneNumber = generateRandomPhoneNumber();
        userProfilePage.surnameField.sendKeys(randomPhoneNumber);
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editPlusButton));
        assertTrue(userProfilePage.editPlusButton.isDisplayed());
    }

    @Test
    // здесь как-то надо прописать, чтобы после каждого раза, как меняется пароль в этом тесте, новый пароль подтягивался в BaseTest
    public void editPasswordUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileEmailIcon));
        assertTrue(userProfilePage.profileEmailIcon.isDisplayed());
        userProfilePage.editPlusButton.click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        userProfilePage.passwordField.click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.passwordChangingPopUp));
        assertTrue(userProfilePage.passwordChangingPopUp.isDisplayed());
        userProfilePage.oldPasswordField.sendKeys("Qwerty1234");
        userProfilePage.newPasswordField.sendKeys("Qwerty12345");
        userProfilePage.confirmNewPasswordField.sendKeys("Qwerty12345");
        userProfilePage.passwordChangingPopUpSaveButton.click();
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        assertTrue(userProfilePage.editCancelElement.isDisplayed());
    }
}



