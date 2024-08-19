package MobileAutomation.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shravani");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(id ="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	//driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	@AndroidFindBy(id ="android:id/text1")
	private WebElement dropDownClick;
	//driver.findElement(By.id("android:id/text1")).click();
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	@AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
	private WebElement errorMessage;
	//String toast = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	
	public void setNameField(String name) {  //action methods
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		if(gender.contains("female")) 
			femaleOption.click();
		else
			maleOption.click();
	}
	
	public void selectCountry(String country) {
		dropDownClick.click();
		scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
	}
	
	public void clickShopButton() {
		shopButton.click();
	}
	
	public String getErrorMessage() {
		return(errorMessage.getAttribute("name"));
	}
}
