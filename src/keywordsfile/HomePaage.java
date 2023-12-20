package keywordsfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import objectRepository.HomePageXpath;
import org.openqa.selenium.JavascriptExecutor;

public class HomePaage extends commonMethods{

	
	public void selectWatchesOption()
	{
		try
		{
		WebElement hover_GearOption=driver.findElement(objectRepository.HomePageXpath.hover_GearOption);
		WebElement link_Watches=driver.findElement(objectRepository.HomePageXpath.link_Watches);
		Actions action = new Actions(driver);;
		Action movetoElemt = action.moveToElement(hover_GearOption).build();
		movetoElemt.perform();
		link_Watches.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement title_Watches=driver.findElement(objectRepository.HomePageXpath.text_WatchesTitle);
		String heading = title_Watches.getText();
		Assert.assertEquals(heading, "Watches");
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    		
    	}
	}
	
	public void filterMetal()
	{
		try
		{
	   wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	   WebElement elementLocated = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.HomePageXpath.dropdown_Meterial));
	   elementLocated.click();
	   WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Metal")));
	   clickableElement.click();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   WebElement textfilteredValue=driver.findElement(objectRepository.HomePageXpath.text_filterValue);
		String value = textfilteredValue.getText();
		Assert.assertEquals(value, "Metal");
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	
	public void addItemtoCart()
	{
		try
		{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement elementLocated = wait.until(ExpectedConditions.presenceOfElementLocated(objectRepository.HomePageXpath.button_Addtocart));
		scrolldown();
		WebElement WatchDisplayed =driver.findElement(objectRepository.HomePageXpath.image_Watch);
		Actions action = new Actions(driver);;
		Action movetoElemt = action.moveToElement(WatchDisplayed).build();
		movetoElemt.perform();
		elementLocated.click();
		WebElement cartItemsAdded =driver.findElement(objectRepository.HomePageXpath.text_cartNumber);
		Action movetocart = action.moveToElement(cartItemsAdded).build();
		movetocart.perform();
		
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    		Assert.assertTrue(false);
    	}
	}
	
}
