package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {
    public static void main(String[] args) {
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.xpath("(//span[@class='lbl_input appendBottom10'])[3]")).click();
        driver.findElement(By.xpath("(//div[@class='dateInnerCell']/p[text() = '5'])[1]")).click();
        driver.findElement(By.xpath("(//span[@class='lbl_input appendBottom10'])[4]")).click();
        driver.findElement(By.xpath("(//div[@class='dateInnerCell']/p[text() = '10'])[1]")).click();
    }
}
