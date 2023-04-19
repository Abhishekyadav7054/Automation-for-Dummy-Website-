package finalproject;

//import java.awt.Label;
import java.io.FileOutputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.ForStackManipulation.Writable;

public class FinalProjetElementVarify {
	public WebDriver driver;

	@BeforeMethod
	public void launchApp() {
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.get("https://test-nf.com/english.html");
	}

	@Test
	public void verifyelement() throws Exception {
		// Import page factory method by page factory property
		PageObjectModel p = PageFactory.initElements(driver, PageObjectModel.class);
		// use of soft assertion to validate the given scenario.
		SoftAssert soft = new SoftAssert();
		// Scenario 2- Verifying the availability of Each Tab.
		
		// verify the availability of each tab(Home,Cricket,Basketball
		// Football ,Cyber sport)

		boolean Test1 = p.Home.isDisplayed();
		soft.assertEquals(Test1, true);
		System.out.println("Home tab is available");

		boolean Test2 = p.FootBall.isDisplayed();
		soft.assertEquals(Test2, true);
		System.out.println("Football tab is avialable ");

		boolean Test3 = p.Cricket.isDisplayed();
		soft.assertEquals(Test3, true);
		System.out.println("Cricket tab is available ");

		boolean Test4 = p.BasketBall.isDisplayed();
		soft.assertEquals(Test4, true);
		System.out.println("Basketball tab is available ");

		boolean Test5 = p.Cibersport.isDisplayed();
		soft.assertEquals(Test5, true);
		System.out.println("Cibersport tab is displayed ");

		// Scenario 3: Verify URL of each tab contains the tab name .
		// checking for home tab.
		p.Home.click();
		Thread.sleep(2000);
		String a = driver.getCurrentUrl();
		System.out.println(a);
		boolean s1 = a.contains("Home");
		soft.assertEquals(s1, true);

		// Checking for football tab
		p.FootBall.click();
		Thread.sleep(2000);
		String b = driver.getCurrentUrl();
		System.out.println(b);
		boolean s2 = a.contains("football");
		soft.assertEquals(s2, true);

		// checking for basketball tab
		p.BasketBall.click();
		Thread.sleep(2000);
		String c = driver.getCurrentUrl();
		System.out.println(c);
		boolean s3 = a.contains("Busketball");
		soft.assertEquals(s3, true);

		// Checking for cricket tab
		p.Cricket.click();
		Thread.sleep(2000);
		String d = driver.getCurrentUrl();
		System.out.println(d);
		boolean s4 = a.contains("kriket");
		soft.assertEquals(s4, true);

		// Checking for Cybersport tab
		p.Cibersport.click();
		Thread.sleep(2000);
		String e = driver.getCurrentUrl();
		System.out.println(e);
		boolean s5 = a.contains("cibersport");
		soft.assertEquals(s5, true);

		// store all the current URL of the tabs in Excel sheet
		FileOutputStream f = new FileOutputStream("C:\\Users\\abhis\\OneDrive\\Desktop\\Finalproject.xls");
		// creating workbook.
		WritableWorkbook wb = Workbook.createWorkbook(f);

		// creating sheet in workbook.
		WritableSheet wss = wb.createSheet("result", 1);
		// creating cell using Label class.
		jxl.write.Label l = new jxl.write.Label(0, 0, "Home Tab URL is: " + a);
		Label l2 = new Label(0, 1, "Football Tab URL is: " + b);
		Label l3 = new Label(0, 2, "Busketball Tab URL is: " + c);
		Label l4 = new Label(0, 3, "Kriket Tab URL is: " + d);
		Label l5 = new Label(0, 4, "CiberSport Tab URL is: " + e);
		wss.addCell(l);
		wss.addCell(l2);
		wss.addCell(l3);
		wss.addCell(l4);
		wss.addCell(l5);
		// saving and closing workbook
		wb.write();
		wb.close();

	}

	@AfterMethod
	public void closeapp() {
		driver.close();
	}
}
