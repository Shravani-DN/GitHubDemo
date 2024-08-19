package TestUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	public AndroidDriver driver;
	
	@BeforeTest
	public void ConfigureAppium() throws MalformedURLException 
	{
	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName("Pixel_6");
	options.setChromedriverExecutable("C:\\Users\\shravanidn\\Downloads\\chromedriverpath\\chromedriver.exe");
	options.setApp("C:\\Users\\shravanidn\\eclipse-workspace\\MYMAVEN\\src\\test\\java\\Resources\\General-Store.apk");	
	driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		//1. capture and place in folder //2. extent report pick file and attach to report
	}
	
}
