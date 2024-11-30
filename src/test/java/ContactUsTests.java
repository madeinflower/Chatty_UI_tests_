import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.ContactUsPage;
import pageObjects.Header;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class ContactUsTests extends BaseTestUser {
    private Header header;
    private ContactUsPage contactUsPage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidDataUser();
        header = new Header(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test
    @Description("Submit feedback with valid data and verify success message")
    public void submitFeedbackWithValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.getContactTab()));
        header.hoverOverContactTab();
        header.getContactTab().click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getContactUsElement()));
        assertTrue(contactUsPage.getContactUsElement().isDisplayed());
        contactUsPage.enterName("Tetiana");
        contactUsPage.enterEmail("tatsenko.tetiana@gmail.com");
        contactUsPage.enterMessage("Some message here");
        contactUsPage.clickOnSendMessageButton();
        wait.until(ExpectedConditions.textToBePresentInElement(contactUsPage.getFeedbackSubmittedMessage(), "Feedback submitted successfully!"));
        assertTrue(contactUsPage.getFeedbackSubmittedMessage().isDisplayed());
    }

    @Test
    @Description("Submit feedback with all fields empty")
    public void submitFeedbackWithAllEmptyFields() {
        wait.until(ExpectedConditions.visibilityOf(header.getContactTab()));
        header.hoverOverContactTab();
        header.getContactTab().click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getContactUsElement()));
        assertTrue(contactUsPage.getContactUsElement().isDisplayed());
        contactUsPage.enterName("Tetiana");
        contactUsPage.enterEmail("tatsenko.tetiana.gmail.com");
        contactUsPage.enterMessage("Some message here");
        contactUsPage.clickOnSendMessageButton();
        wait.until(ExpectedConditions.textToBePresentInElement(contactUsPage.getInvalidEmailFormatMessage(), "Invalid email format"));
        assertTrue(contactUsPage.getInvalidEmailFormatMessage().isDisplayed());
    }

    @Test
    @Description("Submit feedback with invalid email format")
    public void submitFeedbackWithInvalidEmailFormat() {
        wait.until(ExpectedConditions.visibilityOf(header.getContactTab()));
        header.hoverOverContactTab();
        header.getContactTab().click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getContactUsElement()));
        assertTrue(contactUsPage.getContactUsElement().isDisplayed());
        contactUsPage.enterName("");
        contactUsPage.enterEmail("");
        contactUsPage.enterMessage("");
        contactUsPage.clickOnSendMessageButton();
        String validationMessage = contactUsPage.getNameField().getAttribute("validationMessage");
        String expectedMessage = "Please fill out this field";
        assertTrue(validationMessage.contains(expectedMessage), "Expected message: " + expectedMessage + ", but was: " + validationMessage);
    }
}


