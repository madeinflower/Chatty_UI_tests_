package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends BasePage{
    public DraftsPage (WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='root']//p[1]")
    private WebElement draftTitle;

    public WebElement getDraftTitle() {
        return draftTitle;
    }
}
