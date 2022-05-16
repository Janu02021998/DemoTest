package SeleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Payment extends CrossBrowserScript{

	public String operador;
	public String recarga;
	
	@BeforeTest
	@Parameters("browser")
	public void launch(String browser) throws Exception{
		
		setup(browser);
	}
	
	
	@Test(priority=0)
	public void launchURL() throws InterruptedException{
		
		driver.get("http://sanbox.undostres.com.mx");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void verifyMenu() throws InterruptedException{
		
		WebObjects.HomePage(driver).isDisplayed();
		Assert.assertTrue(WebObjects.Menus(driver).get(0).getText().contains("Recarga"));
		Assert.assertEquals(WebObjects.InnerMenuHeader(driver).getText(), "Recarga Celular");
		
	}
	
	@Test(priority=2)
	public void EnterInputFields() throws InterruptedException{
		
		WebObjects.OperadorInput(driver).click();
		for(int i=0;i<WebObjects.OperadorValues(driver).size();i++) {
		if(WebObjects.OperadorValues(driver).get(i).getText().contains("Telcel")) {
			 operador = WebObjects.OperadorValues(driver).get(i).getText();
			WebObjects.OperadorValues(driver).get(i).click();
			break;
		}
		
	}
}
	
	@Test(priority=3)
	public void EnterInputFields2() throws InterruptedException{
		
		WebObjects.NumeroInput(driver).sendKeys("8465433546");
		WebObjects.MontoInput(driver).click();
		 recarga = WebObjects.MontoInputCategory(driver).getText();
		Assert.assertEquals(WebObjects.MontoInputCategory(driver).getText(), "Recarga Saldo");
		Assert.assertEquals(WebObjects.MontoInputCategory10(driver).getText(), "Recarga $10");
		WebObjects.MontoInputCategory10(driver).click();
		Thread.sleep(2000);
		WebObjects.PaymentBtn(driver).click();
		Thread.sleep(5000);
}
	
	@Test(priority=4)
	public void PaymentMethod() throws InterruptedException{
		
		for(int i=0;i<WebObjects.PaymentMethod(driver).size();i++) {
			if(WebObjects.PaymentMethod(driver).get(i).getText().contains("Tarjeta")) {
				WebObjects.PaymentMethod(driver).get(i).click();
				break;
			}
		
	}
		
		WebObjects.PaymentMethod(driver).get(1).click();
		
	}
	
	@Test(priority=5)
	public void PaymentInnerMethod() throws InterruptedException{
		
		for(int i=0;i<WebObjects.PaymentMode(driver).size();i++) {
			if(WebObjects.PaymentMode(driver).get(i).getText().contains("Usar nueva tarjeta")) {
				WebObjects.PaymentMode(driver).get(i).click();
				break;
			}
		
	}
		WebObjects.PaymentModeRadioBtn(driver).isSelected();
		
	}
	
	@Test(priority=6)
	public void PaymentInnerMethodDetails() throws InterruptedException{
		
		WebObjects.CardNumber(driver).sendKeys("4111111111111111");
		WebObjects.Month(driver).get(1).sendKeys("11");
		WebObjects.Date(driver).get(1).sendKeys("25");
		WebObjects.CVV(driver).get(1).sendKeys("111");
		WebObjects.Email(driver).get(0).sendKeys("test@test.com");
		
	}
	
	@Test(priority=7)
	public void ClickPayment() throws InterruptedException{
		
		Assert.assertEquals(WebObjects.FinalPayment(driver).getText(), "Pagar con Tarjeta");
		WebObjects.FinalPayment(driver).click();
		Thread.sleep(5000);
		
	}
	
	@Test(priority=8)
	public void VerifyPopupWindow() throws InterruptedException{
		
		WebObjects.PopUp(driver).isDisplayed();
		Assert.assertEquals(WebObjects.PopupHeader(driver).getText(), "Para pagar por favor Regístrate o Ingresa a tu cuenta");
		Assert.assertEquals(WebObjects.PopupInnerHeader(driver).getText(), "Acceso");
		Thread.sleep(5000);
		
	}
	
	@Test(priority=9)
	public void EnterPopupWindow() throws InterruptedException{
		
		WebObjects.PopUpEmailInput(driver).sendKeys("automationUDT1@gmail.com");
		WebObjects.PopUpPasswordInput(driver).sendKeys("automationUDT123");
		WebObjects.PopupRobotCheckBox(driver).click();
		Thread.sleep(2000);
		WebObjects.PopUpLoginBtn(driver).click();
		Thread.sleep(15000);
		if(WebObjects.RecentPhoneRechargePopup(driver).isDisplayed()) {
			WebObjects.RecentPhoneRechargePopupContinueBtn(driver).click();
		}
		//Thread.sleep(15000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(WebObjects.PaymentSuccessMsg(driver)));
		
	}
	
	@Test(priority=10)
	public void VerifyPayment() throws InterruptedException{
		
		Assert.assertEquals(WebObjects.PaymentSuccessMsg(driver).getText(), "¡Recarga Exitosa!");
		System.out.println(WebObjects.PaymentSuccessMsgDetails(driver).getText());
		Assert.assertEquals(WebObjects.PaymentSuccessMsgDetails(driver).getText() ,recarga +" " +"de" + " "+ operador + " " + "al número" + " " + "8465433546");
		System.out.println("Recharged successfull date:"+ WebObjects.PaymentSuccessMsgDetailsDate(driver).getText());
		Assert.assertEquals(WebObjects.PaymentSuccessMsgDetailsAmount(driver).getText(), "$10");
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException{
		
		driver.close();
		
	}
	
}

