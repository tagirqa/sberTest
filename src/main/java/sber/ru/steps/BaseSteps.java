package sber.ru.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sber.ru.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }
    public static WebDriverWait wait;



    public static void setUp(){
        Properties properties = TestProperties.getInstance().getProperties();

        String browser = properties.getProperty("browser", "opera");
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", "drivers/operadriver");
                driver = new OperaDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
        }



        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

        driver.get("https://www.sberbank.ru/ru/person");
    }

    public static void tearDown(){
        driver.quit();
    }
}

