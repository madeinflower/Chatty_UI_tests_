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
        wait.until(ExpectedConditions.visibilityOf(header.getHelloUsernameTab()));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        userProfilePage.verifyProfileEmailIconIsDisplayed();
        userProfilePage.getEditPlusButton().click();
        userProfilePage.getNameField().clear();
        String randomName = getRandomName(15);
        userProfilePage.getNameField().sendKeys(randomName);
        userProfilePage.getSaveButton().click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getEditPlusButton()));
        assertTrue(userProfilePage.getEditPlusButton().isDisplayed());
    }

    @Test
    public void editSurnameUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.getHelloUsernameTab()));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        userProfilePage.verifyProfileEmailIconIsDisplayed();
        userProfilePage.getEditPlusButton().click();
        userProfilePage.getSurnameField().clear();
        String randomSurname = getRandomSurname(15);
        userProfilePage.getSurnameField().sendKeys(randomSurname);
        userProfilePage.getSaveButton().click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getEditPlusButton()));
        assertTrue(userProfilePage.getEditPlusButton().isDisplayed());
    }

    @Test
    public void changeGenderOption() {
        wait.until(ExpectedConditions.visibilityOf(header.getHelloUsernameTab()));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getProfileEmailIcon()));
        assertTrue(userProfilePage.getProfileEmailIcon().isDisplayed());
        userProfilePage.getEditPlusButton().click();
        String currentGender = userProfilePage.getCurrentGenderOption();
        if (currentGender.equals("FEMALE")) {
            userProfilePage.selectGenderOption("MALE");
        } else if (currentGender.equals("MALE")) {
            userProfilePage.selectGenderOption("FEMALE");
        }
        userProfilePage.getSaveButton().click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getEditCancelElement()));
        assertTrue(userProfilePage.getEditCancelElement().isDisplayed());
    }

    @Test
    @Disabled // баг в реализации
    public void changeBirthdayOption() {
        wait.until(ExpectedConditions.visibilityOf(header.getHelloUsernameTab()));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getProfileEmailIcon()));
        assertTrue(userProfilePage.getProfileEmailIcon().isDisplayed());
        userProfilePage.getEditPlusButton().click();
        userProfilePage.getBirthdateField().click();
        userProfilePage.getBirthdateField().sendKeys("test");
        userProfilePage.getBirthdateField().click();
        userProfilePage.getBirthdateField().sendKeys("12/03/2000");
        userProfilePage.getSaveButton().click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getEditCancelElement()));
        assertTrue(userProfilePage.getEditCancelElement().isDisplayed());
    }

    @Test
    public void editPhoneNumberUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.getHelloUsernameTab()));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        userProfilePage.verifyProfileEmailIconIsDisplayed();
        userProfilePage.getEditPlusButton().click();
        userProfilePage.getPhoneField().clear();
        String randomPhoneNumber = getRandomPhoneNumber();
        userProfilePage.getSurnameField().sendKeys(randomPhoneNumber);
        userProfilePage.getSaveButton().click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getEditPlusButton()));
        assertTrue(userProfilePage.getEditPlusButton().isDisplayed());
    }

    @Test
    // здесь как-то надо прописать, чтобы после каждого раза, как меняется пароль в этом тесте, новый пароль подтягивался в BaseTest
    public void editPasswordUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.getHelloUsernameTab()));
        header.hoverOverHelloUsernameTab();
        userProfilePage.clickOnYourProfileButton();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getProfileEmailIcon()));
        assertTrue(userProfilePage.getProfileEmailIcon().isDisplayed());
        userProfilePage.getEditPlusButton().click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getEditCancelElement()));
        userProfilePage.getPasswordField().click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getPasswordChangingPopUp()));
        assertTrue(userProfilePage.getPasswordChangingPopUp().isDisplayed());
        userProfilePage.getOldPasswordField().sendKeys("Qwerty1234");
        userProfilePage.getNewPasswordField().sendKeys("Qwerty12345");
        userProfilePage.getConfirmNewPasswordField().sendKeys("Qwerty12345");
        userProfilePage.getPasswordChangingPopUpSaveButton().click();
        userProfilePage.getSaveButton().click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.getEditCancelElement()));
        assertTrue(userProfilePage.getEditCancelElement().isDisplayed());
    }
}



