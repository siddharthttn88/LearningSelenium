package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Scanner;

public class BikeAutomation {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter bike name : ");
        String searchT = input.nextLine();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.bikewale.com/");
        WebElement search = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/header/div/div[2]/div[1]/div/div/div[1]/div/input"));
        search.sendKeys(searchT);
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/header/div/div[2]/div[1]/div/div/div[1]/div/div")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div[2]/div[1]/div[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[7]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[3]/div/img")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[7]/div[2]/div[1]/span")).click();
        Thread.sleep(500);
        String price = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div[2]/div[2]/div[1]/span")).getText();
        driver.quit();
        System.out.println(price + " in Delhi");
    }
}
