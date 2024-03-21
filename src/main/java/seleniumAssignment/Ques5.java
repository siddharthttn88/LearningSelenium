package seleniumAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Write a script to get the title of the “Contact Us” page.
public class Ques5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tothenew.com/contact-us");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
