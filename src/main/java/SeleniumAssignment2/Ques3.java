package SeleniumAssignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Ques3 {
    public static void main(String[] args) {
        WebDriver driver =  new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.amazon.in/");
        WebElement location = driver.findElement(By.xpath("//span[@id=\"glow-ingress-line1\"]"));
        System.out.println(location.getText().split(" ")[3].equals("110091"));
        System.out.println(location.getText().split(" ")[2].equals("Noida"));
        WebElement searchBar = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBar.sendKeys("Ikigai");
        searchBar.submit();
        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]"));
        System.out.println(searchResult.getText().equals("\"Ikigai\""));
        System.out.println(driver.findElement(By.xpath("//span[@id=\"nav-cart-count\"]")).getText());
        driver.quit();
    }
}
