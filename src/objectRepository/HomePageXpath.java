package objectRepository;

import org.openqa.selenium.By;


public class HomePageXpath {
	
	public static By button_signIn = By.xpath("//button[@class='action login primary']//span");
	public static By hover_GearOption = By.xpath("//a[@class='level-top ui-corner-all']//span[text()='Gear']");
	public static By link_Watches = By.xpath("//a[@class='ui-corner-all']//span[text()='Watches']");
	public static By dropdown_Meterial = By.xpath("(//div[@class='filter-options-title'])[4]");
	public static By link_Metal = By.linkText(" Metal ");
	public static By image_Watch = By.xpath("(//span[@class='product-image-wrapper']//img)[3]");
	public static By button_Addtocart = By.xpath("(//span[text()='Add to Cart'])[3]");
	public static By text_cartNumber = By.xpath("//span[@class='counter-number']");
	public static By text_WatchesTitle = By.xpath("//h1[@id='page-title-heading']//span");
	public static By text_filterValue = By.xpath("//span[@class='filter-value']");
}
