package objectRepository;

import org.openqa.selenium.By;

public class ChechoutPageXpath {
	
	
	public static By button_NewAddress= By.xpath("//span[contains(text(),'New Address')]");
	public static By input_Street= By.xpath("(//input[contains(@name,'street')])[1]");
	public static By input_City= By.xpath("//input[contains(@name,'city')]");
	public static By dropdown_region= By.xpath("//select[contains(@name,'region_id')]");
	public static By input_Postcode= By.xpath("//input[contains(@name,'postcode')]");
	public static By dropdown_Country= By.xpath("//select[contains(@name,'country')]");
	public static By input_Telephone= By.xpath("//input[contains(@name,'telephone')]");
	public static By button_shiphere= By.xpath("//span[contains(text(),'Ship here')]");
	public static By radio_shippingMethod= By.xpath("//input[@type='radio' and @value='flatrate_flatrate']");
	public static By button_Next= By.xpath("//span[text()='Next']");
	public static By checkbox_BillingAdd= By.xpath("//input[@type='checkbox' and @name='billing-address-same-as-shipping']");
	public static By button_palceOrder = By.xpath("//button[@type='submit' and @title='Place Order']");
	public static By text_successMessage = By.xpath("//h1[@class='page-title']//span");
	public static By text_orderNumber = By.xpath("//p[text()='Your order number is: ']//a//strong");
	public static By shippingAddress = By.xpath("//div[contains(@class,'shipping-address-item selected')]");
}
