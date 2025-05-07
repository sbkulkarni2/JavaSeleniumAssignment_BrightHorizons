/*   This is a Page Class of the home page used in the application */

package PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.Base;

public class Find_Center {
		
	WebDriver driver;
	
	/*  Various locators used in this page class */
	String BTN_Accept_Cookies = "onetrust-accept-btn-handler";
	String LINKTEXT_Find_Center = "Find a Center";
	String TXTBOX_Input_Address = "addressInput";
	String Centers_List = "//div[contains(@data-center-select-tracking,'Center Result')]";
	String Total_Displayed = "//span[@class='resultsNumber']";
	String LOCATION_NAME_ALERT = "//span[@class='mapTooltip__headline']";
	String ADDRESS_IN_ALERT = "//div[@id='1489']/div/div[@class='mapTooltip__address']";
	String LOCATION_NAME_LIST = "//h3[@class='centerResult__name']";
	String ADDRESS_IN_LIST = "//span[@class='centerResult__address']";
	
	/* Constants Used */
	String Address = "New York";
	String CENTER_ID = "1489";
	
	/* Parameters to verify */
	String verify_1 = "/child-care-locator";

	
	public Find_Center(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	/*  accept the cookies in the pop up */
	public void accept_cookies()
	{
		driver.findElement(By.id(BTN_Accept_Cookies)).click();
	}

	
	/* TC 2 : Click on Find A Center button  */
	public void find_center()
	{
		driver.findElement(By.linkText(LINKTEXT_Find_Center)).click();
	}
	
	
	/*  TC 3 : Verify that the URL contains a certain text  */
	public void verify_text()
	{
		driver.getCurrentUrl().contains(verify_1);
	}
	
	
	/*   TC 4  : Enter location "New York" and Press Enter Key  */
	public void enter_location() throws InterruptedException
	{
		WebElement m = driver.findElement(By.id(TXTBOX_Input_Address));
		Thread.sleep(9000);
		m.sendKeys(Address);
		Thread.sleep(9000);
		m.click();
		Thread.sleep(9000);
		m.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
	}
	
	
	/*  TC 5 : Verify the counts of centers displayed in the list and that displayed at the top */
	public void verify_counts()
	{
	
	List<WebElement> list_centers = driver.findElements(By.xpath(Centers_List));
	int count_1 = list_centers.size();
		
	WebElement list_total = driver.findElement(By.xpath(Total_Displayed));
	String count_2 = list_total.getText();
	int count_3 = Integer.parseInt(count_2);
	
	if(count_1 == count_3)
		System.out.println("Both counts are equal");
	else
		System.out.println("Both counts are not equal");
	
	}

	/*   TC 6, 7 : Click on 1st center in the list 
	 *   Verify Name and Address of this center are same in the list and in the pop up */
	
	public void verify_name_and_address() throws InterruptedException
	{
		driver.findElement(By.id(CENTER_ID)).click();
		Thread.sleep(5000);
		
		WebElement name_in_alert = driver.findElement(By.xpath(LOCATION_NAME_ALERT));
		String name1 = name_in_alert.getText();
		WebElement address_in_alert = driver.findElement(By.xpath(ADDRESS_IN_ALERT));
		String address1 = address_in_alert.getText();
			
		driver.switchTo().defaultContent();
			
		WebElement name_in_list = driver.findElement(By.xpath(LOCATION_NAME_LIST));
		String name2 = name_in_list.getText();
		WebElement address_in_list = driver.findElement(By.xpath(ADDRESS_IN_LIST));
		String address2 = address_in_list.getText(); 
	
		if(name1.equals(name2))
			System.out.println("Both names are equal");
		else
			System.out.println("Both names are not same");
		
		if(address1.equals(address2))
			System.out.println("Both addresses are equal");
		else
			System.out.println("Both addresses are not same");
		
	}

}