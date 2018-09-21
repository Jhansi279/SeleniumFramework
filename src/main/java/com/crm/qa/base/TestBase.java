package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver edriver;
	
	public TestBase()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\dontha\\Desktop\\madhu\\PracFramework\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public  void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dontha\\Desktop\\madhu\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			//Code for firefox
		}
		
		edriver = new EventFiringWebDriver(driver);
		//now, create an object of EventListenerHandler to register it with EventFiringWebDriver 
		eventListener = new WebEventListener();
		edriver.register(eventListener);
		driver = edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(9000,TimeUnit.MILLISECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	
}
