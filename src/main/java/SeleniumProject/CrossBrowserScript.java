package SeleniumProject;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;

	public class CrossBrowserScript {

		  WebDriver driver;
		
		@SuppressWarnings("deprecation")
		public void setup(String browser) throws Exception{
			
			//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){

				System.setProperty("webdriver.gecko.driver", "D:\\selenium files\\src\\main\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){

				System.setProperty("webdriver.chrome.driver", "D:\\selenium files\\src\\main\\resources\\chromedriver.exe");
				
				driver = new ChromeDriver();			}
			
			//Check if parameter passed as 'Edge'
					else if(browser.equalsIgnoreCase("Edge")){

						System.setProperty("webdriver.edge.driver","D:\\selenium files\\src\\main\\resources\\msedgedriver.exe");
						//create Edge instance
						driver = new EdgeDriver();
					}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		
		
	}
	
	
	

