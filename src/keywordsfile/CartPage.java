package keywordsfile;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CartPage extends commonMethods{
	public static String QuantityAdded;
	public static int initiaQuantity;
	public static String Price;
	public static int OriginalPrice;
	public static int SubtotalOriginalPrice;
	public static int SubtotalUpdatedPrice;
	
	commonMethods object = new commonMethods();
	
	
	public void validateInitialPrice()
	{
		try
		{
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement cartItemsAdded = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.HomePageXpath.text_cartNumber));
		WebElement QuantityAddedInitia = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.CartPageXpath.input_Quantity));
		object.JsClick(cartItemsAdded);
     	QuantityAdded =  QuantityAddedInitia.getAttribute("value");
		initiaQuantity = Integer.parseInt(QuantityAdded); 
		System.out.println("Quantity addded"+" "+QuantityAdded);
		WebElement Initialprice =driver.findElement(objectRepository.CartPageXpath.text_cartPrice);
		Price= Initialprice.getText();
		double d = Double.parseDouble(Price.substring(1));
		OriginalPrice = (int) d; 
		System.out.println("Initial price"+OriginalPrice);
		WebElement subtotalprice =driver.findElement(objectRepository.CartPageXpath.text_subtotalPrice);
		String subTotal= subtotalprice.getText();
		System.out.println("Initial subtotal price"+subTotal);
		double subT = Double.parseDouble(subTotal.substring(1));
		SubtotalOriginalPrice = (int) subT;
		System.out.println("Initial subtotal price"+SubtotalOriginalPrice);
		if(SubtotalOriginalPrice==OriginalPrice*initiaQuantity)
		{
			Assert.assertTrue(true);
			System.out.println("Initial subtotal is properly updated");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Initial subtotal is not properly updated");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement editCart =driver.findElement(objectRepository.CartPageXpath.button_Edit);
		object.JsClick(editCart);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	
	public void editQuantity()
	{
		try
		{
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement editQuantity = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.CartPageXpath.input_QuantityEdit));
		object.JsClick(editQuantity);
		editQuantity.clear();
		editQuantity.sendKeys(String.valueOf(initiaQuantity+1));
		WebElement Updatebutton =driver.findElement(objectRepository.CartPageXpath.button_UpdateCart);
		Updatebutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	
	public void verifyQuantityandProceed()
	{
		try
		{
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement editQuantity = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.CartPageXpath.input_Updatedcart));
		editQuantity.click();
		String Quantitymodified = editQuantity.getAttribute("value");
		int QuantityUpdated = Integer.parseInt(Quantitymodified); 
		System.out.println("Quantity updated to  "+" "+QuantityUpdated);
		if(QuantityUpdated==initiaQuantity+1)
			Assert.assertTrue(true, "Updated Quantity by one item");
		else
			Assert.assertTrue(false, "Unable to update Quantity by one item");
		WebElement subtotalpriceUpdated =driver.findElement(objectRepository.CartPageXpath.text_subtotalPriceUpdated);
		String subTotalUdated= subtotalpriceUpdated.getText();
		System.out.println("Updated subtotal price"+subTotalUdated);
		double subT = Double.parseDouble(subTotalUdated.substring(1));
		SubtotalUpdatedPrice = (int) subT;
		System.out.println("Updated subtotal price"+SubtotalUpdatedPrice);
		if(SubtotalUpdatedPrice==OriginalPrice*QuantityUpdated)
		{
			Assert.assertTrue(true);
			System.out.println("Price updated properly after adding quantity to the cart");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Price failed to update after adding quantity to the cart");
		}
		WebElement ProceedButton = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.CartPageXpath.button_ProceedtoCheck));
		object.JsClick(ProceedButton);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	
	
	
	
	
}

