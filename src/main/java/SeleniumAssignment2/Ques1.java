package SeleniumAssignment2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Q1- Launch Firefox browser & navigate to https://rahulshettyacademy.com/AutomationPractice/
//Try to Fetch the alert popup text.
//Try to Dismiss the popup.
//Try to enter some data on an alert popup.
//Try to accept the popup.
public class Ques1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id=\"alertbtn\"]")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text : "+alert.getText());
        alert.dismiss();
        driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Siddharth");
        driver.findElement(By.xpath("//input[@id=\"confirmbtn\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.quit();
    }
}
