package finalproject;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

// creating page object model class for storing the locators of the tabs

public class PageObjectModel {
	@FindBy(xpath = "//*[text()='Home']")
	WebElement Home;

	@FindBy(xpath = " //*[text()='Football']")
	WebElement FootBall;

	@FindBy(xpath = "  //*[text()='Busketball']")
	WebElement BasketBall;

	@FindBy(xpath = " //*[text()='Kriket']")
	WebElement Cricket;

	@FindBy(xpath = "  //*[text()='Cibersport']")
	WebElement Cibersport;

}
