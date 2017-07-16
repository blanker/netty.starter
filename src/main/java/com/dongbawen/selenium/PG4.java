package com.dongbawen.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class PG4 {
    public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",  "E:\\Dev\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",  "E:\\Dev\\geckodriver\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver",  "E:\\Dev\\geckodriver\\IEDriverServer.exe");
		System.setProperty("webdriver.opera.driver",  "E:\\Dev\\geckodriver\\operadriver.exe");
		System.setProperty("phantomjs.binary.path",  "E:\\Dev\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

		WebDriver driver = new FirefoxDriver();
	        driver.get("http://www.egs.gov.cn/info/nIndex.jsp?isSd=false&node_id=GKyc&cat_id=12740");
	        driver.switchTo().frame("rightFrame");

	        //driver.findElement(By.linkText("Deprecated")).click();
		List<WebElement> elements = driver.findElements(By.cssSelector("body > div > div.info > div.info-list > table > tbody > tr > td.tit > a"));
		elements.forEach( e -> {
			System.out.println(e.getText());
			String href = e.getAttribute("href");
			System.out.println(href);

			WebDriver webDriver = new FirefoxDriver();
			webDriver.get(href);
			String title = webDriver.getTitle();
			System.out.println(title);
		} );

		driver.close();
	    }
}