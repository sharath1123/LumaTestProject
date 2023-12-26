package keywordsfile;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import dataProvider.configFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;




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
		public void JsClick(WebElement Element)
		{
			try
			{	
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click()", Element);
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
		
		public boolean VerifythePresenceOfElement(By Element)
		{
			try
			{	
				if(driver.findElements(Element).size() != 0){
					System.out.println("Element is Present");
					return true;
					}else{
					System.out.println("Element is Absent");
					return false;
					}
			}
			catch(Exception e)
	    	{
				
	    		e.printStackTrace();
	    		Assert.assertTrue(false);
	    		return false;
	    	
	    	}
		}
		public void highlight(WebElement Element) {
		    if (driver instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", Element);
		    
		}
		

			
		}
}
