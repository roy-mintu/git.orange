package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;

	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Browser Opened.....");
		System.out.println(driver.getTitle());
	}

	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser Closed.....");
	}

	@Test(priority = 1)
	public void loginwithoutCreds() {
		openBrowser();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String errorMessageUsername = driver
				.findElement(By.xpath("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]"))
				.getText();
		if (errorMessageUsername.equals("Required")) {
			System.out.println("Test Case - Login Without Creds Passed!");
		} else {
			System.out.println("Test Case - Login Without Creds Failed!");
		}
		closeBrowser();
	}

	@Test(priority = 2)
	public void loginInvalidUsername() {
		openBrowser();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String errorMessage = driver
				.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"))
				.getText();

		if (errorMessage.equals("Invalid credentials")) {
			System.out.println("Test Case - Invalid Username Passed!");
		} else {
			System.out.println("Test Case - Invalid Username Failed!");
		}
		closeBrowser();
	}

	@Test(priority = 3)
	public void loginInvalidPassword() {
		openBrowser();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String errorMessage = driver
				.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"))
				.getText();

		if (errorMessage.equals("Invalid credentials")) {
			System.out.println("Test Case - Invalid Password Passed!");
		} else {
			System.out.println("Test Case - Invalid Password Failed!");
		}
		closeBrowser();
	}

	@Test(priority = 4)
	public void loginValidCreds() {
		openBrowser();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String userName = driver
				.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"))
				.getText();

		if (userName.equals("adminFirstDeltaTestFirst admin")) {
			System.out.println("Test Case - Valid Creds Passed!");
		} else {
			System.out.println("Test Case - Valid Creds Failed!");
		}
		closeBrowser();
	}
}
