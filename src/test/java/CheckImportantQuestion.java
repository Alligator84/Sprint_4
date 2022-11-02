import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckImportantQuestion {

    private WebDriver driver;

    @Test
    public void checkImportantQuestion() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        Thread.sleep(10_000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ImportantQuestion importantQuestion = new ImportantQuestion(driver);
        importantQuestion.clickImportantQuestion();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
