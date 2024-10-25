import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Header;
import pageObjects.HomeBlogPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class CreatePostsTests extends BaseTest {

    private HomeBlogPage homeBlogPage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidData();
        homeBlogPage = new HomeBlogPage(driver);
    }

    @Test // узнать как загрузить имидж и написать тест на это!!!
    public void newPostCreateUsingValidDataWithoutImage() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.createPostButton));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.titleInputField));
        assertTrue(homeBlogPage.titleInputField.isDisplayed());
        String randomTitle = generateRandomString(40);
        String randomDescription = generateRandomString(100);
        String randomContent = generateRandomString(1000);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.firstPostTitle)); // тут надо дописать, что мы видим именно тот пост, который мы сделали!!!
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.firstPostDescription)); // тут надо дописать, что мы видим именно тот пост, который мы сделали!!!
    }

    @Test
    public void newPostCreateWithEmptyTitleField() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.createPostButton));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.titleInputField));
        assertTrue(homeBlogPage.titleInputField.isDisplayed());
        homeBlogPage.enterTitle("");
        homeBlogPage.enterDescription("SomeDescriptionHere");
        homeBlogPage.enterContent("SomeContentHere");
        homeBlogPage.clickOnSubmitButton();
        //wait.until(ExpectedConditions.visibilityOf(homeBlogPage.errorTitleMessage));
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.errorTitleMessage, "Please fill the field"));
        assertTrue(homeBlogPage.errorTitleMessage.isDisplayed());
    }

    @Test
    public void newPostCreateWithEmptyDescriptionField() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.createPostButton));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.titleInputField));
        assertTrue(homeBlogPage.titleInputField.isDisplayed());
        homeBlogPage.enterTitle("SomeTitleHere");
        homeBlogPage.enterDescription("");
        homeBlogPage.enterContent("SomeContentHere");
        homeBlogPage.clickOnSubmitButton();
        //wait.until(ExpectedConditions.visibilityOf(homeBlogPage.errorTitleMessage));
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.errorDescriptionMessage, "Please fill the field"));
        assertTrue(homeBlogPage.errorDescriptionMessage.isDisplayed());
    }

    @Test
    public void newPostCreateWithEmptyContentField() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.createPostButton));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.titleInputField));
        assertTrue(homeBlogPage.titleInputField.isDisplayed());
        homeBlogPage.enterTitle("SomeTitleHere");
        homeBlogPage.enterDescription("SomeDescriptionHere");
        homeBlogPage.enterContent("");
        homeBlogPage.clickOnSubmitButton();
        //wait.until(ExpectedConditions.visibilityOf(homeBlogPage.errorTitleMessage));
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.errorContentMessage, "Please fill the field"));
        assertTrue(homeBlogPage.errorContentMessage.isDisplayed());
    }

    @Test
    public void newPostCreateWithAllEmptyFields() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.createPostButton));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.titleInputField));
        assertTrue(homeBlogPage.titleInputField.isDisplayed());
        homeBlogPage.enterTitle("");
        homeBlogPage.enterDescription("");
        homeBlogPage.enterContent("");
        homeBlogPage.clickOnSubmitButton();
        //wait.until(ExpectedConditions.visibilityOf(homeBlogPage.errorTitleMessage));
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.errorAllFieldsEmptyMessage, "Please fill all fields"));
        assertTrue(homeBlogPage.errorAllFieldsEmptyMessage.isDisplayed());
    }
}
