package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class UserProfilePage extends BasePage {
    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    protected Header header;

    @FindBy(xpath = "//p[@data-test='profileEmail']")
    public WebElement profileEmailIcon;
    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement nameField;
    @FindBy(xpath = "//input[@placeholder='Surname']")
    public WebElement surnameField;
    @FindBy(xpath = "//select[@id='gender']")
    public WebElement genderField;
    @FindBy(xpath = "//input[@id='birthDate']")
    public WebElement birthdateField;
    @FindBy(xpath = "//input[@placeholder='+123456789012']")
    public WebElement phoneField;
    @FindBy(xpath = "//button[normalize-space()='Change password']")
    public WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    public WebElement editPlusButton;
    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    public WebElement editCancelElement;
    @FindBy(css = ".PasswordModal_passParagraph__feEN9")
    public WebElement passwordChangingPopUp;
    @FindBy(xpath = "//input[@placeholder='Old password']")
    public WebElement oldPasswordField;
    @FindBy(xpath = "//input[@placeholder='New password']")
    public WebElement newPasswordField;
    @FindBy(xpath = "//input[@placeholder='Confirm new password']")
    public WebElement confirmNewPasswordField;
    @FindBy(xpath = "//button[@class='PasswordModal_pass_btn__eGL9h']")
    public WebElement passwordChangingPopUpSaveButton;
    @FindBy(xpath = "//img[@alt='Uploaded']")
    public WebElement avatarOfTheUser;

    public String getCurrentGenderOption() {
        Select genderSelect = new Select(genderField);
        return genderSelect.getFirstSelectedOption().getText();
    }
    public void selectGenderOption (String gender) {
        Select genderSelect = new Select(genderField);
        genderSelect.selectByVisibleText(gender);
    }
    public String getAvatarSrc() {
        return avatarOfTheUser.getAttribute("src");
    }
    public void verifyProfileEmailIconIsDisplayed() {
        waitForVisibility(profileEmailIcon);
        assertElementIsDisplayed(profileEmailIcon);
    }
    public void clickOnYourProfileButton() {
        header.yourProfileButton.click();
    }
}
