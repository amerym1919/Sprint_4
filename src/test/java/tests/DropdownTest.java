package tests;

import base.BaseTest;
import data.DropdownData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;

// Проверка раскрытия всех FAQ пунктов
@RunWith(Parameterized.class)
public class DropdownTest extends BaseTest {

    private final int index;
    private final String expected;

    public DropdownTest(int index, String expected) {
        this.index = index;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return DropdownData.data();
    }

    @Test
    public void faqTest() {

        MainPage main = new MainPage(driver);

        // Кликаем по вопросу
        main.clickFaq(index);

        // Получаем ответ
        String actual = main.getFaqText(index);

        // Проверяем полный текст ответа
        Assert.assertEquals(expected, actual);
    }
}