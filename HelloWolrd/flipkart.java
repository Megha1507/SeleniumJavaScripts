package firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart {
	public static WebDriver driver = new ChromeDriver();
	public static void userLogin(String emailAddress , String password)
	{	
		// Scenario 1 : Check for InValid Email Address - Incorrect Format
		//Email address field
		
		driver.findElement(By.xpath("//input[@class='_2zrpKA']")).sendKeys(emailAddress);
		// Password Field
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(password);
		// Login button
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
	}
	public static void main(String[] args) 
	{
		
		driver.get("https://www.flipkart.com");
		userLogin("shraddha.bhange24@gmail.com" , "anshil24");
		
		driver.getTitle();
		driver.close();

	}

}


//if (Login == 