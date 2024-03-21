import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.*;

public class TestWeb {
    public WebDriver driver;
    @BeforeTest
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://demo.automationtesting.in/Register.html");
    }

    @Test
    public void ValidatingHeaderText(){
        Assert.assertEquals(driver.findElement(By.xpath("//div[@align='center']/h1")).getText(), "Automation Demo Site");
    }
    @Test
    public void ValidatingTitleText(){
        Assert.assertEquals( driver.getTitle(), "Register");
    }
    @Test
    public void ValidatingGender(){
        WebElement radio = driver.findElement(By.xpath("//input[@value='Male']"));
        radio.click();
        Assert.assertTrue(radio.isSelected());
    }
    @AfterTest
    void terminateBrowser(){
        driver.quit();
    }



}
