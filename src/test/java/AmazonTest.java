import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.*;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class AmazonTest {
    public WebDriver driver;
    @BeforeClass
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--window-size=1280,800");
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
    }

    @Test
    public void ValidatingDeliveryLocationCity(){
        WebElement location = driver.findElement(By.xpath("//span[@id=\"glow-ingress-line1\"]"));
        Assert.assertTrue(location.getText().split(" ")[2].equals("Noida"), "Not set to Noida");
    }
    @Test
    public void ValidatingDeliveryLocationPIN(){
        WebElement location = driver.findElement(By.xpath("//span[@id=\"glow-ingress-line1\"]"));
        Assert.assertTrue(location.getText().split(" ")[3].equals("110091"),"Not TO THE NEW PIN");
    }
    @Test
    public void ValidatingSearchResult(){
        WebElement searchBar = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBar.sendKeys("Ikigai");
        searchBar.submit();
        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]"));
        Assert.assertTrue(searchResult.getText().equals("\"Ikigai\""), "Not Got What we searched for!");
    }
    @Test
    public void ValidatingCartItemsIsZero(){
        WebElement cart = driver.findElement(By.xpath("//span[@id=\"nav-cart-count\"]"));
        Assert.assertTrue(cart.getText().equals("0"));
    }
    @Test(priority = 1)
    public void AddingItemInCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String originalWindow = driver.getWindowHandle();

        WebElement searchBar = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBar.clear();
        searchBar.sendKeys("Samsung S24");
        searchBar.submit();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div"))));
        //Click the link which opens in a new window
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div")).click();
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
        js.executeScript("window.scrollBy(0,300);");
        driver.findElement(By.xpath("(//input[@id=\"add-to-cart-button\"])[2]")).click();
        Thread.sleep(3000);
        WebElement text = driver.findElement(By.xpath("//*[@id=\"attachDisplayAddBaseAlert\"]/div/h4"));
        Assert.assertTrue(text.getText().equals("Added to Cart"));
    }
    @AfterClass
    void terminateBrowser(){
        driver.quit();
    }



}
