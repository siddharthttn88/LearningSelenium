package seleniumAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ques3 {
    public static void main(String[] args) throws InterruptedException {
        //Write a script to search the “To The New” string in google.
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("textarea.gLFyf")).sendKeys("To The New");
        driver.findElement(By.cssSelector("textarea.gLFyf")).sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        driver.quit();
    }
}
