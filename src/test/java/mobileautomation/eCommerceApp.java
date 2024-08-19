package mobileautomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableMap;

import MobileAutomation.pageObjects.android.CartPage;
import MobileAutomation.pageObjects.android.FormPage;
import MobileAutomation.pageObjects.android.ProductCatalog;
import TestUtils.BaseTest;
import TestUtils.ExtentReporterNG;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class eCommerceApp extends BaseTest{

	@Test(dataProvider = "getData")
	public void fillForm(String name, String gender, String country) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		//ExtentReports extent = new ExtentReports();
		//extent.createTest("eCommerceApp");
		FormPage formpage = new FormPage(driver);
		ProductCatalog productcatalog = new ProductCatalog(driver);
		CartPage cartpage = new CartPage(driver);
		formpage.setNameField(name);
		formpage.setGender(gender);
		formpage.selectCountry(country);
		formpage.clickShopButton();
		productcatalog.addfirstProduct();
		productcatalog.addItemToCartByIndex(0);
		productcatalog.goToCartPage();
		double totalSum = cartpage.getProductsSum();
		double displayFormattedSum = cartpage.getTotalAmountDisplayed();
		cartpage.clickCheckBox();
		cartpage.acceptTermsConditions();
		
//		ExtentReports extent = ExtentReporterNG.getReporterObj();
		// cartpage.submitOrder();
		//extent.flush();
		Assert.assertEquals(totalSum, displayFormattedSum);
		
	}
	
	@Test
	public void validateErrorMessage(String name, String gender, String country) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		FormPage formpage = new FormPage(driver);
		// formpage.setNameField(name);
		formpage.setGender(gender);
		formpage.selectCountry(country);
		formpage.clickShopButton();
		String toast = formpage.getErrorMessage();
		// String toast = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toast, "Please enter your name");
	}
	
	
	@DataProvider
	public Object[][] getData() {
		return 	new Object[][] {{"Shravani", "female", "Brazil"}};
	}

}
