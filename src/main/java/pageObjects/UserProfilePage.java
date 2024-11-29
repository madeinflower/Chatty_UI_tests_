package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserProfilePage extends BasePage {

    protected Header header;
    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@data-test='profileEmail']")
    private WebElement profileEmailIcon;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@placeholder='Surname']")
    private WebElement surnameField;
    @FindBy(xpath = "//select[@id='gender']")
    private WebElement genderField;
    @FindBy(xpath = "//input[@id='birthDate']")
    private WebElement birthdateField;
    @FindBy(xpath = "//input[@placeholder='+123456789012']")
    private WebElement phoneField;
    @FindBy(xpath = "//button[normalize-space()='Change password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    private WebElement editPlusButton;
    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    private WebElement editCancelElement;
    @FindBy(css = ".PasswordModal_passParagraph__feEN9")
    private WebElement passwordChangingPopUp;
    @FindBy(xpath = "//input[@placeholder='Old password']")
    private WebElement oldPasswordField;
    @FindBy(xpath = "//input[@placeholder='New password']")
    private WebElement newPasswordField;
    @FindBy(xpath = "//input[@placeholder='Confirm new password']")
    private WebElement confirmNewPasswordField;
    @FindBy(xpath = "//button[@class='PasswordModal_pass_btn__eGL9h']")
    private WebElement passwordChangingPopUpSaveButton;
    @FindBy(xpath = "//img[@alt='Uploaded']")
    private WebElement avatarOfTheUser;

    public Header getHeader() {
        return header;
    }

    public WebElement getProfileEmailIcon() {
        return profileEmailIcon;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getSurnameField() {
        return surnameField;
    }

    public WebElement getGenderField() {
        return genderField;
    }

    public WebElement getBirthdateField() {
        return birthdateField;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getEditPlusButton() {
        return editPlusButton;
    }

    public WebElement getEditCancelElement() {
        return editCancelElement;
    }

    public WebElement getPasswordChangingPopUp() {
        return passwordChangingPopUp;
    }

    public WebElement getOldPasswordField() {
        return oldPasswordField;
    }

    public WebElement getNewPasswordField() {
        return newPasswordField;
    }

    public WebElement getConfirmNewPasswordField() {
        return confirmNewPasswordField;
    }

    public WebElement getPasswordChangingPopUpSaveButton() {
        return passwordChangingPopUpSaveButton;
    }

    public WebElement getAvatarOfTheUser() {
        return avatarOfTheUser;
    }

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
        header.getYourProfileButton().click();
    }
}
