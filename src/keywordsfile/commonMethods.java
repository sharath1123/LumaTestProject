package keywordsfile;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import objectRepository.commonMethodsXpath;
import org.openqa.selenium.remote.DesiredCapabilities;
import dataProvider.configFileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import objectRepository.HomePageXpath;
import objectRepository.CartPageXpath;



public class commonMethods extends configFileReader{

		public  static WebDriver driver ;
		public  static WebDriverWait wait;
		
		
		public void login()
		{
			try
			{	
		    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement elementLocated = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign In")));
		    elementLocated.click();
		    WebElement text_username=driver.findElement(objectRepository.commonMethodsXpath.text_userName);
			WebElement text_Password=driver.findElement(objectRepository.commonMethodsXpath.text_Password);
			WebElement button_signIn=driver.findElement(objectRepository.HomePageXpath.button_signIn);
			String username = properties.getProperty("Username");
			String password = properties.getProperty("Password");
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			text_username.sendKeys(username);
			text_Password.sendKeys(password);
			button_signIn.click();
			
			}
			catch(Exception e)
	    	{
				
	    		e.printStackTrace();
	    		Assert.assertTrue(false);
	    	
	    	}
		}
		

		
		
		public void scrolldown()
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
		        driver.manage().window().maximize();	
		        js.executeScript("window.scrollBy(0,500)");
			}
			catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
		}
			
		}
