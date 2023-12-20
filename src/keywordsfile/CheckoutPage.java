package keywordsfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import objectRepository.ChechoutPageXpath;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutPage extends commonMethods{

	
	public void addShippingAddress()
	{
		try
		{
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement elementLocated = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.button_NewAddress));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", elementLocated);  
		WebElement Street =driver.findElement(objectRepository.ChechoutPageXpath.input_Street);
		Street.sendKeys("Maruthi Nagar");
		WebElement City =driver.findElement(objectRepository.ChechoutPageXpath.input_City);
		City.sendKeys("Hyderabad");
		WebElement dropdownCountry =driver.findElement(objectRepository.ChechoutPageXpath.dropdown_Country);
		dropdownCountry.click();
		Select Country = new Select(dropdownCountry);
		Country.selectByVisibleText("India");
		WebElement dropdownRegion =driver.findElement(objectRepository.ChechoutPageXpath.dropdown_region);
		dropdownRegion.click();
		Select Region = new Select(dropdownRegion);
		Region.selectByVisibleText("Telangana");
		WebElement Postcode =driver.findElement(objectRepository.ChechoutPageXpath.input_Postcode);
		Postcode.sendKeys("500058");
		WebElement Phone =driver.findElement(objectRepository.ChechoutPageXpath.input_Telephone);
		Phone.sendKeys("9177838718");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement button_shiphere =driver.findElement(objectRepository.ChechoutPageXpath.button_shiphere);
		button_shiphere.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement elementDetected = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.button_Next));
		WebElement RadioButton = driver.findElement(objectRepository.ChechoutPageXpath.radio_shippingMethod);											
        if(RadioButton.isSelected()) {					
            System.out.println("Radio button is Toggled On");					

        } else {			
            System.out.println("Radio button is Toggled Off");
            RadioButton.click();
        }
        elementDetected.click();
		
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	
	
	public void palceOrder()
	{
		try
		{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement BillingAddress = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.checkbox_BillingAdd));
        if(BillingAddress.isSelected()) {					
            System.out.println("Checkbox  is selected");					

        } else {			
            System.out.println("Checkbox  is  not selected");
    		executor.executeScript("arguments[0].click()", BillingAddress);  
        }
        WebElement elementLocated = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.button_palceOrder));
		executor.executeScript("arguments[0].click()", elementLocated); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	public void verifySuccessMessageAndcaptureOrder()
	{
		try
		{
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		WebElement text_Message = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.text_successMessage));
		String SuccessMessage = text_Message.getText();
		WebElement orderNumber = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.text_orderNumber));
		String purchaseOderNumber = orderNumber.getText();
		if(SuccessMessage.contains("Thank you for your purchase!"))
			Assert.assertTrue(true, "Order Purchase success and your order number is"+":"+purchaseOderNumber);
		else
			Assert.assertTrue(false, "Order Purchase failed");

		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
}

