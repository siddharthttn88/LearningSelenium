package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class timesheet {
    public static void main(String[] args) {
        WebDriver driver =  new ChromeDriver();
        driver.get("https://timesheet.tothenew.com/");
    }
}
