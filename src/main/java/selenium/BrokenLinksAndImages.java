package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksAndImages {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		List<WebElement> linkslist=driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Size of all links & images "+linkslist.size());
		
		List<WebElement> Activelinks=new ArrayList<WebElement>();
		
		for(int i=0;i<linkslist.size();i++)
		{
			if(linkslist.get(i).getAttribute("href")!=null &&(!linkslist.get(i).getAttribute("href").contains("javascript")))
			{
				Activelinks.add(linkslist.get(i));
			}
				
		}
		System.out.println("Size of all active Links and images "+ Activelinks.size());
		
		for(int j=0;j<Activelinks.size();j++)
		{
			HttpURLConnection connection=(HttpURLConnection) new URL(Activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			System.out.println(Activelinks.get(j).getAttribute("href")+"----->"+response);
			
		}
	
		
	}

	
}
