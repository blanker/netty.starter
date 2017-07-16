import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by blank on 2017/7/16.
 */
public class FirstTestNGApp {

    public String baseUrl = "http://newtours.demoaut.com/";
    String driverPath = "E:\\Dev\\geckodriver\\geckodriver.exe";
    public WebDriver driver ;

    @Test
    public void testHomePageTitle(){
        System.out.println("launching firefox browser");
        System.setProperty("webdriver.gecko.driver",  driverPath);
        //System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }
}
