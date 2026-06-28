package rules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Управляет запуском и закрытием браузера
public class FactoryDriver extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() {

        return driver;
    }

    // Выбор браузера
    private void initDriver() {
        String browser = System.getProperty("browser");

        if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @Override
    protected void before() {
        initDriver();
    }

    @Override
    protected void after() {
        if (driver != null) {
            driver.quit(); // Обязательно закрываем браузер
        }
    }
}