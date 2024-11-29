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
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.adminPanelElement, "Admin panel"));
        assertTrue(usersPage.adminPanelElement.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(usersPage.userNumber));
        wait.until(ExpectedConditions.visibilityOf(usersPage.userRole));
        wait.until(ExpectedConditions.visibilityOf(usersPage.userEmail));
        wait.until(ExpectedConditions.visibilityOf(usersPage.userName));
        wait.until(ExpectedConditions.visibilityOf(usersPage.editUserButton));
        wait.until(ExpectedConditions.visibilityOf(usersPage.deleteUserButton));
        assertTrue(usersPage.deleteUserButton.isDisplayed());
    }

    @Test
    public void editAccountDetails() {
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.adminPanelElement, "Admin panel"));
        assertTrue(usersPage.adminPanelElement.isDisplayed());
        usersPage.clickOnEditUserButton();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.editElement, "Edit"));
        assertTrue(usersPage.editElement.isDisplayed());
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.plusElement, "+"));
        assertTrue(usersPage.plusElement.isDisplayed());
        usersPage.clickOnPlusElement();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.editElement, "Cancel"));
        assertTrue(usersPage.editElement.isDisplayed());
        usersPage.clearOfPhoneNumberField();
        usersPage.enterPhoneNumber("12345678900");
        usersPage.clickOnSaveButton();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.editElement, "Edit"));
        assertTrue(usersPage.editElement.isDisplayed());
    }

    @Test
    public void editAccountDetailsDiscardChanges() {
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.adminPanelElement, "Admin panel"));
        assertTrue(usersPage.adminPanelElement.isDisplayed());
        usersPage.clickOnEditUserButton();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.editElement, "Edit"));
        assertTrue(usersPage.editElement.isDisplayed());
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.plusElement, "+"));
        assertTrue(usersPage.plusElement.isDisplayed());
        usersPage.clickOnPlusElement();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.editElement, "Cancel"));
        assertTrue(usersPage.editElement.isDisplayed());
        usersPage.clearOfPhoneNumberField();
        usersPage.enterPhoneNumber("12345678900");
        usersPage.clickOnPlusElement();
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.editElement, "Edit"));
        assertTrue(usersPage.editElement.isDisplayed());
    }

    @Test
    @Disabled // надо подумать как прописать то, чтобы после клика на кнопку DeleteUser, удаленный юзер не отображался в списке
    public void deleteAccount() {
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.adminPanelElement, "Admin panel"));
        assertTrue(usersPage.adminPanelElement.isDisplayed());
        usersPage.clickOnDeleteUserButton();
    }

    @Test
    public void showMoreUsersByLoadMoreButtonClick() {
        wait.until(ExpectedConditions.textToBePresentInElement(usersPage.adminPanelElement, "Admin panel"));
        assertTrue(usersPage.adminPanelElement.isDisplayed());
        usersPage.clickOnLoadMoreButton();
    }
}
