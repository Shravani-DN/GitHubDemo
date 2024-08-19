package MobileAutomation.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class CartPage extends AndroidActions{
	AndroidDriver driver;
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement cancel;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox") //By.xpath("//android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement submitPurchase;
	
	public List<WebElement> getProductList(){
		return productList;
	}
	
	public double getProductsSum() {
		int productCount = productList.size();
		double totalSum = 0;
		for(int j = 0; j<productCount; j++) {
			String amountString = productList.get(j).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		}
		return totalSum;
	}
		
	public Double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions(){
		longPressAction(terms);
		cancel.click();
	}
	
	public void submitOrder() {
		submitPurchase.click();
	}
	
	public void clickCheckBox() {
		checkBox.click();
	}

}


