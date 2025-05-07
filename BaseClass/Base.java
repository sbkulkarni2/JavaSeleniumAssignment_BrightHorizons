/*  Base Class of the program which opens the browser and performs setup and teardown 
 *  activities 
 */

package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

		public static WebDriver driver;
		
		/*  Constants */
		String URL_to_get  = "https://www.brighthorizons.com";
		String PATH = "C:\\Softwares\\Selenium\\Chromedriver\\chromedriver-win64\\chromedriver.exe";
		
		public Base()
		{
			
		}
		public void setChromeDriver()
		{
			System.setProperty("webdriver.chrome.driver",PATH);	
		}
			
		/* TC 1 : Open the Bright Horizons site  */
		public void navigate_and_maximize()
		{	
			driver = new ChromeDriver();
			driver.get(URL_to_get);
			driver.manage().window().maximize();
		}
		
		public void quit_application()
		{
			driver.quit();
		}

}
