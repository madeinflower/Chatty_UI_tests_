import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.Header;
import pageObjects.UserProfilePage;

public class HeaderTests extends BaseTestUser {
    private Header header;
    private UserProfilePage userProfilePage;

    @BeforeEach
    public void setUpTest() {
        loginWithValidDataUser();  // Вынесенный метод логина
        header = new Header(driver);  // Инициализация заголовка
    }

    @Test
    public void navigationToPersonalBlogPageUsingHomeTab() {
        header.verifyChattyLogoIsDisplayed();
        header.hoverOverHomeTab();
        header.assertElementIsDisplayed(header.chattyLogo);
    }

    @Test
    public void navigationToPersonalBlogPageUsingAboutTab() {
        header.verifyChattyLogoIsDisplayed();
        header.hoverOverAboutTab();
        header.assertElementIsDisplayed(header.chattyLogo);
    }

    @Test
    public void navigationToPersonalBlogPageUsingContactTab() {
        header.verifyChattyLogoIsDisplayed();
        header.hoverOverContactTab();
        header.assertElementIsDisplayed(header.chattyLogo);
    }


    @Test
    public void accessToProfileNavigationOptionsUsingHelloUserNameTab() {
        header.waitForVisibility(header.helloUsernameTab);
        header.hoverOverHelloUsernameTab();
        header.assertElementIsDisplayed(header.yourProfileButton);
        header.assertElementIsDisplayed(header.myDraftsButton);
        header.assertElementIsDisplayed(header.logOutButton);
    }

    @Test
    public void navigationToProfilePageFromYourProfileButton() {
        header.waitForVisibility(header.helloUsernameTab);
        header.hoverOverHelloUsernameTab();
        header.yourProfileButton.click();
        userProfilePage = new UserProfilePage(driver);
        header.waitForVisibility(userProfilePage.profileEmailIcon);
        header.assertElementIsDisplayed(userProfilePage.profileEmailIcon);
    }
}
