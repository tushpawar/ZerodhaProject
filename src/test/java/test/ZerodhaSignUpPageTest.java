package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaSignUpPage;
import utility.Excel;
import utility.Screenshot;

public class ZerodhaSignUpPageTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver=Browser.openchrome();
	}
	
	@Test
	public void signUpPage() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaSignUpPage zerodhaSignUpPage=new ZerodhaSignUpPage(driver);
		zerodhaSignUpPage.clickOnSignup(driver);
		String number = Excel.getData("Pawar", 9, 1);
		zerodhaSignUpPage.enterMobileNumber(number);
		zerodhaSignUpPage.clickOnContinue();
		Screenshot.takesScreenShot(driver, "Zerodhanumber");
	}

}
