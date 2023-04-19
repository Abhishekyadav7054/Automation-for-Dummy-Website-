package finalproject;

import java.io.FileInputStream;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import jxl.Sheet;
import jxl.Workbook;

public class Test2 {
	public WebDriver driver;
	
	public void exceldata() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\abhis\\Downloads\\url.xls");
		//open tje exel sheet in workbook
		Workbook wb = Workbook.getWorkbook(f);
		//identify yhe shell and trreading data from the shell
		Sheet s =  wb.getSheet("Sheet1");
		driver.get(s.getCell(0, 0).getContents());
		
		//System.out.println(s.getCell(0, 1).getContents());
		
	}
	
	public void appclose() {
		driver.close();
	}

}
