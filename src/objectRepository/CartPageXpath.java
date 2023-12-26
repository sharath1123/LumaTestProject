package objectRepository;

import org.openqa.selenium.By;

public class CartPageXpath {
	
	
	public static By input_Quantity= By.xpath("//input[contains(@class,'cart-item-qty')]");
	public static By button_Edit= By.xpath("//a[@title='Edit item']");
	public static By input_QuantityEdit= By.xpath("//input[@id='qty']");
	public static By button_UpdateCart= By.xpath("//button[@title='Update Cart']");
	public static By input_Updatedcart= By.xpath("//input[@title='Qty']");
	public static By button_ProceedtoCheck = By.xpath("(//button[@title='Proceed to Checkout'])[1]");
	public static By text_cartPrice = By.xpath("(//span[@class='price'])[3]");
	public static By text_subtotalPrice = By.xpath("//div[@class='subtotal']//div//span//span");
	public static By text_subtotalPriceUpdated = By.xpath("//td[contains(@class,'subtotal')]//span[@class='price']");
	
	
	
	
	

}
