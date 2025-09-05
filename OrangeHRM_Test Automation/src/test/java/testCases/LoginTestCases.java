package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import testBase.BaseTest;

public class LoginTestCases extends BaseTest {

	private LoginPageObjects login;
	
	@BeforeMethod
	public void init() {
		login = new LoginPageObjects(driver);
		login.open(BASE_URL);
	}

	@Test(priority = 1)
	public void validLogin() {

		System.out.println("Test 1 Started...");

		login.login("admin", "admin123");

		Assert.assertEquals(login.getDashboardText(), "Dashboard");

		System.out.println("Test 1 Completed...");
	}

	@Test(priority = 2)
	public void invalidUsername() {
		System.out.println("Test 2 Started...");

		login.login("Test", "admin123");

		Assert.assertEquals(login.getInvalidCredsError(), "Invalid credentials");

		System.out.println("Test 2 Completed...");
	}

	@Test(priority = 3)
	public void invalidPassword() {

		System.out.println("Test 3 Started...");

		login.login("admin", "admin");

		Assert.assertEquals(login.getInvalidCredsError(), "Invalid credentials");

		System.out.println("Test 3 Completed...");
	}

	@Test(priority = 4)
	public void blankCreds() {
		System.out.println("Test 4 Started...");

		login.login("", "");

		Assert.assertEquals(login.getEmptyUsernameError(), "Required");

		System.out.println("Test 4 Completed...");
	}
}
