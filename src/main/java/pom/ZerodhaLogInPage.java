package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLogInPage {
	
	@FindBy (xpath="//input[@id='userid']") private WebElement userId;
	@FindBy (xpath="//input[@id='password']") private WebElement password;
	@FindBy (xpath="//button[@type='submit']") private WebElement logIn;
	@FindBy (xpath="//a[text()=\"Forgot user ID or password?\"]") private WebElement forgot;
	@FindBy (xpath="//img[@alt='Kite Android']") private WebElement playStore;
	@FindBy (xpath="//img[@alt='Kite iOS']") private WebElement appleStore;
	@FindBy (xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp;
	@FindBy (xpath="//input[@id='pin']") private WebElement pin;
	@FindBy (xpath="//button[@class='button-orange wide']") private WebElement pinLogin;
	@FindBy (xpath="//span[text()='TATAPOWER']") private WebElement tataPower;
	@FindBy (xpath="//img[@alt='Kite']") private WebElement logo;
	
	public ZerodhaLogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    public void enterUserId(String user) {
    	userId.sendKeys(user);
    }
    public void enterPassword(String pass) {
    	password.sendKeys(pass);
    }
    public void clickOnLogin() {
    	logIn.click();
    }
    public void clickOnForgot() {
    	forgot.click();
    }
    public void clickOnSignUp() {
    	signUp.click();
    }
    public void clickOnAppleStore() {
    	appleStore.click();
    }
    public void clickOnPlayStore() {
    	playStore.click();
    }
    public void enterPin(String pinnumber,WebDriver driver) {
    	WebDriverWait wait  = new WebDriverWait(driver,Duration.ofMillis(10000));
    	wait.until(ExpectedConditions.visibilityOf(pin));
    	 pin.sendKeys(pinnumber);
    }
    public void clickOnPinLogin() {
    	pinLogin.click();
    }
    public void clickOnTata(WebDriver driver) {
    	WebDriverWait wait  = new WebDriverWait(driver,Duration.ofMillis(10000));
    	wait.until(ExpectedConditions.visibilityOf(tataPower));
    	tataPower.click();
    }
    public boolean displayLogo() {
    	return logo.isDisplayed();
    }
}
