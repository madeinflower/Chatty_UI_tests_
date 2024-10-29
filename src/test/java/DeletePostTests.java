import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.EditPage;
import pageObjects.Header;
import pageObjects.HomeBlogPage;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class DeletePostTests extends BaseTest {

    private HomeBlogPage homeBlogPage;
    private Header header;
    private EditPage editPage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidData();
        homeBlogPage = new HomeBlogPage(driver);
        header = new Header(driver);
        editPage = new EditPage(driver);
    }

    @Test
    public void deletePublishedPost() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.myPostsSwitcher));
        homeBlogPage.clickOnMyPostSwitcher();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.firstPostFrame));
        String firstPostTitleBeforeDeletion = homeBlogPage.firstPostFrame.getText();
        homeBlogPage.firstPostFrame.click();
        wait.until(ExpectedConditions.visibilityOf(editPage.deleteButton));
        assertTrue(editPage.deleteButton.isDisplayed());
        editPage.clickOnDeleteButton();
        wait.until(ExpectedConditions.visibilityOf(header.homeTab));
        header.hoverOverHomeTab();
        header.homeTab.click();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.firstPostFrame));
        String firstPostTitleAfterDeletion = homeBlogPage.firstPostFrame.getText();
        assertNotEquals(firstPostTitleBeforeDeletion, firstPostTitleAfterDeletion, "Other post should be seen after deletion");
    }

    @Test
    public void deleteDraftPost() {
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.myDraftsOption));
        homeBlogPage.clickOnMyDraftsOption();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.firstPostFrame));
        String firstDraftTitleBeforeDeletion = homeBlogPage.firstPostFrame.getText();
        homeBlogPage.firstPostFrame.click();
        wait.until(ExpectedConditions.visibilityOf(editPage.deleteButton));
        assertTrue(editPage.deleteButton.isDisplayed());
        editPage.clickOnDeleteButton();
        wait.until(ExpectedConditions.visibilityOf(header.homeTab));
        header.hoverOverHomeTab();
        header.homeTab.click();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.myDraftsOption));
        homeBlogPage.clickOnMyDraftsOption();
        wait.until(ExpectedConditions.visibilityOf(homeBlogPage.firstPostFrame));
        String firstDraftTitleAfterDeletion = homeBlogPage.firstPostFrame.getText();
        assertNotEquals(firstDraftTitleBeforeDeletion, firstDraftTitleAfterDeletion, "Other post should be seen after deletion");
    }


}
