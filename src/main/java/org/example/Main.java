package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/payment");



     /* WebElement ProductsPageLink = driver.findElement(By.xpath("//a[@href=\"/view_cart\"]"));
ProductsPageLink.click();*/
        // List<WebElement> Brands = driver.findElements(By.cssSelector(""))


    }
}