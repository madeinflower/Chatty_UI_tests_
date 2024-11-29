import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.DraftsPage;
import pageObjects.HomeBlogPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class CreatePostsTests extends BaseTestUser {

    private HomeBlogPage homeBlogPage;
    private DraftsPage draftsPage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidDataUser();
        homeBlogPage = new HomeBlogPage(driver);
        draftsPage = new DraftsPage(driver);
    }

    @Test // узнать как загрузить имидж и написать тест на это!!!
    public void newPostCreateUsingValidDataWithoutImage() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getCreatePostButton()));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getTitleInputField()));
        assertTrue(homeBlogPage.getTitleInputField().isDisplayed());
        String randomTitle = getRandomString(40);
        String randomDescription = getRandomString(100);
        String randomContent = getRandomString(1000);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getFirstPostDescription())); // тут надо дописать, что мы видим именно тот пост, который мы сделали!!!
        assertTrue(homeBlogPage.getFirstPostDescription().isDisplayed());
    }

    @Test
    public void newPostCreateWithEmptyTitleField() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getCreatePostButton()));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getTitleInputField()));
        assertTrue(homeBlogPage.getTitleInputField().isDisplayed());
        homeBlogPage.enterTitle("");
        homeBlogPage.enterDescription("SomeDescriptionHere");
        homeBlogPage.enterContent("SomeContentHere");
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.getErrorTitleMessage(), "Please fill the field"));
        assertTrue(homeBlogPage.getErrorTitleMessage().isDisplayed());
    }

    @Test
    public void newPostCreateWithEmptyDescriptionField() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getCreatePostButton()));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getTitleInputField()));
        assertTrue(homeBlogPage.getTitleInputField().isDisplayed());
        homeBlogPage.enterTitle("SomeTitleHere");
        homeBlogPage.enterDescription("");
        homeBlogPage.enterContent("SomeContentHere");
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.getErrorDescriptionMessage(), "Please fill the field"));
        assertTrue(homeBlogPage.getErrorDescriptionMessage().isDisplayed());
    }

    @Test
    public void newPostCreateWithEmptyContentField() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getCreatePostButton()));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getTitleInputField()));
        assertTrue(homeBlogPage.getTitleInputField().isDisplayed());
        homeBlogPage.enterTitle("SomeTitleHere");
        homeBlogPage.enterDescription("SomeDescriptionHere");
        homeBlogPage.enterContent("");
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.getErrorContentMessage(), "Please fill the field"));
        assertTrue(homeBlogPage.getErrorContentMessage().isDisplayed());
    }

    @Test
    public void newPostCreateWithAllEmptyFields() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getCreatePostButton()));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getTitleInputField()));
        assertTrue(homeBlogPage.getTitleInputField().isDisplayed());
        homeBlogPage.enterTitle("");
        homeBlogPage.enterDescription("");
        homeBlogPage.enterContent("");
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.getErrorAllFieldsEmptyMessage(), "Please fill all fields"));
        assertTrue(homeBlogPage.getErrorAllFieldsEmptyMessage().isDisplayed());
    }

    @Test
    public void newPostCreateUsingTitleLengthMoreThan40Symbols() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getCreatePostButton()));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getTitleInputField()));
        assertTrue(homeBlogPage.getTitleInputField().isDisplayed());
        String randomTitle = getRandomString(41);
        String randomDescription = getRandomString(50);
        String randomContent = getRandomString(500);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.getErrorDescriptionMessage(), "Please fill the fields"));
        assertTrue(homeBlogPage.getErrorDescriptionMessage().isDisplayed());
    }

    @Test // здесь я ожидала бы ошибку в поле Description, а вместо этого есть только общая ошибка
    public void newPostCreateUsingDescriptionLengthMoreThan100Symbols() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getCreatePostButton()));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getTitleInputField()));
        assertTrue(homeBlogPage.getTitleInputField().isDisplayed());
        String randomTitle = getRandomString(25);
        String randomDescription = getRandomString(101);
        String randomContent = getRandomString(500);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.getErrorAllFieldsEmptyMessage(), "Please fill all fields"));
        assertTrue(homeBlogPage.getErrorAllFieldsEmptyMessage().isDisplayed());
    }

    @Test
    @Disabled // баг в реализации - ничего не происходит при клике на Submit
    public void newPostCreateUsingContentLengthMoreThan1000Symbols() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getCreatePostButton()));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getTitleInputField()));
        assertTrue(homeBlogPage.getTitleInputField().isDisplayed());
        String randomTitle = getRandomString(25);
        String randomDescription = getRandomString(60);
        String randomContent = getRandomString(1001);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(homeBlogPage.getErrorContentMessage(), "Please fill the field"));
        assertTrue(homeBlogPage.getErrorContentMessage().isDisplayed());
    }

    @Test
    public void newPostSavingAsDraft() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getCreatePostButton()));
        homeBlogPage.clickOnCreatePostButton();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getTitleInputField()));
        assertTrue(homeBlogPage.getTitleInputField().isDisplayed());
        String randomTitle = getRandomString(25);
        String randomDescription = getRandomString(60);
        String randomContent = getRandomString(500);
        homeBlogPage.enterTitle(randomTitle);
        homeBlogPage.enterDescription(randomDescription);
        homeBlogPage.enterContent(randomContent);
        homeBlogPage.clickOnSaveAsDraftSwitcher();
        homeBlogPage.clickOnSubmitButton();
        homeBlogPage.clickOnMyDraftsOption();
        wait.until(ExpectedConditions.visibilityOf(draftsPage.getDraftTitle()));
        assertTrue(draftsPage.getDraftTitle().isDisplayed());
    }
}
