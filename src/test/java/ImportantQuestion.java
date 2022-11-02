import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ImportantQuestion {

    private WebDriver driver;
    // локатор поля с вопросом
    private By importantQuestion = By.xpath(".//div[@data-accordion-component='AccordionItemButton']");

    public ImportantQuestion(WebDriver driver) {
        this.driver = driver;
    }

    public void clickImportantQuestion() throws InterruptedException {
        List<WebElement> elements = driver.findElements(importantQuestion);
        for (WebElement element : elements) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            element.click();
            Thread.sleep(1_000);
            driver.findElement(By.xpath(".//div[@aria-labelledby='" + element.getAttribute("id") + "']"));
        }
    }
}
