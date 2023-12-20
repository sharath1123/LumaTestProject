package keywordsfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import objectRepository.CartPageXpath;

public class CartPage extends commonMethods{
	public static String Quantity;
	public static int initiaQuantity;
	public static String Price;
	public static int OriginalPrice;
	public static int SubtotalOriginalPrice;
	
	

	
	public void addMoreQty()
	{
		try
		{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement Quatity = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.CartPageXpath.input_Quantity));
		WebElement cartItemsAdded =driver.findElement(objectRepository.HomePageXpath.text_cartNumber);
		executor.executeScript("arguments[0].click()", cartItemsAdded);
		cartItemsAdded.click();
		Quantity =  cartItemsAdded.getText();
		initiaQuantity = Integer.parseInt(Quantity); 
		System.out.println("Quantity addded"+" "+Quantity);
		WebElement Initialprice =driver.findElement(objectRepository.CartPageXpath.text_cartPrice);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement editCart =driver.findElement(objectRepository.CartPageXpath.button_Edit);
		executor.executeScript("arguments[0].click()", editCart);
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
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement editQuantity = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.CartPageXpath.input_QuantityEdit));
		executor.executeScript("arguments[0].click()", editQuantity); 
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
		JavascriptExecutor executor = (JavascriptExecutor) driver;
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
		WebElement ProceedButton = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.CartPageXpath.button_ProceedtoCheck));
		executor.executeScript("arguments[0].click()", ProceedButton);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	
	
	
	
	
}

