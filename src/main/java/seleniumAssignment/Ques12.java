package seleniumAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Write an automation script for filling FirstName, LastName & Email address
// field with the help of name locator.
//(http://demo.automationtesting.in/Register.html)

public class Ques12 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Siddharth");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Sarkhel");
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Sample address");
        Thread.sleep(5000);
        driver.quit();
    }
}
