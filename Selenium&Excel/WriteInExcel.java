package selenium_proj1;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteInExcel {

	public static void main(String[] args) throws IOException, InterruptedException{
	try {
		
		File A = new File("C:\\Users\\admin\\Desktop\\new2.xlsx");
		FileInputStream fis = new FileInputStream(A);
	
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet Sheet1= wb.getSheetAt(0);
		System.out.println(Sheet1);
		Thread.sleep(1000);
		
		Sheet1.createRow(0).createCell(0).setCellValue("Megg12");
		Sheet1.getRow(0).createCell(1).setCellValue("2.5");
		
		FileOutputStream fos = new FileOutputStream(A);
		
		wb.write(fos);
		fos.close();
		//wb.close();
		}
		catch (IOException e) 
	  {
		   // TODO Auto-generated catch block
		   
		   e.printStackTrace();
		  }
			}
			
	}

