package base;

import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import rules.FactoryDriver;

// Базовый класс тестов
public class BaseTest {

    @Rule
    public FactoryDriver factoryDriver = new FactoryDriver();

    protected WebDriver driver;

    @org.junit.Before
    public void setUp() {
        driver = factoryDriver.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
}