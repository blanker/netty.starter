package com.dongbawen.selenium;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class PG8 {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver",  "E:\\Dev\\geckodriver\\geckodriver.exe");
                String baseUrl = "http://demo.guru99.com/selenium/yahoo.html";
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);
        WebElement downloadButton = driver.findElement(By
        .id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P C:\\wget\\download --no-check-certificate " + sourceLocation;

        try {
        Process exec = Runtime.getRuntime().exec(wget_command);
        int exitVal = exec.waitFor();
        System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
        System.out.println(ex.toString());
        }
        driver.close();
        }
        
}