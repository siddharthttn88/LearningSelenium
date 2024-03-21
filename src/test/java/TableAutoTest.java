import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TableAutoTest {
    public WebDriver driver;
    @BeforeTest
    void loadBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/web-table-element.php");
    }
    @Test
    void HeadRowValidation(){
        List<WebElement> head = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead"));
        head.get(0).getText();
        Assert.assertEquals(head.get(0).getText(), "Company");
    }
}
