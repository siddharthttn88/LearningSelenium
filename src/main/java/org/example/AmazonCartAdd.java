package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class AmazonCartAdd {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.amazon.in/");
        String originalWindow = driver.getWindowHandle();

        WebElement searchBar = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBar.sendKeys("Jewelry");
        searchBar.submit();

//Click the link which opens in a new window
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
//Wait for the new window or tab
        wait.until(numberOfWindowsToBe(2));

//Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200);");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
        WebElement text = driver.findElement(By.xpath("//*[@id=\"attachDisplayAddBaseAlert\"]/div/h4"));
        Thread.sleep(2000);
        System.out.println(text.getText());
        System.out.println(text.getText().equals("Added to Cart"));
        Thread.sleep(2000);
        driver.quit();

    }
}
