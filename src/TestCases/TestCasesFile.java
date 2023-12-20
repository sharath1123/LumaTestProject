package TestCases;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import keywordsfile.commonMethods;
import keywordsfile.CartPage;
import keywordsfile.HomePaage;
import keywordsfile.CheckoutPage;



public class TestCasesFile extends commonMethods {
	
	commonMethods object1 = new commonMethods();
	CartPage      object2 = new CartPage();
	HomePaage     object3 = new HomePaage();
	CheckoutPage  object4 = new CheckoutPage();
	
	
	
	@BeforeTest
	public void intitiateDriver() throws IOException
	{
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\shara\\eclipse-workspace\\driver\\chromedriver.exe");
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--remote-allow-origins=*");
		    driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        String url = properties.getProperty("ApplicationUrl");
	        driver.get(url);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        
	}
	        
	        @Test
			public void testcase1()
			{
				try
				{
				login();
				object3.selectWatchesOption();
				object3.filterMetal();
				object3.addItemtoCart();
				object2.addMoreQty();
				object2.editQuantity();
				object2.verifyQuantityandProceed();
				object4.addShippingAddress();
				object4.palceOrder();
				object4.verifySuccessMessageAndcaptureOrder();
				
				}
				catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
			}
	
	        @AfterTest
			public void quitChrome()
			{
				driver.quit();
			}
}
