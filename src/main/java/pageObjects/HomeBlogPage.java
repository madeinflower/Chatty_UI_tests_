package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeBlogPage extends BasePage {

    @FindBy(css = "span[data-test='post-header__plus']")
    public WebElement createPostButton;

    @FindBy(css = "input[placeholder='Title']")
    public WebElement titleInputField;

    @FindBy(css = "input[placeholder='Description']")
    public WebElement descriptionInputField;

    @FindBy(name = "content")
    public WebElement contentInputField;

    @FindBy(css = ".post_uploaded_image__7qSWV")
    public WebElement uploadImageField;

    @FindBy(xpath = "//input[@id='publishDate']")
    public WebElement publishDateField;

    @FindBy(css = "label[for='draftCheckbox']")
    public WebElement saveAsDraftSwitcher;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(css = "body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > p:nth-child(2)")
    public WebElement errorTitleMessage;

    @FindBy(css = "body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > p:nth-child(2)")
    public WebElement errorDescriptionMessage;

    @FindBy(css = "body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(3) > p:nth-child(2)")
    public WebElement errorContentMessage;

    @FindBy(xpath = "//p[normalize-space()='Please fill all fields']")
    public WebElement errorAllFieldsEmptyMessage;

    @FindBy(className = "post-content__top")
    public WebElement firstPostTitle;

    @FindBy(className = "post__description")
    public WebElement firstPostDescription;



//    private SelenideElement myPostsSwitcher = $("label[for='myPostsId']");
//    private SelenideElement saveAsADraftSwitcher = $("label[for='draftCheckbox']");
//    private SelenideElement myDraftsOption = $("a[class='menu-item '] span");
//    private SelenideElement firstPostTitle = $(byClassName("post-content__top"));
//    private SelenideElement firstPostDescription = $(byClassName("post__description"));
//    private SelenideElement createdPostTitleField = $(byClassName("post-content__top"));



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


    public HomeBlogPage (WebDriver driver) {
        super(driver);
    }
}
