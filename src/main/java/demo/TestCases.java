package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Wait until page is loaded and logo is visible Using Locator "Tag Name" title= BookMyShow
        Thread.sleep(3000);
        // Locate all the recommended movie list Using Locator "XPath" //div[contains(@class,'style__WidgetContainerBody-sc-lnhrs7-4 YeNog')]//a
        List<WebElement> recommendedMovies = driver.findElements(By.xpath("//div[contains(@class,'style__WidgetContainerBody-sc-lnhrs7-4 YeNog')]//a"));
        for (WebElement movie : recommendedMovies) {
            String movieURL = movie.getAttribute("href");
            System.out.println(movieURL);
        }
        // Locate all the movies in premiere Using Locator "XPath" //h2[text()='Premieres']//ancestor::div[@class = 'sc-133848s-4 kFcBGr']//a[@class='sc-133848s-11 sc-lnhrs7-5 fHgWnO']
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        List<WebElement> premiereMovies = driver.findElements(By.xpath("//h2[text()='Premieres']//ancestor::div[@class = 'sc-133848s-4 kFcBGr']//a[@class='sc-133848s-11 sc-lnhrs7-5 fHgWnO']"));
        // fetch the 2nd index of above list  //h2[text()='Premieres']//ancestor::div[@class = 'sc-133848s-4 kFcBGr']//a[@class='sc-133848s-11 sc-lnhrs7-5 fHgWnO']
        WebElement secondMovie = premiereMovies.get(1);
        // Print name Using Locator "Class" Name sc-7o7nez-0 zDfcI
        System.out.println(secondMovie.findElement(By.className("sc-7o7nez-0 zDfcI")).getText());
        // Print language Using Locator "Class" Name sc-7o7nez-0 veMGd
        System.out.println(secondMovie.findElement(By.className("sc-7o7nez-0 veMGd")).getText());
    }


}
