package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeBlogPage extends BasePage {
    public HomeBlogPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    private WebElement createPostButton;
    @FindBy(xpath = "//input[@placeholder='Title']")
    private WebElement titleInputField;
    @FindBy(xpath = "//input[@placeholder='Description']")
    private WebElement descriptionInputField;
    @FindBy(xpath = "//textarea[@placeholder='My thoughts. No more than 1000 characters']")
    private WebElement contentInputField;
    @FindBy(xpath = "//div[@class='post_uploaded_image__7qSWV']")
    private WebElement uploadImageField;
    @FindBy(xpath = "//input[@id='publishDate']")
    private WebElement publishDateField;
    @FindBy(xpath = "//label[normalize-space()='Save as a draft']")
    private WebElement saveAsDraftSwitcher;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/form/div[1]/p")
    private WebElement errorTitleMessage;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/form/div[2]/p")
    private WebElement errorDescriptionMessage;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/form/div[3]/p")
    private WebElement errorContentMessage;
    @FindBy(xpath = "//p[normalize-space()='Please fill all fields']")
    private WebElement errorAllFieldsEmptyMessage;
    @FindBy(xpath = "//div[@id='root']//div[2]//h3")
    private WebElement firstPostTitle;
    @FindBy(xpath = "//div[@id='root']//div[2]//p")
    private WebElement firstPostDescription;
    @FindBy(xpath = "//div[@id='root']//div[@class='posts__section']/div[1]")
    private WebElement firstPostFrame;
    @FindBy(xpath = "//label[normalize-space()='My Posts']")
    private WebElement myPostsSwitcher;
    @FindBy(css = "a[class='menu-item '] span")
    private WebElement myDraftsOption;
    @FindBy(xpath = "//label[normalize-space()='Save as a draft']")
    private WebElement saveAsADraftSwitcher;

    public WebElement getCreatePostButton() {
        return createPostButton;
    }

    public WebElement getTitleInputField() {
        return titleInputField;
    }

    public WebElement getDescriptionInputField() {
        return descriptionInputField;
    }

    public WebElement getContentInputField() {
        return contentInputField;
    }

    public WebElement getUploadImageField() {
        return uploadImageField;
    }

    public WebElement getPublishDateField() {
        return publishDateField;
    }

    public WebElement getSaveAsDraftSwitcher() {
        return saveAsDraftSwitcher;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getErrorTitleMessage() {
        return errorTitleMessage;
    }

    public WebElement getErrorDescriptionMessage() {
        return errorDescriptionMessage;
    }

    public WebElement getErrorContentMessage() {
        return errorContentMessage;
    }

    public WebElement getErrorAllFieldsEmptyMessage() {
        return errorAllFieldsEmptyMessage;
    }

    public WebElement getFirstPostTitle() {
        return firstPostTitle;
    }

    public WebElement getFirstPostDescription() {
        return firstPostDescription;
    }

    public WebElement getFirstPostFrame() {
        return firstPostFrame;
    }

    public WebElement getMyPostsSwitcher() {
        return myPostsSwitcher;
    }

    public WebElement getMyDraftsOption() {
        return myDraftsOption;
    }

    public WebElement getSaveAsADraftSwitcher() {
        return saveAsADraftSwitcher;
    }

    public void enterTitle(String titleValue) {
        titleInputField.sendKeys(titleValue);
    }
    public void enterDescription(String descriptionValue) {
        descriptionInputField.sendKeys(descriptionValue);
    }
    public void enterContent(String contentValue) {
        contentInputField.sendKeys(contentValue);
    }

    public void clickOnCreatePostButton() {
        createPostButton.click();
    }
    public void clickOnSubmitButton() {
        submitButton.click();
    }
    public void clickOnSaveAsDraftSwitcher() {
        saveAsDraftSwitcher.click();
    }
    public void clickOnMyDraftsOption() {
        myDraftsOption.click();
    }
    public void clickOnMyPostSwitcher() {
        myPostsSwitcher.click();
    }
    public void clickOnSaveAsADraftSwitcher() {
        saveAsADraftSwitcher.click();
    }
}
