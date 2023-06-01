package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Naukri {
    WebDriver driver;
    

    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void delCookie()
    {
        driver.get("https://www.naukri.com/");

        Assert.assertTrue(driver.getTitle().contains("Jobs"),"Title not matched");

        WebElement login = driver.findElement(By.xpath("//a[@title='Jobseeker Login']"));

        login.click();

        WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder,'Email ID')]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(email));

        email.sendKeys("faheemshaik125@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'password')]"));

        password.sendKeys("Faheem@12");

        WebElement submit = driver.findElement(By.xpath("//button[text()='Login']"));

        submit.click();

        driver.manage().deleteCookieNamed("nauk_at");

        driver.navigate().refresh();

        //Assert.assertEquals(driver.getTitle().contains("Login's"),true);

    }

    @Test
    public void delAllCookie()
    {
        driver.get("https://www.naukri.com/");

        Assert.assertTrue(driver.getTitle().contains("Jobs"),"Title not matched");

        WebElement login = driver.findElement(By.xpath("//a[@title='Jobseeker Login']"));

        login.click();

        WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder,'Email ID')]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(email));

        email.sendKeys("faheemshaik125@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'password')]"));

        password.sendKeys("Faheem@12");

        WebElement submit = driver.findElement(By.xpath("//button[text()='Login']"));

        submit.click();

        driver.manage().deleteAllCookies();

        driver.navigate().refresh();

        //Assert.assertEquals(driver.getTitle().contains("Login's"),true);

    }

    @Test
    public void editCookie()
    {
        driver.get("https://www.naukri.com/");

        Assert.assertTrue(driver.getTitle().contains("Jobs"),"Title not matched");

        WebElement login = driver.findElement(By.xpath("//a[@title='Jobseeker Login']"));

        login.click();

        WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder,'Email ID')]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(email));

        email.sendKeys("faheemshaik125@gmail.com");


        WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'password')]"));

        password.sendKeys("Faheem@12");

        WebElement submit = driver.findElement(By.xpath("//button[text()='Login']"));

        submit.click();

        driver.manage().addCookie(new Cookie("nauk_at","faheem"));
    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
