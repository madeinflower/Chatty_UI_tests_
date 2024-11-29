package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends BasePage{
    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='Logo']")
    private WebElement chattyLogo;
    @FindBy(xpath = "//form[@class='form']")
    private WebElement loginForm;
    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homeTab;
    @FindBy(xpath = "//a[normalize-space()='About']")
    private WebElement aboutTab;
    @FindBy(xpath = "//a[normalize-space()='Contact']")
    private WebElement contactTab;
    @FindBy(xpath = "//div[@class='header']//p[1]")
    private WebElement helloUsernameTab;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logOutButton;
    @FindBy(xpath = "//a[normalize-space()='Your Profile']")
    private WebElement yourProfileButton;
    @FindBy(xpath = "//a[normalize-space()='My Drafts']")
    private WebElement myDraftsButton;

    public WebElement getChattyLogo() {
        return chattyLogo;
    }

    public WebElement getLoginForm() {
        return loginForm;
    }

    public WebElement getHomeTab() {
        return homeTab;
    }

    public WebElement getAboutTab() {
        return aboutTab;
    }

    public WebElement getContactTab() {
        return contactTab;
    }

    public WebElement getHelloUsernameTab() {
        return helloUsernameTab;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public WebElement getYourProfileButton() {
        return yourProfileButton;
    }

    public WebElement getMyDraftsButton() {
        return myDraftsButton;
    }

    public void logout() {
        helloUsernameTab.isDisplayed();
        Actions actions = new Actions(driver);
        actions.moveToElement(helloUsernameTab).perform();
        wait.until(ExpectedConditions.visibilityOf(logOutButton));
        logOutButton.click();
        assertElementIsDisplayed(loginForm);
    }

    public void hoverOverHomeTab() {
        new Actions(driver).moveToElement(homeTab).perform();
    }
    public void hoverOverAboutTab() {
        new Actions(driver).moveToElement(aboutTab).perform();
    }
    public void hoverOverContactTab() {
        new Actions(driver).moveToElement(contactTab).perform();
    }
    public void hoverOverHelloUsernameTab() {
        new Actions(driver).moveToElement(helloUsernameTab).perform();
    }

    public void verifyChattyLogoIsDisplayed() {
        waitForVisibility(chattyLogo);
        assertElementIsDisplayed(chattyLogo);
    }
}
