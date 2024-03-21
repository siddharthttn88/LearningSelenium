package seleniumAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Write a script to open http://www.tothenew.com/  and then navigate to the contact us page using 1) XPath 2) ID
public class Ques4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.tothenew.com/");
        // Using XPath
        driver.findElement(By.xpath("(//a[text()='contact us'])[2]")).click();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(2000);
        // Using ID(Not possible because there are 2 tags with same id)
        driver.findElement(By.xpath("(//a[text()='contact us'])[2]")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
