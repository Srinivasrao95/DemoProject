package selenium;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
 
public class gmail {
 WebDriver driver ;
 @Test(priority =1, groups="title")
 public void f() {
	 System.setProperty("webdriver.chrome.driver","D:\\Selenium Drivers\\chromedriver.exe");
     String baseUrl = "https://www.google.com/";
         System.out.println("Launching Google Chrome browser"); 
         driver = new ChromeDriver();
         driver.get(baseUrl);
         String testTitle = "Google";
         String originalTitle = driver.getTitle();
         Assert.assertEquals(originalTitle, testTitle);
  }
 
 @AfterMethod
 public void teardown()
 {
	 driver.close(); 
 }
 
 
 @BeforeMethod
 public void beforeMethod() {
 System.out.println("Starting Test On Chrome Browser");
 }
}