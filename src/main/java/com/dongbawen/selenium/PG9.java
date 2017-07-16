package com.dongbawen.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class PG9 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver",  "E:\\Dev\\geckodriver\\geckodriver.exe");
        String baseUrl = "http://116.52.0.144:8051/";
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);

        driver.findElement(By.linkText("文档上传")).click();

        WebElement uploadElement = driver.findElement(By.id("input-id"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("E:\\docs\\windows cmd命令应用.txt");

        // check the "I accept the terms of service" check box
        driver.findElement(By.cssSelector("a[title='上传选中文件']")).click();

        }
}