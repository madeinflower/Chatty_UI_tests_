package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {
    public UsersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[normalize-space()='Admin panel']")
    public WebElement adminPanelElement;
    @FindBy(xpath = "//td[normalize-space()='1']")
    public WebElement userNumber;
    @FindBy(xpath = "//th[@class='id-hide']")
    public WebElement userRole;
    @FindBy(xpath = "//th[@data-test='tableHeaderEmail']")
    public WebElement userEmail;
    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement userName;
    @FindBy(xpath = "//span[@data-test='editUserButton']")
    public WebElement editUserButton;
    @FindBy(xpath = "//span[@data-test='deleteUserButton']")
    public WebElement deleteUserButton;
    @FindBy(className = "post-header__plus-box")
    public WebElement editElement;
    @FindBy(css = "span[data-test='post-header__plus']")
    public WebElement plusElement;
    @FindBy(xpath = "//input[@placeholder='+123456789012']")
    public WebElement phoneNumberField;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "//button[normalize-space()='Load More']")
    public WebElement loadMoreButton;

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
