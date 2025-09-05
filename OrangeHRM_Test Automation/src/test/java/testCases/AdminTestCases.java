package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AdminPageObjects;
import pageObjects.LoginPageObjects;
import testBase.BaseTest;

public class AdminTestCases extends BaseTest {

	AdminPageObjects adminpage;
	LoginPageObjects login;

	@BeforeMethod
	public void init() {
		login = new LoginPageObjects(driver);
		adminpage = new AdminPageObjects(driver);
		login.open(BASE_URL);
		login.login("admin", "admin123");
	}

	@Test(description ="Admin User Should be Added...")
	public void addUser() {
		adminpage.navigateToAdmin();
		adminpage.clickOnAdd();
		adminpage.selectUserRole("Admin");
		adminpage.addEmpName("Jane Test Do");
		adminpage.addStatus("Enabled");
		adminpage.addUsername("Test Jay 3");
		adminpage.addPassword("Test123");
		adminpage.confirmPassword("Test123");
		adminpage.clickSave();
	}
}
