package com.skcet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver1 = new ChromeDriver();
        WebDriver driver3 = new EdgeDriver();

        driver1.get("https://www.google.com");
        driver3.get("https://www.google.com");

        driver1.close();
        driver3.close();
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.shoppersstop.com/");
        driver.findElement(By.className("user-icon")).click();
    }
}