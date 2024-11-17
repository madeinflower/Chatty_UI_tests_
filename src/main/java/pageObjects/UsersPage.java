package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class UsersPage extends BasePage {

    @FindBy(css = "h1[data-test='adminPanelTitle']")
    public WebElement adminPanelElement;

    @FindBy(xpath = "//td[normalize-space()='1']")
    public WebElement userNumber;

    @FindBy(className = "id-hide")
    public WebElement userRole;

    @FindBy(xpath = "//th[@data-test='tableHeaderEmail']")
    public WebElement userEmail;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement userName;

    @FindBy(css = "span[data-test='editUserButton']")
    public WebElement editUserButton;

    @FindBy(css = "span[data-test='deleteUserButton']")
    public WebElement deleteUserButton;

    @FindBy(className = "post-header__plus-box")
    public WebElement editElement;

    @FindBy(css = "span[data-test='post-header__plus']")
    public WebElement plusElement;

    @FindBy(name = "phone")
    public WebElement phoneNumberField;

    @FindBy(className = "save__btn")
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

    public UsersPage(WebDriver driver) {
        super(driver);
    }
}
