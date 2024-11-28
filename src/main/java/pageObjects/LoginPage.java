package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//form[@class='form']")
    public WebElement loginForm;
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement inputEmail;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement inputPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@class='text-error']")
    public WebElement errorMessage;
    @FindBy(xpath = "//img[@alt='close']")
    public WebElement passwordEyeClose;
    @FindBy(xpath = "//img[@alt='open']")
    public WebElement passwordEyeOpen;
    @FindBy(xpath = "//a[normalize-space()='Sign up']")
    public WebElement signUpButton;

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
