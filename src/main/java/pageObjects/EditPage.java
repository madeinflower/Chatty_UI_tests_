package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage extends BasePage {
    public EditPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//img[@alt='delete button']")
    public WebElement deleteButton;
    @FindBy(xpath = "//img[@alt='edit button']")
    public WebElement editButton;
    @FindBy(xpath = "//h2[normalize-space()='Edit Post']")
    public WebElement editPostPopUp;
    @FindBy(xpath = "//input[@placeholder='Title']")
    public WebElement editPostTitleField;
    @FindBy(xpath = "//input[@placeholder='Description']")
    public WebElement editPostDescriptionField;
    @FindBy(xpath = "//textarea[@placeholder='My thoughts. No more than 1000 characters']")
    public WebElement editPostContentField;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    public WebElement editPostSubmitButton;
    @FindBy(xpath = "//h3[normalize-space()='Some post here']")
    public WebElement editedTitleField;
    @FindBy(xpath = "//p[@class='post__description']")
    public WebElement editedDescription;
    @FindBy(xpath = "//p[@class='post__description']")
    public WebElement editedContent;
    @FindBy(xpath = "//label[normalize-space()='Save as a draft']")
    public WebElement saveAsADraftSwitcher;

    public void clearEditTitle() {
        editPostTitleField.clear();
    }
    public void clearEditDescription() {
        editPostDescriptionField.clear();
    }
    public void clearEditContent() {
        editPostContentField.clear();
    }

    public void enterEditTitle(String titleValue) {
        editPostTitleField.sendKeys(titleValue);
    }
    public void enterEditDescription(String titleValue) {
        editPostDescriptionField.sendKeys(titleValue);
    }
    public void enterEditContent(String titleValue) {
        editPostContentField.sendKeys(titleValue);
    }

    public void clickOnDeleteButton() {
        deleteButton.click();
    }
    public void clickOnEditButton() {
        editButton.click();
    }
    public void clickOnEditPostSubmitButton() {
        editPostSubmitButton.click();
    }
    public void clickOnSaveAsADraftSwitcher() {
        saveAsADraftSwitcher.click();
    }

    public boolean isSaveAsADraftSwitcherEnabled() {
        return saveAsADraftSwitcher.getAttribute("checked") != null;
    }
}
