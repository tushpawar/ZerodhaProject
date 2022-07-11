package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static void takesScreenShot(WebDriver driver,String name) throws IOException {
		String d=Screenshot.date();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\ScreenShot\\"+name+d+".jpg");
		
		FileHandler.copy(source, destination);
}
	public static String date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss");
		LocalDateTime currentTime = LocalDateTime.now();
		String d=dtf.format(currentTime);
		return d;
				
	}
}
