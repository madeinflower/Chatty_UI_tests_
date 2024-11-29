package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Create Account']")
    private WebElement createAccountTitle;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailInputField;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInputField;
    @FindBy(xpath = "//input[@placeholder='Confirm password']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//button[normalize-space()='Registration']")
    private WebElement registrationButton;
    @FindBy(xpath = "//form[@class='form']//select")
    private WebElement dropDownMenuUserAdmin;
    @FindBy(xpath = "//div[normalize-space()='Password must be 8-100 characters and include at least one letter and one digit']")
    private WebElement passwordFieldErrorMessage;
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    private WebElement contactUsOption;
    @FindBy(xpath = "//a[normalize-space()='About us']")
    private WebElement aboutUsOption;
    @FindBy(xpath = "//div[normalize-space()='Email cannot be empty']")
    private WebElement emailInputFieldErrorMessage;
    @FindBy(xpath = "//div[normalize-space()='Confirm password cannot be empty']")
    private WebElement confirmPasswordInputFieldErrorMessage;

    public WebElement getCreateAccountTitle() {
        return createAccountTitle;
    }

    public WebElement getEmailInputField() {
        return emailInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getRegistrationButton() {
        return registrationButton;
    }

    public WebElement getDropDownMenuUserAdmin() {
        return dropDownMenuUserAdmin;
    }

    public WebElement getPasswordFieldErrorMessage() {
        return passwordFieldErrorMessage;
    }

    public WebElement getContactUsOption() {
        return contactUsOption;
    }

    public WebElement getAboutUsOption() {
        return aboutUsOption;
    }

    public WebElement getEmailInputFieldErrorMessage() {
        return emailInputFieldErrorMessage;
    }

    public WebElement getConfirmPasswordInputFieldErrorMessage() {
        return confirmPasswordInputFieldErrorMessage;
    }

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
}
