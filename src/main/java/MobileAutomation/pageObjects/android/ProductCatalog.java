package MobileAutomation.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class ProductCatalog extends AndroidActions{
	AndroidDriver driver;
	public ProductCatalog(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productAddCart")
	private WebElement firstProduct;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	//driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
	
	public void addfirstProduct() throws InterruptedException {
		firstProduct.click();
		Thread.sleep(2000);
	}
	
	public void addItemToCartByIndex(int index) {
		addToCart.get(index).click();
	}
	
	public void goToCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(2000);
	}
}
