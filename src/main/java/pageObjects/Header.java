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
    public WebElement chattyLogo;
    @FindBy(xpath = "//form[@class='form']")
    public WebElement loginForm;
    @FindBy(xpath = "//a[normalize-space()='Home']")
    public WebElement homeTab;
    @FindBy(xpath = "//a[normalize-space()='About']")
    public WebElement aboutTab;
    @FindBy(xpath = "//a[normalize-space()='Contact']")
    public WebElement contactTab;
    @FindBy(xpath = "//div[@class='header']//p[1]")
    public WebElement helloUsernameTab;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public WebElement logOutButton;
    @FindBy(xpath = "//a[normalize-space()='Your Profile']")
    public WebElement yourProfileButton;
    @FindBy(xpath = "//a[normalize-space()='My Drafts']")
    public WebElement myDraftsButton;

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
