package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[normalize-space()='Contact Us']")
    public WebElement contactUsElement;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameField;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailField;
    @FindBy(xpath = "//textarea[@id='content']")
    public WebElement messageField;
    @FindBy(xpath = "//button[normalize-space()='Send Message']")
    public WebElement sendMessageButton;
    @FindBy(xpath = "//div[@class='success-message']")
    public WebElement feedbackSubmittedMessage;
    @FindBy(xpath = "//p[@class='error']")
    public WebElement invalidEmailFormatMessage;

    public void enterName (String nameValue) {
        nameField.sendKeys(nameValue);
    }
    public void enterEmail (String emailValue) {
        emailField.sendKeys(emailValue);
    }
    public void enterMessage (String messageValue) {
        messageField.sendKeys(messageValue);
    }
    public void clickOnSendMessageButton() {
        sendMessageButton.click();
    }
}
