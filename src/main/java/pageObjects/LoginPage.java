package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//form[@class='form']")
    private WebElement loginForm;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='text-error']")
    private WebElement errorMessage;
    @FindBy(xpath = "//img[@alt='close']")
    private WebElement passwordEyeClose;
    @FindBy(xpath = "//img[@alt='open']")
    private WebElement passwordEyeOpen;
    @FindBy(xpath = "//a[normalize-space()='Sign up']")
    private WebElement signUpButton;

    public WebElement getLoginForm() {
        return loginForm;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getPasswordEyeClose() {
        return passwordEyeClose;
    }

    public WebElement getPasswordEyeOpen() {
        return passwordEyeOpen;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public void inputEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }
    public void inputPassword(String newPassword) {
        inputPassword.clear();
        inputPassword.sendKeys(newPassword);
    }
    public void submitForm() {
        loginButton.click();
    }

    public void clickOnSignUpButton() {
        signUpButton.click();
    }
    public void verifyPasswordEyeCloseIsDisplayed() {
        waitForVisibility(passwordEyeClose);
        assertElementIsDisplayed(passwordEyeClose);
    }
    public void verifyPasswordEyeOpenIsDisplayed() {
        waitForVisibility(passwordEyeOpen);
        assertElementIsDisplayed(passwordEyeOpen);
    }
}
