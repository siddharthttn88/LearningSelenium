package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseLib {
    public static ExtentTest tests;
    public static ExtentReports reports;
    private WebDriver driver;

    @BeforeSuite
    void setupReport(){
        reports = new ExtentReports();
        ExtentSparkReporter report = new ExtentSparkReporter("ExtentReports/report.html");
        reports.attachReporter(report);
    }

    @Parameters({"browser", "url"})
    @BeforeClass
    public void StartBrowser(String Browser, String URL){
        driver = BrowserFactory.getBrowser(Browser);
        driver.manage().window().maximize();
        driver.get(URL);
    }
    @AfterClass
    public void TerminateBrowser(){
       driver.quit();
    }
    protected WebDriver getdriver(){
        if (driver == null){
            System.out.println("Driver null");
        }
        return driver;
    }
    @AfterSuite
    void closeReport(){
        reports.flush();
    }
}
