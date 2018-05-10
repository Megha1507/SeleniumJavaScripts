package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
		// Switch to 3rd frame
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody[2]/tr[1]/td[1]/a")).click();
		Thread.sleep(1000);
		// Switch from 3rd Frame to Top Window
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		// switch to 1st Frame
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		
	}

}
