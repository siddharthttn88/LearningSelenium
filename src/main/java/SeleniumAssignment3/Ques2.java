package SeleniumAssignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//Go to TTN website https://www.tothenew.com/ and verify the options under Services dropdown
public class Ques2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.tothenew.com/");
        Actions action = new Actions(driver);
        WebElement services = driver.findElement(By.xpath("(//a[@id=\"h-Services\"])[2]"));
        action.moveToElement(services).perform();
        String[] list = {"Digital Engineering", "Cloud & DevOps", "OTT Solutions & Services", "Data & Analytics", "CX & Content"};
        boolean flag = true;
        for(int i = 1 ; i < 6; i++){
            String cXpath = "(//div[@id=\"menu\"]/ul/li[2]/ul/li[" + i + "]/a)[2]";
            String item =driver.findElement(By.xpath(cXpath)).getText();
            if(!item.equals(list[i-1])){
                flag = false;
                break;
            }
        }
        System.out.println(flag);
        driver.quit();
    }
}
