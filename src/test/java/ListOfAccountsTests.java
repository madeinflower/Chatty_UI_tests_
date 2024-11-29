import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.UsersPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public class ListOfAccountsTests extends BaseTestAdmin {

    private UsersPage usersPage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidDataAdmin();
        usersPage = new UsersPage(driver);
    }

    @Test
    public void viewListOfCreatedAccounts() {
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getAdminPanelElement(), "Admin panel"));
        assertTrue(usersPage.getAdminPanelElement().isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(usersPage.getUserNumber()));
        wait.until(ExpectedConditions.visibilityOf(usersPage.getUserRole()));
        wait.until(ExpectedConditions.visibilityOf(usersPage.getUserEmail()));
        wait.until(ExpectedConditions.visibilityOf(usersPage.getUserName()));
        wait.until(ExpectedConditions.visibilityOf(usersPage.getEditUserButton()));
        wait.until(ExpectedConditions.visibilityOf(usersPage.getDeleteUserButton()));
        assertTrue(usersPage.getDeleteUserButton().isDisplayed());
    }

    @Test
    public void editAccountDetails() {
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getAdminPanelElement(), "Admin panel"));
        assertTrue(usersPage.getAdminPanelElement().isDisplayed());
        usersPage.clickOnEditUserButton();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getEditElement(), "Edit"));
        assertTrue(usersPage.getEditElement().isDisplayed());
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getPlusElement(), "+"));
        assertTrue(usersPage.getPlusElement().isDisplayed());
        usersPage.clickOnPlusElement();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getEditElement(), "Cancel"));
        assertTrue(usersPage.getEditElement().isDisplayed());
        usersPage.clearOfPhoneNumberField();
        usersPage.enterPhoneNumber("12345678900");
        usersPage.clickOnSaveButton();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getEditElement(), "Edit"));
        assertTrue(usersPage.getEditElement().isDisplayed());
    }

    @Test
    public void editAccountDetailsDiscardChanges() {
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getAdminPanelElement(), "Admin panel"));
        assertTrue(usersPage.getAdminPanelElement().isDisplayed());
        usersPage.clickOnEditUserButton();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getEditElement(), "Edit"));
        assertTrue(usersPage.getEditElement().isDisplayed());
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getPlusElement(), "+"));
        assertTrue(usersPage.getPlusElement().isDisplayed());
        usersPage.clickOnPlusElement();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getEditElement(), "Cancel"));
        assertTrue(usersPage.getEditElement().isDisplayed());
        usersPage.clearOfPhoneNumberField();
        usersPage.enterPhoneNumber("12345678900");
        usersPage.clickOnPlusElement();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getEditElement(), "Edit"));
        assertTrue(usersPage.getEditElement().isDisplayed());
    }

    @Test
    @Disabled // надо подумать как прописать то, чтобы после клика на кнопку DeleteUser, удаленный юзер не отображался в списке
    public void deleteAccount() {
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getAdminPanelElement(), "Admin panel"));
        assertTrue(usersPage.getAdminPanelElement().isDisplayed());
        usersPage.clickOnDeleteUserButton();
    }

    @Test
    public void showMoreUsersByLoadMoreButtonClick() {
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.getAdminPanelElement(), "Admin panel"));
        assertTrue(usersPage.getAdminPanelElement().isDisplayed());
        usersPage.clickOnLoadMoreButton();
    }
}
