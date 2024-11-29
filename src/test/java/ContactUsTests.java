import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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
        public void submitFeedbackWithValidData() {
        wait.until(ExpectedConditions.visibilityOf(header.contactTab));
        header.hoverOverContactTab();
        header.contactTab.click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.contactUsElement));
        assertTrue(contactUsPage.contactUsElement.isDisplayed());
        contactUsPage.enterName("Tetiana");
        contactUsPage.enterEmail("tatsenko.tetiana@gmail.com");
        contactUsPage.enterMessage("Some message here");
        contactUsPage.clickOnSendMessageButton();
        wait.until(ExpectedConditions.textToBePresentInElement(contactUsPage.feedbackSubmittedMessage, "Feedback submitted successfully!"));
        assertTrue(contactUsPage.feedbackSubmittedMessage.isDisplayed());
    }

        @Test
        public void submitFeedbackWithAllEmptyFields() {
        wait.until(ExpectedConditions.visibilityOf(header.contactTab));
        header.hoverOverContactTab();
        header.contactTab.click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.contactUsElement));
        assertTrue(contactUsPage.contactUsElement.isDisplayed());
        contactUsPage.enterName("Tetiana");
        contactUsPage.enterEmail("tatsenko.tetiana.gmail.com");
        contactUsPage.enterMessage("Some message here");
        contactUsPage.clickOnSendMessageButton();
        wait.until(ExpectedConditions.textToBePresentInElement(contactUsPage.invalidEmailFormatMessage, "Invalid email format"));
        assertTrue(contactUsPage.invalidEmailFormatMessage.isDisplayed());
    }

        @Test
        public void submitFeedbackWithInvalidEmailFormat() {
        wait.until(ExpectedConditions.visibilityOf(header.contactTab));
        header.hoverOverContactTab();
        header.contactTab.click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.contactUsElement));
        assertTrue(contactUsPage.contactUsElement.isDisplayed());
        contactUsPage.enterName("");
        contactUsPage.enterEmail("");
        contactUsPage.enterMessage("");
        contactUsPage.clickOnSendMessageButton();
        String validationMessage = contactUsPage.nameField.getAttribute("validationMessage");
        String expectedMessage = "Please fill out this field";
        assertTrue(validationMessage.contains(expectedMessage), "Expected message: " + expectedMessage + ", but was: " + validationMessage);
    }
}


