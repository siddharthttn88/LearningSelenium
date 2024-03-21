package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(String Browser){
        WebDriver driver = null;
        switch (Browser){
            case "chrome": driver = new ChromeDriver();
                break;
            case "firefox": driver = new FirefoxDriver();
                break;
            default: driver = new EdgeDriver();
        }
        return driver;
    }
}
