package selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindows {

	public static void main(String[] args) {
		
			System.setProperty("webdriver.chrome.driver","D:\\Selenium Drivers\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.redbus.in/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
			driver.findElement(By.linkText("Help")).click();
		
		   Set<String> ids= driver.getWindowHandles();
		   Iterator<String> it=ids.iterator();
		   
		   String parentWindow=it.next();
		   String childwindow=it.next();
		   driver.switchTo().window(childwindow);
		   System.out.println(driver.getTitle());
		   driver.close();
		   driver.switchTo().window(parentWindow);
		   System.out.println(driver.getTitle());
		   driver.close();
	}

}
