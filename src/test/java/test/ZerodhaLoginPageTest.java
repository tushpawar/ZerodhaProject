package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.ZerodhaLogInPage;
import utility.Excel;
import utility.Screenshot;

public class ZerodhaLoginPageTest {
	
	WebDriver driver;
	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		 driver = Browser.openchrome();
//		Thread.sleep(4000);
		
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException, IOException {
		Screenshot.takesScreenShot(driver, "Zerodha");
		//Thread.sleep(5000);
		//driver.quit();
	}
	@Test
	public void loginTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLogInPage zerodhaLogInPage = new ZerodhaLogInPage(driver);
		String userId=Excel.getData("Pawar", 6, 1);
		String password=Excel.getData("Pawar", 7, 1);
		String pin = Excel.getData("Pawar", 8, 1);
		boolean status = zerodhaLogInPage.displayLogo();
		//Assert.assertFalse(status); //Hard Assert.
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertFalse(status);
		zerodhaLogInPage.enterUserId(userId);
		zerodhaLogInPage.enterPassword(password);
		zerodhaLogInPage.clickOnLogin();
		//Thread.sleep(3000);
		zerodhaLogInPage.enterPin(pin,driver);
		zerodhaLogInPage.clickOnPinLogin();
	    zerodhaLogInPage.clickOnTata(driver);
	    softAssert.assertAll();
		
		//Thread.sleep(2000);
		
	}
	
	@Test
	
	public void forgotTest() throws IOException {
		ZerodhaLogInPage zerodhaLogInPage=new ZerodhaLogInPage(driver);
		zerodhaLogInPage.clickOnForgot();
		Screenshot.takesScreenShot(driver, "Zerodhaforgot");
	}
	
	@Test
	
	public void playStoreTest() throws IOException {
		ZerodhaLogInPage zerodhaLogInPage = new ZerodhaLogInPage(driver);
		zerodhaLogInPage.clickOnPlayStore();
		Screenshot.takesScreenShot(driver, "ZerodhaPlaystore");
	}
	@Test
	public void appleStoreTest() throws IOException {
		ZerodhaLogInPage zerodhaLogInPage = new ZerodhaLogInPage(driver);
		zerodhaLogInPage.clickOnAppleStore();
		Screenshot.takesScreenShot(driver, "ZerodhaApple");
	}
}
