import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.EditPage;
import pageObjects.Header;
import pageObjects.HomeBlogPage;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class DeletePostTests extends BaseTestUser {

    private HomeBlogPage homeBlogPage;
    private Header header;
    private EditPage editPage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidDataUser();
        homeBlogPage = new HomeBlogPage(driver);
        header = new Header(driver);
        editPage = new EditPage(driver);
    }

    @Test
    public void deletePublishedPost() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getMyPostsSwitcher()));
        homeBlogPage.clickOnMyPostSwitcher();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getFirstPostFrame()));
        String firstPostTitleBeforeDeletion = homeBlogPage.getFirstPostFrame().getText();
        homeBlogPage.getFirstPostFrame().click();
        wait.until(ExpectedConditions.visibilityOf(editPage.getDeleteButton()));
        assertTrue(editPage.getDeleteButton().isDisplayed());
        editPage.clickOnDeleteButton();
        wait.until(ExpectedConditions.visibilityOf(header.getHomeTab()));
        header.hoverOverHomeTab();
        header.getHomeTab().click();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getFirstPostFrame()));
        String firstPostTitleAfterDeletion = homeBlogPage.getFirstPostFrame().getText();
        assertNotEquals(firstPostTitleBeforeDeletion, firstPostTitleAfterDeletion, "Other post should be seen after deletion");
    }

    @Test
    public void deleteDraftPost() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getMyDraftsOption()));
        homeBlogPage.clickOnMyDraftsOption();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getFirstPostFrame()));
        String firstDraftTitleBeforeDeletion = homeBlogPage.getFirstPostFrame().getText();
        homeBlogPage.getFirstPostFrame().click();
        wait.until(ExpectedConditions.visibilityOf(editPage.getDeleteButton()));
        assertTrue(editPage.getDeleteButton().isDisplayed());
        editPage.clickOnDeleteButton();
        wait.until(ExpectedConditions.visibilityOf(header.getHomeTab()));
        header.hoverOverHomeTab();
        header.getHomeTab().click();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getMyDraftsOption()));
        homeBlogPage.clickOnMyDraftsOption();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.getFirstPostFrame()));
        String firstDraftTitleAfterDeletion = homeBlogPage.getFirstPostFrame().getText();
        assertNotEquals(firstDraftTitleBeforeDeletion, firstDraftTitleAfterDeletion, "Other post should be seen after deletion");
    }
}
