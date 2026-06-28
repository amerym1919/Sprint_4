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
    private final By firstQuestion = By.id("accordion__heading-0");
    // Ответ на первый вопрос FAQ
    private final By firstAnswer = By.id("accordion__panel-0");

    // Заголовок второго вопроса FAQ
    private final By secondQuestion = By.id("accordion__heading-1");
    // Ответ на второй вопрос FAQ
    private final By secondAnswer = By.id("accordion__panel-1");

    // Заголовок третьего вопроса FAQ
    private final By thirdQuestion = By.id("accordion__heading-2");
    // Ответ на третий вопрос FAQ
    private final By thirdAnswer = By.id("accordion__panel-2");

    // Заголовок четвертого вопроса FAQ
    private final By fourthQuestion = By.id("accordion__heading-3");
    // Ответ на четвертый вопрос FAQ
    private final By fourthAnswer = By.id("accordion__panel-3");

    // Заголовок пятого вопроса FAQ
    private final By fifthQuestion = By.id("accordion__heading-4");
    // Ответ на пятый вопрос FAQ
    private final By fifthAnswer = By.id("accordion__panel-4");

    // Заголовок шестого вопроса FAQ
    private final By sixthQuestion = By.id("accordion__heading-5");
    // Ответ на шестой вопрос FAQ
    private final By sixthAnswer = By.id("accordion__panel-5");

    // Заголовок седьмого вопроса FAQ
    private final By seventhQuestion = By.id("accordion__heading-6");
    // Ответ на седьмой вопрос FAQ
    private final By seventhAnswer = By.id("accordion__panel-6");

    // Заголовок восьмого вопроса FAQ
    private final By eighthQuestion = By.id("accordion__heading-7");
    // Ответ на восьмой вопрос FAQ
    private final By eighthAnswer = By.id("accordion__panel-7");

    public void clickTopOrder() {
        click(orderTop);
    }

    public void clickBottomOrder() {
        click(orderBottom);
    }

    public void clickFaq(int index) {
        By[] faq = {firstQuestion,
                secondQuestion,
                thirdQuestion,
                fourthQuestion,
                fifthQuestion,
                sixthQuestion,
                seventhQuestion,
                eighthQuestion};
        click(faq[index]);
    }

    public String getFaqText(int index) {
        By[] ans = {firstAnswer,
                secondAnswer,
                thirdAnswer,
                fourthAnswer,
                fifthAnswer,
                sixthAnswer,
                seventhAnswer,
                eighthAnswer};
        return getText(ans[index]);
    }
}
