package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Базовые методы для всех страниц
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        // Увеличенный таймаут для стабильности
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Стабильный клик (scroll + JS fallback)
    protected void click(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        // Прокрутка к элементу (важно для FAQ и кнопок)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            // fallback если элемент перекрыт
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    // Ввод текста
    protected void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    // Получение текста
    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}