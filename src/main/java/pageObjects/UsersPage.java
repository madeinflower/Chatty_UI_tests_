package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {
    public UsersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[normalize-space()='Admin panel']")
    private WebElement adminPanelElement;
    @FindBy(xpath = "//td[normalize-space()='1']")
    private WebElement userNumber;
    @FindBy(xpath = "//th[@class='id-hide']")
    private WebElement userRole;
    @FindBy(xpath = "//th[@data-test='tableHeaderEmail']")
    private WebElement userEmail;
    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    private WebElement userName;
    @FindBy(xpath = "//span[@data-test='editUserButton']")
    private WebElement editUserButton;
    @FindBy(xpath = "//span[@data-test='deleteUserButton']")
    private WebElement deleteUserButton;
    @FindBy(className = "post-header__plus-box")
    private WebElement editElement;
    @FindBy(css = "span[data-test='post-header__plus']")
    private WebElement plusElement;
    @FindBy(xpath = "//input[@placeholder='+123456789012']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//button[normalize-space()='Load More']")
    private WebElement loadMoreButton;

    public WebElement getAdminPanelElement() {
        return adminPanelElement;
    }

    public WebElement getUserNumber() {
        return userNumber;
    }

    public WebElement getUserRole() {
        return userRole;
    }

    public WebElement getUserEmail() {
        return userEmail;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getEditUserButton() {
        return editUserButton;
    }

    public WebElement getDeleteUserButton() {
        return deleteUserButton;
    }

    public WebElement getEditElement() {
        return editElement;
    }

    public WebElement getPlusElement() {
        return plusElement;
    }

    public WebElement getPhoneNumberField() {
        return phoneNumberField;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getLoadMoreButton() {
        return loadMoreButton;
    }

    public void enterPhoneNumber(String phoneNumberValue) {
        phoneNumberField.sendKeys(phoneNumberValue);
    }
    public void clickOnEditUserButton() {editUserButton.click(); }
    public void clickOnPlusElement() {plusElement.click(); }
    public void clickOnSaveButton() {saveButton.click(); }
    public void clickOnDeleteUserButton() {deleteUserButton.click(); }
    public void clickOnLoadMoreButton() {loadMoreButton.click(); }
    public void clearOfPhoneNumberField() {phoneNumberField.clear(); }
}
