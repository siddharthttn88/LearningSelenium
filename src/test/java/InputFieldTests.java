import com.aventstack.extentreports.Status;
import org.example.BaseLib;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class InputFieldTests extends BaseLib {

    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = EntryFillingDataProvider.class)
    void CheckEmailValidity(ArrayList<String> Person){
        WebDriver driver = getdriver();
        tests = reports.createTest("Enter Email Check Test");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement field = driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
        field.sendKeys(Person.get(3));
        Boolean is_valid = (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
        String message = (String) js.executeScript("return arguments[0].validationMessage;", field);
        System.out.println(message);
        field.clear();
        if(is_valid){
            tests.log(Status.PASS, "Test Passed");
            Assert.assertTrue(is_valid, "Invalid Email Input");
        }else {
            Assert.assertTrue(is_valid, "Invalid Email Input");
            tests.log(Status.FAIL, "Test Failed");
        }
    }
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = EntryFillingDataProvider.class)
    void CheckMobileNo(ArrayList<String> Person) throws InterruptedException {
        WebDriver driver = getdriver();
        tests = reports.createTest("Enter Phone Number Check Test");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement field = driver.findElement(By.xpath("//input[@ng-model='Phone']"));
        field.sendKeys(Person.get(4));
        Boolean is_valid = (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
        String message = (String) js.executeScript("return arguments[0].validationMessage;", field);
        System.out.println(message);
        field.clear();
        if(is_valid){
            tests.log(Status.PASS, "Test Passed");
            Assert.assertTrue(is_valid, "Failed");
        }else {
            Assert.assertTrue(is_valid, "Failed");
            tests.log(Status.FAIL, "Test Failed");
        }

       // tests.log(Status.FAIL, "Test Passed");
    }
    @Test(dataProvider = "ExcelDataProvider", dataProviderClass = EntryFillingDataProvider.class)
    void CheckPassword(ArrayList<String> Person) throws InterruptedException {
        WebDriver driver = getdriver();
        tests = reports.createTest("Enter Password Check Test");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement field = driver.findElement(By.xpath("//input[@id='firstpassword']"));
        field.sendKeys(Person.get(13));
        Boolean is_not_valid = (Boolean) js.executeScript("return arguments[0].checkValidity();", field);
        String message = (String) js.executeScript("return arguments[0].validationMessage;", field);
        System.out.println(message);
        field.submit();
        field.clear();
        if (is_not_valid){
            tests.log(Status.PASS, "Test Passed");
            Assert.assertFalse(is_not_valid, "Invalid Password Input");
        }else {
            Assert.assertFalse(is_not_valid, "Invalid Password Input");
            tests.log(Status.FAIL, "Test Failed");
        }

    }
}
