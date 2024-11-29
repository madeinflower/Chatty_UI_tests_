package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage extends BasePage {
    public EditPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//img[@alt='delete button']")
    private WebElement deleteButton;
    @FindBy(xpath = "//img[@alt='edit button']")
    private WebElement editButton;
    @FindBy(xpath = "//h2[normalize-space()='Edit Post']")
    private WebElement editPostPopUp;
    @FindBy(xpath = "//input[@placeholder='Title']")
    private WebElement editPostTitleField;
    @FindBy(xpath = "//input[@placeholder='Description']")
    private WebElement editPostDescriptionField;
    @FindBy(xpath = "//textarea[@placeholder='My thoughts. No more than 1000 characters']")
    private WebElement editPostContentField;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement editPostSubmitButton;
    @FindBy(xpath = "//h3[normalize-space()='Some post here']")
    private WebElement editedTitleField;
    @FindBy(xpath = "//p[@class='post__description']")
    private WebElement editedDescription;
    @FindBy(xpath = "//p[@class='post__description']")
    private WebElement editedContent;
    @FindBy(xpath = "//label[normalize-space()='Save as a draft']")
    private WebElement saveAsADraftSwitcher;

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getEditPostPopUp() {
        return editPostPopUp;
    }

    public WebElement getEditPostTitleField() {
        return editPostTitleField;
    }

    public WebElement getEditPostDescriptionField() {
        return editPostDescriptionField;
    }

    public WebElement getEditPostContentField() {
        return editPostContentField;
    }

    public WebElement getEditPostSubmitButton() {
        return editPostSubmitButton;
    }

    public WebElement getEditedTitleField() {
        return editedTitleField;
    }

    public WebElement getEditedDescription() {
        return editedDescription;
    }

    public WebElement getEditedContent() {
        return editedContent;
    }

    public WebElement getSaveAsADraftSwitcher() {
        return saveAsADraftSwitcher;
    }

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
