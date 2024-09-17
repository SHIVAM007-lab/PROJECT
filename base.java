package BASE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class base {
	
	public static WebDriver driver;
	
	public WebDriver connect() throws IOException
	{
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\GURU\\src\\test\\resources\\data.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			String browser = prop.getProperty("browser");
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.driver.chrome", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe\\");
				driver = new ChromeDriver();
			}
			else if(browser.equals("ff"))
			{
				driver = new FirefoxDriver();
			}
				
			
			
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;

	}
	
	public void screenshot(String name)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\HP\\Pictures\\Screenshot\\"+name+".png");
		
		try {
			Files.copy(source, dest);
			System.out.println("screenshot taken");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
}
