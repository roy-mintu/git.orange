package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
	protected WebDriver driver;
	protected static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeMethod
	@Parameters("browser")
	public void setUpClass(@Optional ("chrome") String browser) {
		driver = DriverFactory.createWebDriver(browser);
		driver.manage().window().maximize();
		System.out.println("Browser Opened...");
	}

	@AfterMethod
	public void tearDownClass() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser Closed...");
		}
	}
}
