package com.dongbawen.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.*;

public class PG2 {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.gecko.driver",  "E:\\Dev\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver",  "E:\\Dev\\geckodriver\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver",  "E:\\Dev\\geckodriver\\IEDriverServer.exe");
        System.setProperty("webdriver.opera.driver",  "E:\\Dev\\geckodriver\\operadriver.exe");
        System.setProperty("phantomjs.binary.path",  "E:\\Dev\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

        WebDriver driver = null;
        //WebDriver driver = new FirefoxDriver();
    	driver = new PhantomJSDriver();
//        driver = new FirefoxDriver();

        String baseUrl = "http://116.52.0.144:8051/";
        String tagName = "";
        
        driver.get(baseUrl);
        System.out.println(driver.getPageSource());

        tagName = driver.findElement(By.id("input-keyword")).getTagName();
        System.out.println(tagName);
        WebElement element = driver.findElement(By.id("input-keyword-document"));

        tagName = element.getTagName();
        System.out.println(tagName);

        WebElement button = driver.findElement(By.id("btn-go-es"));
        tagName = button.getTagName();
        System.out.println(tagName);

        driver.findElement(By.linkText("文档上传")).click();

        Select select = new Select(driver.findElement(By.id("other_key")));
       select.selectByVisibleText("车辆");

        driver.manage().window().maximize();

        try (OutputStream out = new FileOutputStream("c:\\wget\\download\\2.png")) {
            OutputType<File> file = OutputType.FILE;
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, out);
        }

        PhantomJSDriver phantom = (PhantomJSDriver) driver;

        String title = (String)phantom.executePhantomJS("var page = this; return page.title;");
        System.out.println(title);
        // This line will server the purpose and will execute the required java script.
        String script = null;
        script = "var page = this; page.paperSize = {format: 'A4',orientation: 'portrait'};\n";
        //System.out.println(phantom.executePhantomJS(script));
        script += "page.render('c:\\\\wget\\\\download\\\\222222.pdf', {format: 'pdf', quality: '100'});\n";
        System.out.println(phantom.executePhantomJS(script));

        //driver.close();
        //System.exit(0);
}
}