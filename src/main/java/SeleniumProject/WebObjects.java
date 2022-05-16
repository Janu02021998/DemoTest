package SeleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebObjects {

	static WebDriver driver;

	public static WebElement HomePage(WebDriver driver) {

		return driver.findElement(By.id("mainBlueContainer"));
		
	}
	
	public static List<WebElement> Menus(WebDriver driver) {

		return driver.findElements(By.className("menu-text"));
		
	}
	
	public static WebElement InnerMenuHeader(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@to-do='mobile']//h1[@class='name']"));
		
	}
	
	public static WebElement OperadorInput(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@to-do='mobile']//h1/following-sibling::div//ul//input[@name='operator']"));
		
	}
	
	public static List<WebElement> OperadorValues(WebDriver driver) {

		return driver.findElements(By.xpath("//div[@class='suggestion']//ul//li//div//b"));
		
	}
	
	public static WebElement NumeroInput(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@to-do='mobile']//h1/following-sibling::div//ul//li[2]//input"));
		
	}
	
	public static WebElement MontoInput(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@to-do='mobile']//h1/following-sibling::div//ul//li[3]//input"));
		
	}
	
	public static WebElement MontoInputCategory(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@class='suggestion']//div//div[@class='category active']"));
		
	}
	
	public static WebElement MontoInputCategory10(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@class='suggestion']//ul//li//div[text()='Recarga $10']"));
		
	}
	
	public static WebElement PaymentBtn(WebDriver driver) {

		return driver.findElement(By.xpath("(//button[@perform='payment'])[1]"));
		
	}
	
	public static List<WebElement> PaymentMethod(WebDriver driver) {

		return driver.findElements(By.xpath("//p[@class='panelTextStyleDesktop']"));
		
	}
	
	public static List<WebElement> PaymentMode(WebDriver driver) {

		return driver.findElements(By.xpath("//div[@id='card']//a//span"));
		
	}
	
	public static WebElement PaymentModeRadioBtn(WebDriver driver) {

		return driver.findElement(By.xpath("//input[@id='radio-c']"));
		
	}
	
	public static WebElement CardNumber(WebDriver driver) {

		return driver.findElement(By.id("cardnumberunique"));
		
	}
	
	public static List<WebElement> Month(WebDriver driver) {

		return driver.findElements(By.name("expmonth"));
		
	}
	
	public static List<WebElement> Date(WebDriver driver) {

		return driver.findElements(By.name("expyear"));
		
	}
	
	public static List<WebElement> CVV(WebDriver driver) {

		return driver.findElements(By.name("cvvno"));
		
	}
	
	public static List<WebElement> Email(WebDriver driver) {

		return driver.findElements(By.name("txtEmail"));
		
	}
	
	public static WebElement FinalPayment(WebDriver driver) {

		return driver.findElement(By.xpath("//button[@id='paylimit']//span[@class='PaymentMethod']"));
		
	}
	
	public static WebElement PaymentSuccessMsg(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@class='visual-message']"));
		
	}
	
	public static WebElement PaymentSuccessMsgDetails(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@class='confirmation-message ']"));
		
	}
	
	public static WebElement PaymentSuccessMsgDetailsDate(WebDriver driver) {

		return driver.findElement(By.xpath("(//div[@class='flex-column confirmationSummary'])//div[@class='flex-row flex-space-between date-folio']/div[1]"));
		
	}
	
	public static WebElement PaymentSuccessMsgDetailsAmount(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@class='confirmation-amount']//div"));
		
	}
	
	public static WebElement RecentPhoneRechargePopup(WebDriver driver) {

		return driver.findElement(By.id("recentPhoneRecharge"));
		
	}
	
	public static WebElement RecentPhoneRechargePopupContinueBtn(WebDriver driver) {

		return driver.findElement(By.xpath("//button[@onclick='continueRepeatedTnx()']"));
		
	}
	
	public static WebElement PopUp(WebDriver driver) {

		return driver.findElement(By.id("login"));
		
	}
	
	public static WebElement PopupHeader(WebDriver driver) {

		return driver.findElement(By.xpath("//div[@class='alert alert-info loginToProceed']"));
		
	}
	
	public static WebElement PopupInnerHeader(WebDriver driver) {

		return driver.findElement(By.xpath("//li[@id='loginTabBtn']/a"));
		
	}
	
	public static WebElement PopUpEmailInput(WebDriver driver) {

		return driver.findElement(By.id("usrname"));
		
	}
	
	public static WebElement PopUpPasswordInput(WebDriver driver) {

		return driver.findElement(By.id("psw"));
		
	}
	
	public static WebElement PopupRobotCheckBox(WebDriver driver) {

	//	return driver.findElements(By.xpath("//label[contains(text(),'not a robot')]"));
		return driver.findElement(By.xpath("//div[@class='field form-group']/following-sibling::div[@class='g-recaptcha']//div//div/iframe"));
		
	}
	
	public static WebElement PopUpLoginBtn(WebDriver driver) {

		return driver.findElement(By.id("loginBtn"));
		
	}
	
}
