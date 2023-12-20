package objectRepository;

import org.openqa.selenium.By;

public class commonMethodsXpath {
	

		public static By link_signIn = By.xpath("(//li[@class='authorization-link']//a)[1]");	
		public static By text_userName = By.cssSelector("input#email");
		public static By text_Password = By.cssSelector("input#pass");
			
}
