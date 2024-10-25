import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Header;
import pageObjects.UserProfilePage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class UserProfileTests extends BaseTest {

    private Header header;
    private UserProfilePage userProfilePage;


    @BeforeEach
    public void setUpTest() {
        loginWithValidData();  // Вынесенный метод логина
        header = new Header(driver);  // Инициализация заголовка
        userProfilePage = new UserProfilePage(driver);
    }

    @Test
    public void editNameUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        header.yourProfileButton.click();
        userProfilePage.verifyProfileEmailIconIsDisplayed();
        header.hoverOverContactTab();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        userProfilePage.editPlusButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Cancel"));
        userProfilePage.nameField.clear();
        String randomName = generateRandomName(15);
        userProfilePage.nameField.sendKeys(randomName);
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Edit"));
        assertTrue(userProfilePage.editCancelElement.isDisplayed());
    }

    @Test
    public void editSurnameUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        header.yourProfileButton.click();
        userProfilePage = new UserProfilePage(driver);
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileEmailIcon));
        assertTrue(userProfilePage.profileEmailIcon.isDisplayed());
        header.hoverOverContactTab();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        userProfilePage.editPlusButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Cancel"));
        userProfilePage.surnameField.clear();
        String randomSurname = generateRandomSurname(15);
        userProfilePage.nameField.sendKeys(randomSurname);
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Edit"));
        assertTrue(userProfilePage.editCancelElement.isDisplayed());
    }

    @Test
    public void changeGenderOption() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        header.yourProfileButton.click();
        userProfilePage = new UserProfilePage(driver);
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileEmailIcon));
        assertTrue(userProfilePage.profileEmailIcon.isDisplayed());
        header.hoverOverContactTab();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        userProfilePage.editPlusButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Cancel"));
        // Получаем текущее значение пола
        String currentGender = userProfilePage.getCurrentGenderOption();
        // Меняем на противоположную опцию
        if (currentGender.equals("FEMALE")) {
            userProfilePage.selectGenderOption("MALE");
        } else if (currentGender.equals("MALE")) {
            userProfilePage.selectGenderOption("FEMALE");
        }
        // Сохраняем изменения
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Edit"));
        assertTrue(userProfilePage.editCancelElement.isDisplayed());
    }

    @Test
    @Disabled // баг в реализации
    public void changeBirthdayOption() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        header.yourProfileButton.click();
        userProfilePage = new UserProfilePage(driver);
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileEmailIcon));
        assertTrue(userProfilePage.profileEmailIcon.isDisplayed());
        header.hoverOverContactTab();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        userProfilePage.editPlusButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Cancel"));
        userProfilePage.birthdateField.click();
        userProfilePage.birthdateField.sendKeys("test");
        userProfilePage.birthdateField.click();
        userProfilePage.birthdateField.sendKeys("12/03/2000");
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Edit"));
        assertTrue(userProfilePage.editCancelElement.isDisplayed());
    }

    @Test
    public void editPhoneNumberUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        header.yourProfileButton.click();
        userProfilePage = new UserProfilePage(driver);
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileEmailIcon));
        assertTrue(userProfilePage.profileEmailIcon.isDisplayed());
        header.hoverOverContactTab();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        userProfilePage.editPlusButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Cancel"));
        userProfilePage.phoneField.clear();
        String randomPhoneNumber = generateRandomPhoneNumber();
        userProfilePage.phoneField.sendKeys(randomPhoneNumber);
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Edit"));
        assertTrue(userProfilePage.editCancelElement.isDisplayed());
    }

    @Test
    // здесь как-то надо прописать, чтобы после каждого раза, как меняется пароль в этом тесте, новый пароль подтягивался в BaseTest
    public void editPasswordUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.helloUsernameTab));
        header.hoverOverHelloUsernameTab();
        header.yourProfileButton.click();
        userProfilePage = new UserProfilePage(driver);
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileEmailIcon));
        assertTrue(userProfilePage.profileEmailIcon.isDisplayed());
        header.hoverOverContactTab();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.editCancelElement));
        userProfilePage.editPlusButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Cancel"));
        userProfilePage.passwordField.click();
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.passwordChangingPopUp));
        assertTrue(userProfilePage.passwordChangingPopUp.isDisplayed());
        userProfilePage.oldPasswordField.sendKeys("Qwerty12345");
        userProfilePage.newPasswordField.sendKeys("Qwerty1234");
        userProfilePage.confirmNewPasswordField.sendKeys("Qwerty1234");
        userProfilePage.passwordChangingPopUpSaveButton.click();
        userProfilePage.saveButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(userProfilePage.editCancelElement, "Edit"));
        assertTrue(userProfilePage.editCancelElement.isDisplayed());
    }

//    @Test
//    public void editAvatarUsingValidData() {
//
//    }


}



