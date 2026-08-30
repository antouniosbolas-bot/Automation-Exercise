package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }
    By ActualTitleLocator = By.xpath("//b[text()='Test Cases']");

    String ExpectedTitle = "Test cases";

    public String getExpectedTitle(){
        return ExpectedTitle.toUpperCase();
    }
    public String getActualTitle(){
       return driver.findElement(ActualTitleLocator).getText();
    }
}
