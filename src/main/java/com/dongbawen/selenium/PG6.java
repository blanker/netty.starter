package com.dongbawen.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by blank on 2017/7/16.
 */
public class PG6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver",  "E:\\Dev\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver",  "E:\\Dev\\geckodriver\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver",  "E:\\Dev\\geckodriver\\IEDriverServer.exe");
        System.setProperty("webdriver.opera.driver",  "E:\\Dev\\geckodriver\\operadriver.exe");
        System.setProperty("phantomjs.binary.path",  "E:\\Dev\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://newtours.demoaut.com/mercuryregister.php");
        Select select = new Select(driver.findElement(By.name("country")));
        select.selectByVisibleText("CHINA");
    }
}
