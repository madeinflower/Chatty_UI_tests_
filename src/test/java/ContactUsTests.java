//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import pageObjects.ContactUsPage;
//import pageObjects.Header;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static pageObjects.BasePage.wait;
//
//public class ContactUsTests extends BaseTestUser {
//    private Header header;
//    private ContactUsPage contactUsPage;
//
//    @BeforeEach
//    public void setUpTest() {
//        loginWithValidDataUser();
//        header = new Header(driver);
//        contactUsPage = new ContactUsPage(driver);
//    }
//
//    @Test
//    public void submitFeedbackWithValidData() {
//        wait.until(ExpectedConditions.visibilityOf(header.contactTab));
//        header.hoverOverContactTab();
//        header.contactTab.click();
//        wait.until(ExpectedConditions.visibilityOf(contactUsPage.contactUsElement));
//        assertTrue(contactUsPage.contactUsElement.isDisplayed());
//        contactUsPage.enterName("Tetiana");
//        contactUsPage.enterEmail("tatsenko.tetiana@gmail.com");
//        contactUsPage.enterMessage("Some message here");
//        contactUsPage.clickOnSendMessageButton();
//        wait.until(ExpectedConditions.textToBePresentInElement(contactUsPage.feedbackSubmittedMessage, "Feedback submitted successfully!"));
//        assertTrue(contactUsPage.feedbackSubmittedMessage.isDisplayed());
//    }
//
//    @Test
//    public void submitFeedbackWithAllEmptyFields() {
//        wait.until(ExpectedConditions.visibilityOf(header.contactTab));
//        header.hoverOverContactTab();
//        header.contactTab.click();
//        wait.until(ExpectedConditions.visibilityOf(contactUsPage.contactUsElement));
//        assertTrue(contactUsPage.contactUsElement.isDisplayed());
//        contactUsPage.enterName("Tetiana");
//        contactUsPage.enterEmail("tatsenko.tetiana.gmail.com");
//        contactUsPage.enterMessage("Some message here");
//        contactUsPage.clickOnSendMessageButton();
//        wait.until(ExpectedConditions.textToBePresentInElement(contactUsPage.invalidEmailFormatMessage, "Invalid email format"));
//        assertTrue(contactUsPage.invalidEmailFormatMessage.isDisplayed());
//    }
//
//    @Test
//    public void submitFeedbackWithInvalidEmailFormat() {
//        wait.until(ExpectedConditions.visibilityOf(header.contactTab));
//        header.hoverOverContactTab();
//        header.contactTab.click();
//        wait.until(ExpectedConditions.visibilityOf(contactUsPage.contactUsElement));
//        assertTrue(contactUsPage.contactUsElement.isDisplayed());
//        contactUsPage.enterName("");
//        contactUsPage.enterEmail("");
//        contactUsPage.enterMessage("");
//        contactUsPage.clickOnSendMessageButton();
//        String validationMessage = contactUsPage.nameField.getAttribute("validationMessage");
//        String expectedMessage = "Please fill out this field";
//        assertTrue(validationMessage.contains(expectedMessage), "Expected message: " + expectedMessage + ", but was: " + validationMessage);
//    }
//}
//
//

import org.junit.jupiter.api.BeforeEach;
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

    // Метод для открытия страницы "Contact Us"
    private void openContactUsPage() {
        wait.until(ExpectedConditions.visibilityOf(header.getContactTab()));
        header.hoverOverContactTab();
        header.getContactTab().click();
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getContactUsElement()));
        assertTrue(contactUsPage.getContactUsElement().isDisplayed(), "Contact Us page is not displayed");
    }

    @Test
    public void submitFeedbackWithValidData() {
        openContactUsPage();
        contactUsPage.enterName("Tetiana");
        contactUsPage.enterEmail("tatsenko.tetiana@gmail.com");
        contactUsPage.enterMessage("Some message here");
        contactUsPage.clickOnSendMessageButton();
        wait.until(ExpectedConditions.textToBePresentInElement(contactUsPage.getFeedbackSubmittedMessage(), "Feedback submitted successfully!"));
        assertTrue(contactUsPage.isFeedbackSubmittedDisplayed("Feedback submitted successfully!"),
                "Feedback submission success message is not displayed.");
    }

    @Test
    public void submitFeedbackWithAllEmptyFields() {
        openContactUsPage();
        contactUsPage.enterName("");
        contactUsPage.enterEmail("");
        contactUsPage.enterMessage("");
        contactUsPage.clickOnSendMessageButton();
        wait.until(ExpectedConditions.textToBePresentInElement(contactUsPage.getInvalidEmailFormatMessage(), "Invalid email format"));
        assertTrue(contactUsPage.isInvalidEmailMessageDisplayed("Invalid email format"),
                "Error message for invalid email format is not displayed.");
    }

    @Test
    public void submitFeedbackWithInvalidEmailFormat() {
        openContactUsPage();
        contactUsPage.enterName("");
        contactUsPage.enterEmail("tatsenko.tetiana.gmail.com");
        contactUsPage.enterMessage("Some message here");
        contactUsPage.clickOnSendMessageButton();
        String validationMessage = contactUsPage.getNameField().getAttribute("validationMessage");
        String expectedMessage = "Please fill out this field";
        assertTrue(validationMessage.contains(expectedMessage),
                "Expected validation message: " + expectedMessage + ", but was: " + validationMessage);
    }
}

