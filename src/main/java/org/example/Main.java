package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Siddharth");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Sarkhel");
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("678 Shanti Nagar");
        driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys("siddharth.sarkhel@tothenew.com");
        driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("7819004600");
        driver.findElement(By.xpath("//input[@value='Cricket']")).click();
        driver.findElement(By.xpath("//input[@value='Movies']")).click();
        driver.findElement(By.xpath("//input[@value='Male']")).click();
        driver.findElement(By.xpath("//div[@id='msdd']")).click();
        driver.findElement(By.linkText("English")).click(); // or //a[text() = 'English']
        driver.findElement(By.className("row")).click();

        Select drpSkills = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
        drpSkills.selectByVisibleText("Java");
        driver.findElement(By.className("row")).click();
        Select drpCountry = new Select(driver.findElement(By.xpath("//select[@id='countries']")));
        drpCountry.selectByVisibleText("Select Country");
        driver.findElement(By.xpath("//span[@class='select2-selection__arrow']")).click();
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("India");
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.RETURN);
        Select drpYear = new Select(driver.findElement(By.xpath("//select[@placeholder='Year']")));
        drpYear.selectByVisibleText("2002");
        Select drpMonth = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
        drpMonth.selectByValue("July");
        Select drpDay = new Select(driver.findElement(By.xpath("//select[@placeholder='Day']")));
        drpDay.selectByVisibleText("18");
        driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("Siddharth");
        driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("Siddharth");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//        WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(10));
       /* Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class); */
        Thread.sleep(10000);
        driver.quit();

    }
}