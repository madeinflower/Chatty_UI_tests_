package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends BasePage{


    @FindBy(css = "div[class='draft__posts'] div:nth-child(1) div:nth-child(2) div:nth-child(2) h3:nth-child(1)")
    public WebElement draftTitle;




    public DraftsPage (WebDriver driver) {
        super(driver);
    }
}
