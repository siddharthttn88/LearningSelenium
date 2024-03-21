package SeleniumAssignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Q2- https://rahulshettyacademy.com/dropdownsPractise/
//Try to handle the radio button
//Try to handle dynamic dropdown
//Enter some date and passenger details and search for the flight booking from Delhi to Mumbai in a single trip
public class Ques2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =  new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_chk_StudentDiscount\"]")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        driver.findElement(By.xpath("(//a[@value='BOM'])[2]")).click();
        driver.findElement(By.xpath("//input[@id=\"autosuggest\"]")).sendKeys("India");
        driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_rbtnl_Trip_1\"]")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
        driver.findElement(By.xpath("(//a[text()='13'])[1]")).click();
        driver.findElement(By.xpath("(//input[@name='ctl00$mainContent$view_date2'])")).click();
        driver.findElement(By.xpath("(//a[text()='24'])[2]")).click();
        Select currencyDrp = new Select(driver.findElement(By.xpath("//select[@id=\"ctl00_mainContent_DropDownListCurrency\"]")));
        currencyDrp.selectByVisibleText("USD");
        driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_btn_FindFlights\"]")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
