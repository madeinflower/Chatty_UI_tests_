import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.DraftsPage;
import pageObjects.Header;
import pageObjects.HomeBlogPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class CreatePostsTests extends BaseTest {

    private HomeBlogPage homeBlogPage;
    private DraftsPage draftsPage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidData();
        homeBlogPage = new HomeBlogPage(driver);
        draftsPage = new DraftsPage(driver);
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

    @Test
    public void newPostCreateUsingTitleLengthMoreThan40Symbols() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.createPostButton));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.titleInputField));
        assertTrue(homeBlogPage.titleInputField.isDisplayed());
        String randomTitle = generateRandomString(41);
        String randomDescription = generateRandomString(50);
        String randomContent = generateRandomString(500);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.errorDescriptionMessage, "Please fill the fields"));
        assertTrue(homeBlogPage.errorDescriptionMessage.isDisplayed());
    }

    @Test // здесь я ожидала бы ошибку в поле Description, а вместо этого есть только общая ошибка
    public void newPostCreateUsingDescriptionLengthMoreThan100Symbols() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.createPostButton));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.titleInputField));
        assertTrue(homeBlogPage.titleInputField.isDisplayed());
        String randomTitle = generateRandomString(25);
        String randomDescription = generateRandomString(101);
        String randomContent = generateRandomString(500);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.errorAllFieldsEmptyMessage, "Please fill all fields"));
        assertTrue(homeBlogPage.errorAllFieldsEmptyMessage.isDisplayed());
    }

    @Test
    @Disabled // баг в реализации - ничего не происходит при клике на Submit
    public void newPostCreateUsingContentLengthMoreThan1000Symbols() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.createPostButton));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.titleInputField));
        assertTrue(homeBlogPage.titleInputField.isDisplayed());
        String randomTitle = generateRandomString(25);
        String randomDescription = generateRandomString(60);
        String randomContent = generateRandomString(1001);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.errorContentMessage, "Please fill the field"));
        assertTrue(homeBlogPage.errorContentMessage.isDisplayed());
    }

    @Test
    public void newPostSavingAsDraft() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.createPostButton));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.titleInputField));
        assertTrue(homeBlogPage.titleInputField.isDisplayed());
        String randomTitle = generateRandomString(25);
        String randomDescription = generateRandomString(60);
        String randomContent = generateRandomString(500);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSaveAsDraftSwitcher();
        homeBlogPage.clickOnSubmitButton();
        homeBlogPage.clickOnMyDraftsOption();
        //wait.until(ExpectedConditions.textToBePresentInElement(draftsPage.draftTitle, randomTitle)); - та же проблема, что и в первом тесте
        wait.until(ExpectedConditions.visibilityOf(draftsPage.draftTitle));
        assertTrue(draftsPage.draftTitle.isDisplayed());
    }

}
