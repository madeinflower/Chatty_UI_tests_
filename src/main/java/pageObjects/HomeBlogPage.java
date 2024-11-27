package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeBlogPage extends BasePage {
    public HomeBlogPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    public WebElement createPostButton;
    @FindBy(xpath = "//input[@placeholder='Title']")
    public WebElement titleInputField;
    @FindBy(xpath = "//input[@placeholder='Description']")
    public WebElement descriptionInputField;
    @FindBy(xpath = "//textarea[@placeholder='My thoughts. No more than 1000 characters']")
    public WebElement contentInputField;
    @FindBy(xpath = "//div[@class='post_uploaded_image__7qSWV']")
    public WebElement uploadImageField;
    @FindBy(xpath = "//input[@id='publishDate']")
    public WebElement publishDateField;
    @FindBy(xpath = "//label[normalize-space()='Save as a draft']")
    public WebElement saveAsDraftSwitcher;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/form/div[1]/p")
    public WebElement errorTitleMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/form/div[2]/p")
    public WebElement errorDescriptionMessage;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/form/div[3]/p")
    public WebElement errorContentMessage;
    @FindBy(xpath = "//p[normalize-space()='Please fill all fields']")
    public WebElement errorAllFieldsEmptyMessage;
    @FindBy(xpath = "//div[@id='root']//div[2]//h3")
    public WebElement firstPostTitle;
    @FindBy(xpath = "//div[@id='root']//div[2]//p")
    public WebElement firstPostDescription;
    @FindBy(xpath = "//div[@id='root']//div[@class='posts__section']/div[1]")
    public WebElement firstPostFrame;
    @FindBy(xpath = "//label[normalize-space()='My Posts']")
    public WebElement myPostsSwitcher;
    @FindBy(css = "a[class='menu-item '] span")
    public WebElement myDraftsOption;
    @FindBy(xpath = "//label[normalize-space()='Save as a draft']")
    public WebElement saveAsADraftSwitcher;

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
