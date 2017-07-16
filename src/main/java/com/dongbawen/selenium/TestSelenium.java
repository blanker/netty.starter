package com.dongbawen.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by blank on 2017/7/15.
 */
public class TestSelenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver",  "E:\\Dev\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver",  "E:\\Dev\\geckodriver\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver",  "E:\\Dev\\geckodriver\\IEDriverServer.exe");
        System.setProperty("webdriver.opera.driver",  "E:\\Dev\\geckodriver\\operadriver.exe");
        System.setProperty("phantomjs.binary.path",  "E:\\Dev\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        //System.setProperty("webdriver.edge.driver",  "E:\\Dev\\geckodriver\\chromedriver.exe");
        String url = "http://mail.qq.com";
        WebDriver webDriver;
        String title = null;

//        WebDriver webDriver = new FirefoxDriver();
//        webDriver.get(url);
//        String pageSource = webDriver.getPageSource();
//        System.out.println(pageSource);
//        webDriver.close();
//
//        webDriver = new ChromeDriver();
//        webDriver.get(url);
//        String title = webDriver.getTitle();
//        System.out.println(title);
//        webDriver.close();

//        webDriver = new HtmlUnitDriver();
//        webDriver.get(url);
//        title = webDriver.getTitle();
//        System.out.println(title);
//        webDriver.close();

        //webDriver = new InternetExplorerDriver();
//        webDriver = new OperaDriver();
       // webDriver = new SafariDriver();
        //webDriver = new RemoteWebDriver();
        webDriver = new PhantomJSDriver();
        webDriver.get(url);
        title = webDriver.getTitle();
        System.out.println(title);
        webDriver.close();
    }
}
