package com.dongbawen.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PG5 {
    public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",  "E:\\Dev\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",  "E:\\Dev\\geckodriver\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver",  "E:\\Dev\\geckodriver\\IEDriverServer.exe");
		System.setProperty("webdriver.opera.driver",  "E:\\Dev\\geckodriver\\operadriver.exe");
		System.setProperty("phantomjs.binary.path",  "E:\\Dev\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://output.jsbin.com/usidix/1");
		WebElement button = driver.findElement(By.tagName("input"));
		button.click();

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);

		alert.accept();

		driver.close();
	}
}