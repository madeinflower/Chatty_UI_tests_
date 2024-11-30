//package pageObjects;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class ContactUsPage extends BasePage{
//    public ContactUsPage(WebDriver driver) {
//        super(driver);
//    }
//    @FindBy(xpath = "//h1[normalize-space()='Contact Us']")
//    public WebElement contactUsElement;
//    @FindBy(xpath = "//input[@id='name']")
//    public WebElement nameField;
//    @FindBy(xpath = "//input[@id='email']")
//    public WebElement emailField;
//    @FindBy(xpath = "//textarea[@id='content']")
//    public WebElement messageField;
//    @FindBy(xpath = "//button[normalize-space()='Send Message']")
//    public WebElement sendMessageButton;
//    @FindBy(xpath = "//div[@class='success-message']")
//    public WebElement feedbackSubmittedMessage;
//    @FindBy(xpath = "//p[@class='error']")
//    public WebElement invalidEmailFormatMessage;
//
//    public void enterName (String nameValue) {
//        nameField.sendKeys(nameValue);
//    }
//    public void enterEmail (String emailValue) {
//        emailField.sendKeys(emailValue);
//    }
//    public void enterMessage (String messageValue) {
//        messageField.sendKeys(messageValue);
//    }
//    public void clickOnSendMessageButton() {
//        sendMessageButton.click();
//    }
//}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    protected  Header header;

    @FindBy(xpath = "//h1[normalize-space()='Contact Us']")
    private WebElement contactUsElement;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//textarea[@id='content']")
    private WebElement messageField;

    @FindBy(xpath = "//button[normalize-space()='Send Message']")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//div[@class='success-message']")
    private WebElement feedbackSubmittedMessage;

    @FindBy(xpath = "//p[@class='error']")
    private WebElement invalidEmailFormatMessage;

    // Геттеры для веб-элементов
    public WebElement getContactUsElement() {
        return contactUsElement;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getMessageField() {
        return messageField;
    }

    public WebElement getSendMessageButton() {
        return sendMessageButton;
    }

    public WebElement getFeedbackSubmittedMessage() {
        return feedbackSubmittedMessage;
    }

    public WebElement getInvalidEmailFormatMessage() {
        return invalidEmailFormatMessage;
    }

    public void enterName(String nameValue) {
        nameField.clear();
        nameField.sendKeys(nameValue);
    }

    public void enterEmail(String emailValue) {
        emailField.clear();
        emailField.sendKeys(emailValue);
    }

    public void enterMessage(String messageValue) {
        messageField.clear();
        messageField.sendKeys(messageValue);
    }

    public void clickOnSendMessageButton() {
        sendMessageButton.click();
    }
    public void openContactUsPage() {
        wait.until(ExpectedConditions.visibilityOf(header.getContactTab()));
        header.hoverOverContactTab();
        header.getContactTab().click();
        waitForVisibility(contactUsElement);
        assertElementIsDisplayed(contactUsElement);
    }

    public boolean isFeedbackSubmittedDisplayed(String expectedMessage) {
        return feedbackSubmittedMessage.getText().contains(expectedMessage);
    }

    public boolean isInvalidEmailMessageDisplayed(String expectedMessage) {
        return invalidEmailFormatMessage.getText().contains(expectedMessage);
    }
}

