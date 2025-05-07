/*  This is a Test Class in the program which creates objects of the different page classes and
 *   calls the functions within them
*/

package TestClasses;

import org.openqa.selenium.WebDriver;

import BaseClass.Base;
import PageClasses.Find_Center;

public class test_Find_Center extends Base{
	
	public static void main(String[] args) throws InterruptedException {
	
		Find_Center fc;
		Base bs;
			
		bs = new Base();
		bs.setChromeDriver();
		bs.navigate_and_maximize();
		
		fc = new Find_Center(driver);
		
		fc.accept_cookies();
		fc.find_center();
		fc.verify_text();
		fc.enter_location();
		fc.verify_counts();
		fc.verify_name_and_address();
		
		bs.quit_application();
	}

}
