package selenium_proj1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SnapdealAutomationPractice {
	
	public static void main(String[] args) {
		
		try {
		System.out.println("Item name : ") ;
		Scanner sc = new Scanner(System.in);
		String usrIn= sc.nextLine();
		System.out.println("Searching for : " +usrIn);
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	// Enter userInput in searchbox of webpage.
		driver.findElement(By.xpath("//input[@id='inputValEnter']")).sendKeys(usrIn); 
		driver.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']")).click();
	// Closing Scanner class
	
		sc.close();
		Thread.sleep(3000);
	// Sort the webPage by selecting "High to Low" from the Dropdown "Sort By"
		
		Actions m = new Actions(driver);
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		
		WebElement target=driver.findElement(By.xpath("//li[@data-sorttype='phtl']"));
		
		m.moveToElement(target).click().perform();
	// Get titles of all the items
		
		System.out.println(driver.getTitle());
		
		List<WebElement> allText=driver.findElements(By.xpath("//p[contains(@class,'product-title')][contains(text(),'hTC Desire')]"));
		
		ArrayList<String> al = new ArrayList<String>();

		for(WebElement e: allText)
			
			{
			System.out.println(e.getText());
			al.add(e.getText());
			}
		File file = new File("D:\\writeExcel.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis) ;
		
		XSSFSheet Sheet1 = wb.getSheetAt(0);
		
		//Row row;
		for(int i = 0; i< al.size() ; i++ )
		{
			
		//row= Sheet1.createRow(i);
		//row.createCell(0).setCellValue(al.get(i));	
		Sheet1.createRow(i).createCell(0).setCellValue(al.get(i));
		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		fout.close(); 
		
		}wb.close();
		}
	  catch (Exception e) 
	  {
	   // TODO Auto-generated catch block
	   
	   e.printStackTrace();
	  }
		
		}
}

