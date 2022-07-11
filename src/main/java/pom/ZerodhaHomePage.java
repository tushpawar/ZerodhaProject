package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {
	
	@FindBy (xpath="//input[@id='userid']") private WebElement userId;
	@FindBy (xpath="//input[@id='password']") private WebElement password;
	@FindBy (xpath="//button[@type='submit']") private WebElement logIn;
	@FindBy (xpath="//input[@id='pin']") private WebElement pin;
	@FindBy (xpath="//button[@class='button-orange wide']") private WebElement pinLogin;
    @FindBy (xpath="//span[text()='Dashboard']") private WebElement dashboard;
    @FindBy (xpath="//span[text()='Orders']") private WebElement orders;
    @FindBy (xpath="//span[text()='Holdings']") private WebElement holdings;
    @FindBy (xpath="//span[text()='Positions']") private WebElement positions;
    @FindBy (xpath="//span[text()='Funds']") private WebElement funds;
    @FindBy (xpath="//span[text()='Apps']") private WebElement apps;
    @FindBy (xpath="//input[@icon='search']") private WebElement search;
    @FindBy (xpath="//span[@class='nice-name']") private List<WebElement> shares;
    @FindBy (xpath="//button[@class='button-blue buy']") private WebElement buy;
    
    public ZerodhaHomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
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
    public void enterPin(String pinnumber,WebDriver driver) {
    	FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver);
    	wait.withTimeout(Duration.ofMillis(2000));
    	wait.pollingEvery(Duration.ofMillis(500));
    	wait.ignoring(Exception.class);
    	wait.until(ExpectedConditions.visibilityOf(pin));
    	pin.sendKeys(pinnumber);
    }
    public void clickOnContinue() {
    	pinLogin.click();
    }
    public void clickOnDashboard() {
    	dashboard.click();
    }
    public void clickOnOrders() {
    	orders.click();
    }
    public void clickOnHoldings() {
    	holdings.click();
    }
    public void clickOnpositions() {
    	positions.click();
    }
    public void clickOnFunds() {
    	funds.click();
    }
    public void clickOnApps() {
    	apps.click();
    }
    public void searchshare(String searchbox) {
    	search.sendKeys(searchbox);
    }
    public void selectShareFromWatchlistandBuy(String shareName,WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
    	wait.until(ExpectedConditions.visibilityOf(search));
    	System.out.println(shares.size());
    	for(int i=0;i<shares.size();i++)
    	{
    		WebElement stock=shares.get(i);
    		String stockName=stock.getText();
    		if(stockName.equals(shareName))
    		{
    			Actions action=new Actions(driver);
    	    	action.moveToElement(stock);
    	        action.perform();
    	        buy.click();
    		}
    	}
    	
    }
    
}
