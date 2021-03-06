import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class FirstTestngFile {
    public String baseUrl = "http://newtours.demoaut.com/";
    public WebDriver driver;
    public String expected = null;
    public String actual = null;
    String driverPath = "E:\\Dev\\geckodriver\\geckodriver.exe";

    @BeforeTest
    public void launchBrowser() {
        System.out.println("launching firefox browser");
//        System.setProperty("webdriver.firefox.marionette", driverPath);
        System.setProperty("webdriver.gecko.driver",  driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void verifyHomepageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 0)
    public void register() {
        driver.findElement(By.linkText("REGISTER")).click();
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void support() {
        driver.findElement(By.linkText("SUPPORT")).click();
        expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void goBackToHomepage() {
        driver.findElement(By.linkText("Home")).click();
    }

    @AfterTest
    public void terminateBrowser() {
        driver.close();
    }
}