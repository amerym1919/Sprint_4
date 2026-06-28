package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Страница оформления заказа
public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    // Поле «Имя»
    private final By name = By.xpath("//input[@placeholder='* Имя']");
    // Поле «Фамилия»
    private final By lastName = By.xpath("//input[@placeholder='* Фамилия']");
    // Поле «Адрес: куда привезти заказ»
    private final By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле выбора станции метро
    private final By metroInput = By.className("select-search__input");
    // Поле «Телефон»
    private final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка «Далее»
    private final By next = By.xpath("//button[text()='Далее']");

    // Поле «Когда привезти самокат»
    private final By dateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Выпадающий список срока аренды
    private final By rentalPeriodDropdown = By.className("Dropdown-placeholder");
    // Чекбокс цвета «чёрный жемчуг»
    private final By blackColourCheckbox = By.id("black");
    // Чекбокс цвета «серая безысходность»
    private final By greyColourCheckbox = By.id("grey");
    // Поле «Комментарий для курьера»
    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // Кнопка «Заказать» в форме заказа
    private final By orderBtn = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");
    // Кнопка подтверждения «Да»
    private final By yesBtn = By.xpath("//button[text()='Да']");

    // Всплывающее окно успешного оформления заказа
    private final By successPopup = By.xpath("//div[contains(@class,'Order_Modal')]");
    // Текст успешного оформления заказа
    private final By successText = By.xpath("//*[contains(text(),'Заказ оформлен')]");

    public void fillFirstStep(String n, String ln, String addr, String metro, String ph) {
        type(name, n);
        type(lastName, ln);
        type(address, addr);
        selectMetro(metro);
        type(phone, ph);
        click(next);
    }

    public void selectMetro(String metro) {
        click(metroInput);
        type(metroInput, metro);
        By metroOption = By.xpath("//div[contains(@class,'select-search__select')]//*[text()='" + metro + "']");
        click(metroOption);
    }

    public void fillSecondStep(String date, String rentalPeriod, String colour, String comment) {
        type(dateInput, date);
        driver.findElement(dateInput).sendKeys(Keys.ENTER);

        click(rentalPeriodDropdown);
        By rentalOption = By.xpath("//div[contains(@class,'Dropdown-option') and text()='" + rentalPeriod + "']");
        click(rentalOption);

        if ("black".equals(colour)) {
            click(blackColourCheckbox);
        } else {
            click(greyColourCheckbox);
        }

        type(commentInput, comment);
    }

    public void clickOrderButton() {
        click(orderBtn);
    }

    public void confirmOrder() {
        click(yesBtn);
    }

    public boolean isOrderCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successPopup));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successText)).isDisplayed();
    }
}
