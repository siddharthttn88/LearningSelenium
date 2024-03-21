package SeleniumAssignment3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Ques3 {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");
        WebElement subBtn = driver.findElement(By.xpath("//*[@id=\"p2u-travel-companion-wrap\"]/div/div[1]/div/div[1]/div[1]/h2"));
        Actions action = new Actions(driver);
        action.moveToElement(subBtn).perform();
        driver.findElement(By.xpath("//input[@id=\"form-field-travel_from\"]")).sendKeys("Delhi");
        driver.findElement(By.xpath("//input[@id=\"form-field-travel_to\"]")).sendKeys("Kolkata");
        Select pnWeek = new Select(driver.findElement(By.xpath("//select[@id=\"form-field-travel_comp_date_between\"]")));
        pnWeek.selectByIndex(2);
        Select airLine = new Select(driver.findElement(By.xpath("//select[@id=\"form-field-travel_comp_airline\"]")));
        airLine.selectByVisibleText("Continental Airlines");
        Select lang = new Select(driver.findElement(By.xpath("//select[@id=\"form-field-travel_comp_language\"]")));
        lang.selectByVisibleText("English");
        driver.findElement(By.xpath("//input[@id=\"form-field-travel_comp_date\"]")).click();
        driver.findElement(By.xpath("//span[@aria-label='February 29, 2024']")).click();
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        //Saving the screenshot in desired location
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        //Path to the location to save screenshot
        FileUtils.copyFile(source, new File("./SeleniumScreenshots/Screen.png"));
        driver.findElement(By.xpath("//*[@id=\"travel_comp_form\"]/div/div[12]/button/span/span[2]")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}