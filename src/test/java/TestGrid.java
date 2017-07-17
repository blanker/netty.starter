import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by blank on 2017/7/17.
 */
public class TestGrid {

    WebDriver webDriver;
    String baseUrl, nodeUrl;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseUrl = "http://newtours.demoaut.com";
        nodeUrl = "http://localhost:5566/wd/hub";
        String driverPath = "E:\\Dev\\geckodriver\\geckodriver.exe";

        System.setProperty("webdriver.gecko.driver",  driverPath);

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setBrowserName("firefox");
        desiredCapabilities.setPlatform(Platform.WIN8_1);


        webDriver = new RemoteWebDriver(new URL(nodeUrl), desiredCapabilities);
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }

    @Test
    public void simpleTest(){
        webDriver.get(baseUrl);
        System.out.println(webDriver.getTitle());
    }

}
