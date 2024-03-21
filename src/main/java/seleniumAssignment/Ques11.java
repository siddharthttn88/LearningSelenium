package seleniumAssignment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import  org.openqa.selenium.WebElement;

public class Ques11 {
    WebDriver driver = new ChromeDriver();
    public String validateHeader(){
        driver.get("http://demo.automationtesting.in/Register.html");
        String text = driver.findElement(By.xpath("//div[@align='center']/h1")).getText();
        driver.quit();
        return text;
    }
    public String validateTitle(){
        driver.get("http://demo.automationtesting.in/Register.html");
        String title= driver.getTitle();
        driver.quit();
        return title;
    }
    public boolean validateGender(){
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.findElement(By.xpath("//input[@value='Male']")).click();
        boolean r = driver.findElement(By.xpath("//input[@value='Male']")).isSelected();
        driver.quit();
        return r;
    }

}