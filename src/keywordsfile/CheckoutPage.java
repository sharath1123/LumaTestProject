package keywordsfile;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutPage extends commonMethods{
	commonMethods object = new commonMethods();
	public void addShippingAddress()
	{
		try
		{
	    wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		boolean shippingAddressPresent = object.VerifythePresenceOfElement(objectRepository.ChechoutPageXpath.shippingAddress);
		if(shippingAddressPresent)
		{
			WebElement button_Next = wait.until(ExpectedConditions.elementToBeClickable(objectRepository.ChechoutPageXpath.button_Next));
	        object.JsClick(button_Next);
	    
		}
		else
		{
		addAddress();
		WebElement RadioButton = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.radio_shippingMethod));							
        if(RadioButton.isSelected()) {					
            System.out.println("Radio button is Toggled On");					

        } else {			
            System.out.println("Radio button is Toggled Off");
            object.JsClick(RadioButton);
        }
        WebElement button_Next = wait.until(ExpectedConditions.elementToBeClickable(objectRepository.ChechoutPageXpath.button_Next));
        object.JsClick(button_Next);
		}
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	
	public void addNewAddress()
	{
		try
		{
			WebElement elementLocated = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.button_NewAddress));
			object.JsClick(elementLocated);
			addAddress();
			WebElement RadioButton = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.radio_shippingMethod));							
	        if(RadioButton.isSelected()) {					
	            System.out.println("Radio button is Toggled On");					

	        } else {			
	            System.out.println("Radio button is Toggled Off");
	            object.JsClick(RadioButton);
	        }
	        WebElement button_Next = wait.until(ExpectedConditions.elementToBeClickable(objectRepository.ChechoutPageXpath.button_Next));
	        object.JsClick(button_Next);
		
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	
	
	public void addAddress()
	{
		try
		{
			WebElement Street = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.input_Street));
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
		Thread.sleep(5000);
		WebElement BillingAddress = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.checkbox_BillingAdd));
        if(BillingAddress.isSelected()) {					
            System.out.println("Checkbox  is selected");					

        } else {			
            System.out.println("Checkbox  is  not selected");
            object.JsClick(BillingAddress); 
        } 
		WebElement placeOrder = wait.until(ExpectedConditions.elementToBeClickable(objectRepository.ChechoutPageXpath.button_palceOrder));
		object.JsClick(placeOrder);
		Thread.sleep(5000);
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement text_Message = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.text_successMessage));
		String SuccessMessage = text_Message.getText();
		object.highlight(text_Message);
		WebElement orderNumber = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.ChechoutPageXpath.text_orderNumber));
		object.highlight(orderNumber);
		String purchaseOderNumber = orderNumber.getText();
		if(SuccessMessage.contains("Thank you for your purchase!"))
		{
			Assert.assertTrue(true);
			System.out.println( "Order Purchase success and your order number is"+":"+purchaseOderNumber);
			Thread.sleep(4000);
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Order Purchase failed");

		}
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
}

