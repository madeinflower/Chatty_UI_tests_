package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class RegistrationPage extends BasePage {

    @FindBy(css = "form[class='form'] h1")
    public WebElement createAccountTitle;

    @FindBy(css = "a[href='/login']")
    public WebElement loginButton;

    @FindBy(css = "input[placeholder='Email']")
    public WebElement emailInputField;

    @FindBy(css = "input[placeholder='Password']")
    public WebElement passwordInputField;

    @FindBy(css = "input[placeholder='Confirm password']")
    public WebElement confirmPasswordField;

    @FindBy(css = "button[type='submit']")
    public WebElement registrationButton;

    @FindBy(css = "form[class='form'] select")
    public WebElement dropDownMenuUserAdmin;

    @FindBy(xpath = "//div[normalize-space()='Password must be 8-100 characters and include at least one letter and one digit']")
    public WebElement passwordFieldErrorMessage;

    @FindBy(css = "a[href='/contact']")
    public WebElement contactUsOption;

    @FindBy(css = "a[href='/about']")
    public WebElement aboutUsOption;

    @FindBy(xpath = "//div[normalize-space()='Email cannot be empty']")
    public WebElement emailInputFieldErrorMessage;

    @FindBy(xpath = "//div[normalize-space()='Confirm password cannot be empty']")
    public WebElement confirmPasswordInputFieldErrorMessage;


    public void enterEmailField(String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void enterPasswordField(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void enterConfirmPasswordField(String confirmPassword) {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
    }


    public void clickOnRegistrationButton() {
        registrationButton.click();
    }
    public void clickOndropDownMenuUserAdmin() {
        dropDownMenuUserAdmin.click();
    }


    public String generateRandomEmail(int minLength, int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder email = new StringBuilder();

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            email.append(characters.charAt(index));
        }

        return email + "@gmail.com";
    }

    public String generateRandomPassword(int length) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

    public void selectUserRole(String role) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form[class='form'] select")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(role);
    }





    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
}
