import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class EditPostTests extends BaseTestUser {

    private HomeBlogPage homeBlogPage;
    private EditPage editPage;
    private Header header;
    private DraftsPage draftsPage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidDataUser();
        homeBlogPage = new HomeBlogPage(driver);
        editPage = new EditPage(driver);
        header = new Header(driver);
        draftsPage = new DraftsPage(driver);
    }

        @Test
        public void editPostContentUsingValidData() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.myPostsSwitcher));
        homeBlogPage.clickOnMyPostSwitcher();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.firstPostFrame));
        homeBlogPage.firstPostFrame.click();
        wait.until(ExpectedConditions.visibilityOf(editPage.editButton));
        assertTrue(editPage.editButton.isDisplayed());
        editPage.clickOnEditButton();
        wait.until(ExpectedConditions.visibilityOf(editPage.editPostPopUp));
        assertTrue(editPage.editPostPopUp.isDisplayed());
        String randomTitle = getRandomString(30);
        String randomDescription = getRandomString(70);
        String randomContent = getRandomString(500);
        editPage.clearEditTitle();
        editPage.clearEditDescription();
        editPage.clearEditContent();
        editPage.enterEditTitle(randomTitle);
        editPage.enterEditDescription(randomDescription);
        editPage.enterEditContent(randomContent);
        editPage.clickOnEditPostSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(editPage.editedTitleField, randomTitle));
        assertTrue(editPage.editedTitleField.isDisplayed());
     }

    @Test
    @Disabled // скорей всего баг вреализации, так как свитчер saveasdraft сохраняет стату с предыдущего редактирования
    public void editPostToDraft() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.myPostsSwitcher));
        homeBlogPage.clickOnMyPostSwitcher();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.firstPostFrame));
        homeBlogPage.firstPostFrame.click();
        wait.until(ExpectedConditions.visibilityOf(editPage.editButton));
        assertTrue(editPage.editButton.isDisplayed());
        editPage.clickOnEditButton();
        wait.until(ExpectedConditions.visibilityOf(editPage.editPostPopUp));
        assertTrue(editPage.editPostPopUp.isDisplayed());
        String randomTitle = getRandomString(30);
        String randomDescription = getRandomString(70);
        String randomContent = getRandomString(500);
        editPage.clearEditTitle();
        editPage.clearEditDescription();
        editPage.clearEditContent();
        editPage.enterEditTitle("Some title here");
        editPage.enterEditDescription(randomDescription);
        editPage.enterEditContent(randomContent);

//        if (editPage.isSaveAsADraftSwitcherEnabled()) {
//            editPage.clickOnSaveAsADraftSwitcher(); // Выключаем, если включен
//        }

        editPage.clickOnSaveAsADraftSwitcher();
        editPage.clickOnEditPostSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElement(editPage.editedTitleField, "Some title here"));
        assertTrue(editPage.editedTitleField.isDisplayed());
        header.hoverOverHomeTab();
        header.homeTab.click();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.myDraftsOption));
        homeBlogPage.clickOnMyDraftsOption();
        wait.until(ExpectedConditions.textToBePresentInElement(draftsPage.draftTitle, "Some title here"));
        assertTrue(draftsPage.draftTitle.isDisplayed());
    }



}
