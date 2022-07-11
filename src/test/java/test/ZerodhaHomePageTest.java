package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaHomePage;
import utility.BaseClass;
import utility.Excel;
import utility.Screenshot;

@Listeners(utility.Listeners.class)
public class ZerodhaHomePageTest extends BaseClass {
	//WebDriver driver;
	@BeforeMethod
	public void openBrowser() {
		driver=Browser.openchrome();
	}
	@AfterMethod
	public void screen() throws IOException {
		Screenshot.takesScreenShot(driver, "Zerodha");
	}
	@Test
	public void homePageTest() throws EncryptedDocumentException, IOException {
		ZerodhaHomePage zerodhaHomePage=new ZerodhaHomePage(driver);
		String userId = Excel.getData("Pawar", 14, 1);
		String pass = Excel.getData("Pawar", 15, 1);
		String pin = Excel.getData("Pawar", 16, 1);		
		zerodhaHomePage.enterUserId(userId);
		zerodhaHomePage.enterPassword(pass);
		zerodhaHomePage.clickOnLogin();
		zerodhaHomePage.enterPin(pin, driver);
		zerodhaHomePage.clickOnContinue();
		//zerodhaHomePage.clickOnOrders();
		//zerodhaHomePage.clickOnFunds();
		//zerodhaHomePage.searchshare("WIPRO");
		zerodhaHomePage.selectShareFromWatchlistandBuy("ONGC", driver);

	}
	@Test
	public void homePageTest1() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaHomePage zerodhaHomePage= new ZerodhaHomePage(driver);
		
		String userId = Excel.getData("Pawar", 14, 1);
		String pass = Excel.getData("Pawar", 15, 1);
		String pin = Excel.getData("Pawar", 16, 1);
		zerodhaHomePage.enterUserId(userId);
		zerodhaHomePage.enterPassword(pass);
		zerodhaHomePage.clickOnLogin();
		zerodhaHomePage.enterPin(pin, driver);
		zerodhaHomePage.clickOnContinue();
		zerodhaHomePage.clickOnOrders();
		
	}
}
