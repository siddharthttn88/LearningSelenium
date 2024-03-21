package seleniumAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Write a script to open the Firefox browser and open https://www.google.com/ URL.
public class Ques1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
    }
}
