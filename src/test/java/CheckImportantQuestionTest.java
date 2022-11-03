import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.MainPage;

import java.util.ArrayList;
import java.util.List;

public class CheckImportantQuestionTest {

    private WebDriver driver;
    private final List<String> actualImportantResponses = new ArrayList<>();

    @Before
    public void setData() {
        actualImportantResponses.add("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        actualImportantResponses.add("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        actualImportantResponses.add("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        actualImportantResponses.add("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        actualImportantResponses.add("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        actualImportantResponses.add("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        actualImportantResponses.add("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        actualImportantResponses.add("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    @Test
    public void checkImportantQuestion() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        int count = mainPage.countNumberOfResponses();
        for (int i = 0; i < count; i++) {
            String result = mainPage.clickImportantQuestion(i);
            Assert.assertTrue(driver.findElement(By.xpath(result)).isDisplayed());
            Assert.assertEquals(driver.findElement(By.xpath(result + "//p")).getAttribute("textContent"), actualImportantResponses.get(i));
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
