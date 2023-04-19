package finalproject;

import java.io.FileInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class Testurl {
	public  WebDriver driver;
	@BeforeMethod
	public void Exceldata() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\abhis\\OneDrive\\Desktop\\input.xls");
		//open tje exel sheet in workbook
		Workbook wb = Workbook.getWorkbook(f);
		//identify yhe shell and trreading data from the shell
		Sheet s =  wb.getSheet("Sheet1");
		
		System.out.println(s.getCell(0, 0).getContents());
		System.out.println(s.getCell(1, 0).getContents());
		
		int rc = s.getRows();
		System.out.println(rc);
		int cc = s.getColumns();
		System.out.println(cc);
		for(int i=0;i<rc;i++) {
			for(int j=0;j<cc;j++) {
				System.out.println(s.getCell(j, i).getContents()+" ");	
			}
			System.out.println();
		}
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(s.getCell(1, 1).getContents());
		driver.manage().window().maximize();
	}
		
	
	@AfterMethod
	public void appclose() {
		driver.close();
	}

}
