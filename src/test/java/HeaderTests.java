import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.Header;
import pageObjects.UserProfilePage;

public class HeaderTests extends BaseTestUser {
    private Header header;
    private UserProfilePage userProfilePage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidDataUser();
        header = new Header(driver);
    }

    @Test
    public void navigationToPersonalBlogPageUsingHomeTab() {
        header.verifyChattyLogoIsDisplayed();
        header.hoverOverHomeTab();
        header.assertElementIsDisplayed(header.getChattyLogo());
    }

    @Test
    public void navigationToPersonalBlogPageUsingAboutTab() {
        header.verifyChattyLogoIsDisplayed();
        header.hoverOverAboutTab();
        header.assertElementIsDisplayed(header.getChattyLogo());
    }

    @Test
    public void navigationToPersonalBlogPageUsingContactTab() {
        header.verifyChattyLogoIsDisplayed();
        header.hoverOverContactTab();
        header.assertElementIsDisplayed(header.getChattyLogo());
    }

    @Test
    public void accessToProfileNavigationOptionsUsingHelloUserNameTab() {
        header.waitForVisibility(header.getHelloUsernameTab());
        header.hoverOverHelloUsernameTab();
        header.assertElementIsDisplayed(header.getYourProfileButton());
        header.assertElementIsDisplayed(header.getMyDraftsButton());
        header.assertElementIsDisplayed(header.getLogOutButton());
    }

    @Test
    public void navigationToProfilePageFromYourProfileButton() {
        header.waitForVisibility(header.getHelloUsernameTab());
        header.hoverOverHelloUsernameTab();
        header.getYourProfileButton().click();
        userProfilePage = new UserProfilePage(driver);
        header.waitForVisibility(userProfilePage.getProfileEmailIcon());
        header.assertElementIsDisplayed(userProfilePage.getProfileEmailIcon());
    }
}
