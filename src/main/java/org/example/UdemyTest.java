package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UdemyTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.udemy.com/");
        driver.findElement(By.xpath("//span[text()='Log in']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("siddharth");
    }
}
