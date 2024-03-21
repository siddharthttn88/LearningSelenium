package SeleniumAssignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Integer.MAX_VALUE;

//Go to TTN website https://www.tothenew.com/ and perform all scrolling operations.
public class Ques4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tothenew.com/");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        //js.executeScript("window.scrollBy(0, 400);"); //Scroll By Pixel
//        js.executeScript("window.scrollBy(0, 4000);");
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"block-views-block-related-success-stories-block-5\"]/div/div/div/div[1]/div/div"));
        action.moveToElement(element).perform(); //Scroll to an element
        Thread.sleep(3000);
        action.scrollByAmount(0, -1000).perform(); //Scroll Back to top
        Thread.sleep(3000);
        action.scrollByAmount(0,490).perform(); //Scroll by amount
        Thread.sleep(3000);
        action.scrollByAmount(0, -1000).perform(); //Scroll Back to top
        Thread.sleep(3000);
        action.scrollByAmount(0, MAX_VALUE).perform(); //Scroll to the end of page
        Thread.sleep(3000);
        driver.quit();
    }
}
