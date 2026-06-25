package tests;

import base.BaseTest;
import data.OrderData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;
import page.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String orderButtonPosition;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String rentalPeriod;
    private final String colour;
    private final String comment;

    public OrderTest(
            String orderButtonPosition,
            String name,
            String surname,
            String address,
            String metro,
            String phone,
            String date,
            String rentalPeriod,
            String colour,
            String comment
    ) {
        this.orderButtonPosition = orderButtonPosition;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Кнопка: {0}, Имя: {1}")
    public static Object[][] data() {
        return OrderData.data();
    }

    @Test
    public void orderScooterPositiveFlowTest() {
        MainPage main = new MainPage(driver);
        OrderPage order = new OrderPage(driver);

        // Открыть форму заказа
        if ("top".equals(orderButtonPosition)) {
            main.clickTopOrder();
        } else {
            main.clickBottomOrder();
        }

        // Заполнить данные клиента
        order.fillFirstStep(name, surname, address, metro, phone);

        // Заполнить параметры заказа
        order.fillSecondStep(date, rentalPeriod, colour, comment);

        // Оформить заказ
        order.clickOrderButton();
        order.confirmOrder();

        // Проверить успешное оформление заказа
        Assert.assertTrue(
                "Окно успешного оформления заказа не появилось",
                order.isOrderCreated()
        );
    }
}
