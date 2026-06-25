package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Главная страница
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    // Верхняя кнопка «Заказать»
    private final By orderTop = By.xpath("//div[contains(@class,'Header_Nav')]//button[text()='Заказать']");

    // Нижняя кнопка «Заказать»
    private final By orderBottom = By.xpath("//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']");

    // Заголовок первого вопроса FAQ
    private final By faq0 = By.id("accordion__heading-0");
    // Ответ на первый вопрос FAQ
    private final By ans0 = By.id("accordion__panel-0");

    // Заголовок второго вопроса FAQ
    private final By faq1 = By.id("accordion__heading-1");
    // Ответ на второй вопрос FAQ
    private final By ans1 = By.id("accordion__panel-1");

    // Заголовок третьего вопроса FAQ
    private final By faq2 = By.id("accordion__heading-2");
    // Ответ на третий вопрос FAQ
    private final By ans2 = By.id("accordion__panel-2");

    // Заголовок четвертого вопроса FAQ
    private final By faq3 = By.id("accordion__heading-3");
    // Ответ на четвертый вопрос FAQ
    private final By ans3 = By.id("accordion__panel-3");

    // Заголовок пятого вопроса FAQ
    private final By faq4 = By.id("accordion__heading-4");
    // Ответ на пятый вопрос FAQ
    private final By ans4 = By.id("accordion__panel-4");

    // Заголовок шестого вопроса FAQ
    private final By faq5 = By.id("accordion__heading-5");
    // Ответ на шестой вопрос FAQ
    private final By ans5 = By.id("accordion__panel-5");

    // Заголовок седьмого вопроса FAQ
    private final By faq6 = By.id("accordion__heading-6");
    // Ответ на седьмой вопрос FAQ
    private final By ans6 = By.id("accordion__panel-6");

    // Заголовок восьмого вопроса FAQ
    private final By faq7 = By.id("accordion__heading-7");
    // Ответ на восьмой вопрос FAQ
    private final By ans7 = By.id("accordion__panel-7");

    public void clickTopOrder() {
        click(orderTop);
    }

    public void clickBottomOrder() {
        click(orderBottom);
    }

    public void clickFaq(int index) {
        By[] faq = {faq0, faq1, faq2, faq3, faq4, faq5, faq6, faq7};
        click(faq[index]);
    }

    public String getFaqText(int index) {
        By[] ans = {ans0, ans1, ans2, ans3, ans4, ans5, ans6, ans7};
        return getText(ans[index]);
    }
}
