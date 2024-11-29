import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import utils.RandomDataGenerator;

public class BaseTestAdmin {
    protected WebDriver driver;
    protected LoginPage loginPage;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://chatty.telran-edu.de:8089/login");
        driver.manage().window().maximize();
    }

    public void loginWithValidDataAdmin() {
        loginPage.inputEmail("tetiana.admin@gmail.com");
        loginPage.inputPassword("Qwerty12345admin");
        loginPage.submitForm();
    }

    public String getRandomName(int maxLength) {
        return RandomDataGenerator.generateRandomName(maxLength);
    }
    public String getRandomSurname(int maxLength) {
        return RandomDataGenerator.generateRandomSurname(maxLength);
    }
    public String getRandomPhoneNumber() {
        return RandomDataGenerator.generateRandomPhoneNumber();
    }
    public String getRandomString(int length) {
        return RandomDataGenerator.generateRandomString(length);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
