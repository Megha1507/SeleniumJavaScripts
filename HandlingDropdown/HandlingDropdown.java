package newpackage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver. get("https://login.yahoo.com/account/create?src=fpctx&intl=in&lang=en-IN&done=https%3A%2F%2Fin.yahoo.com&specId=yidReg");		
		Select dropDown = new Select(driver.findElement(By.xpath("//*[@id=\"usernamereg-month\"]")));
		
		// To select item by index in dropdown
		dropDown.selectByIndex(2);
		
		// To select particular item in the Dropdown
		dropDown.selectByVisibleText("March"); 
		
		// To count the items in the Dropdown list
		List <WebElement> e = dropDown.getOptions();
		int itemCount = e.size();
		System.out.println(itemCount);
		driver.close();
	}

}
