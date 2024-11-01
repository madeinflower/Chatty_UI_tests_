import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LoginPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pageObjects.BasePage.wait;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("http://chatty.telran-edu.de:8089/login");
        driver.manage().window().maximize();
    }

    public void loginWithValidData() {
        loginPage.inputEmail("tatsenko.tetiana@gmail.com");
        loginPage.inputPassword("Qwerty12345");
        loginPage.submitForm();
    }

    public String generateRandomName(int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength) + 3;  // Генерация длины имени от 3 до maxLength
        StringBuilder name = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char letter = (char) ('a' + random.nextInt(26));  // Генерация случайной буквы от 'a' до 'z'
            name.append(letter);
        }
        return name.toString();
    }

    public String generateRandomSurname(int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength) + 3;  // Генерация длины фамилии от 3 до maxLength
        StringBuilder surname = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char letter = (char) ('a' + random.nextInt(26));  // Генерация случайной буквы от 'a' до 'z'
            surname.append(letter);
        }
        return surname.toString();
    }

    public String generateRandomPhoneNumber() {
        // Генерация случайного номера телефона в пределах от 10000000000 до 99999999999
        long randomNumber = ThreadLocalRandom.current().nextLong(10000000000L, 100000000000L);
        return String.valueOf(randomNumber);
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

//    public static String generateRandomDate() {
//        Random random = new Random();
//
//        // Генерируем случайный год между 1950 и 2005
//        int year = random.nextInt(2005 - 1950 + 1) + 1950;
//
//        // Генерируем случайный месяц (от 1 до 12)
//        int month = random.nextInt(12) + 1;
//
//        // Генерируем случайный день в зависимости от месяца
//        int day;
//        if (month == 2) {  // для февраля
//            day = random.nextInt(28) + 1;
//        } else if (month == 4 || month == 6 || month == 9 || month == 11) {  // месяцы с 30 днями
//            day = random.nextInt(30) + 1;
//        } else {  // месяцы с 31 днём
//            day = random.nextInt(31) + 1;
//        }
//
//        // Форматируем дату в нужном формате ДД/ММ/ГГ
//        LocalDate randomLocalDate = LocalDate.of(year, month, day);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
//        return randomLocalDate.format(formatter);
//    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

