package seleniumAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//Write a script launch the IE browser and open https://www.google.com/ URL
public class Ques2 {
    public static void main(String[] args) {
        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://www.google.com/");
    }
}
