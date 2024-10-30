package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//form[@class='form']")
    public WebElement loginForm;

    @FindBy(css = "[placeholder='Email']")
    public WebElement inputEmail;

    @FindBy(css = "[placeholder='Password']")
    public WebElement inputPassword;

    @FindBy(css = "[type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='text-error']")
    public WebElement errorMessage;

    @FindBy(css = "img[alt='close']")
    public WebElement passwordEyeClose;

    @FindBy(css = "img[alt='open']")
    public WebElement passwordEyeOpen;

    @FindBy(css = "p[class='link'] a")
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
