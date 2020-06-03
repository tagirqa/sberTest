package sber.ru.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    public static WebDriverWait wait;

    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

        driver.get("https://www.sberbank.ru/ru/person");
    }

    public static void tearDown(){
        driver.quit();
    }
}
