package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class UserProfilePage extends BasePage {

    public WebElement avatarUploadInput;
    private Header header;
    private LoginPage loginPage;

    @FindBy(xpath = "//p[@data-test='profileEmail']")
    public WebElement profileEmailIcon;

    @FindBy(css = "input[placeholder='Name']")
    public WebElement nameField;

    @FindBy(css = "input[placeholder='Surname']")
    public WebElement surnameField;

    @FindBy(xpath = "//select[@id='gender']")
    public WebElement genderField;

    @FindBy(xpath = "//input[@id='birthDate']")
    public WebElement birthdateField;

    @FindBy(css = "input[placeholder='+123456789012']")
    public WebElement phoneField;

    @FindBy(css = "button[name='password']")
    public WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    public WebElement saveButton;

    @FindBy(css = "span[data-test='post-header__plus']")
    public WebElement editPlusButton;

    @FindBy(css = ".post-header__plus-box")
    public WebElement editCancelElement;

    @FindBy(css = ".PasswordModal_passParagraph__feEN9")
    public WebElement passwordChangingPopUp;

    @FindBy(css = "input[placeholder='Old password']")
    public WebElement oldPasswordField;

    @FindBy(css = "input[placeholder='New password']")
    public WebElement newPasswordField;

    @FindBy(css = "input[placeholder='Confirm new password']")
    public WebElement confirmNewPasswordField;

    @FindBy(css = ".PasswordModal_pass_btn__eGL9h")
    public WebElement passwordChangingPopUpSaveButton;

    @FindBy(css = "img[alt='Uploaded']")
    public WebElement avatarOfTheUser;

    public UserProfilePage(WebDriver driver) {
        super(driver);

    }

    public String getCurrentGenderOption() {
        Select genderSelect = new Select(genderField);  // Создаем объект Select для выпадающего списка
        return genderSelect.getFirstSelectedOption().getText();  // Возвращаем текст текущей выбранной опции
    }


    public void selectGenderOption(String gender) {
        Select genderSelect = new Select(genderField);  // Создаем объект Select для выпадающего списка
        genderSelect.selectByVisibleText(gender);  // Выбираем опцию по видимому тексту
    }

    public String getAvatarSrc() {
        return avatarOfTheUser.getAttribute("src");
    }

    public void verifyProfileEmailIconIsDisplayed() {
        waitForVisibility(profileEmailIcon);
        assertElementIsDisplayed(profileEmailIcon);
    }

}
