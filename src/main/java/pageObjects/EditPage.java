package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage extends BasePage {


    @FindBy(css = "img[alt='delete button']")
    public WebElement deleteButton;

    @FindBy(css = "img[alt='edit button']")
    public WebElement editButton;

    @FindBy(css = "div[class='modal-content'] h2")
    public WebElement editPostPopUp;

    @FindBy(css = "input[placeholder='Title']")
    public WebElement editPostTitleField;

    @FindBy(css = "input[placeholder='Description']")
    public WebElement editPostDescriptionField;

    @FindBy(name = "content")
    public WebElement editPostContentField;

    @FindBy(css = "button[type='submit']")
    public WebElement editPostSubmitButton;

    @FindBy(css = "div[class='post-content__top'] h3")
    public WebElement editedTitleField;

    @FindBy(css = ".post__description")
    public WebElement editedDescription;

    @FindBy(css = ".post-content__body")
    public WebElement editedContent;

    @FindBy(css = "label[for='draftCheckbox']")
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

    public void clickOnDeleteButton() {deleteButton.click(); }
    public void clickOnEditButton() {editButton.click(); }
    public void clickOnEditPostSubmitButton() {editPostSubmitButton.click(); }
    public void clickOnSaveAsADraftSwitcher() {saveAsADraftSwitcher.click(); }


    public EditPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSaveAsADraftSwitcherEnabled() {
        // Проверка состояния переключателя
        return saveAsADraftSwitcher.getAttribute("checked") != null;
    }
}
