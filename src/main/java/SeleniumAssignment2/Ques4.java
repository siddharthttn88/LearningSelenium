package SeleniumAssignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Q4-Open this URL(https://demoqa.com/) and perform drag and drop, right-click using the Action class
public class Ques4 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/droppable");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        Actions action = new Actions(driver);
        action.scrollByAmount(0,290);
        WebElement from = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement to = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        action.dragAndDrop(from, to).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"droppable\"]/p[text() = 'Dropped!']")));
        action.contextClick(to).perform();
        driver.quit();
    }
}
