package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.BasePage;

public class AdminPageObjects extends BasePage{

	public AdminPageObjects(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[1]//a[1]//span[1]")
	private WebElement adminButton;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addButton;

	@FindBy(xpath = "(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]")
	private WebElement userroleDropdown;

	@FindBy(xpath = "//span[contains(text(), 'Admin')]")
	private WebElement selectAdminUserrole;

	@FindBy(xpath = "//span[contains(text(), 'ESS')]")
	private WebElement selectESSUserrole;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement empNameTextField;

	@FindBy(xpath = "//div[@role=\"option\"]//span[contains(text(), 'Jane Test Doe')]")
	private WebElement dropdownUsername;

	@FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
	private WebElement statusDropdown;

	@FindBy(xpath = "//span[contains(text(), 'Enabled')]")
	private WebElement selectEnabledStatus;

	@FindBy(xpath = "//span[contains(text(), 'Disabled')]")
	private WebElement selectDisabledStatus;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement usernameTextField;

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement usernameErrorMessage;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	private WebElement passwordTextField;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	private WebElement confirmPasswordtextField;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-form-hint']")
	private WebElement randomPlace;

	public void navigateToAdmin() {
		wait.until(ExpectedConditions.elementToBeClickable(adminButton));
		adminButton.click();
	}

	public void clickOnAdd() {
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}

	public void selectUserRole(String userrole) {
		wait.until(ExpectedConditions.elementToBeClickable(userroleDropdown));
		userroleDropdown.click();
		if (userrole.equals("Admin")) {
			wait.until(ExpectedConditions.elementToBeClickable(selectAdminUserrole));
			selectAdminUserrole.click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(selectESSUserrole));
			selectESSUserrole.click();
		}
	}

	public void addEmpName(String empName) {
		empNameTextField.sendKeys(empName);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownUsername));
		dropdownUsername.click();
	}

	public void addStatus(String status) {
		statusDropdown.click();
		if (status.equals("Enabled")) {
			wait.until(ExpectedConditions.elementToBeClickable(selectEnabledStatus));
			selectEnabledStatus.click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(selectDisabledStatus));
			selectDisabledStatus.click();
		}
	}

	public void addUsername(String userName) {
		wait.until(ExpectedConditions.elementToBeClickable(usernameTextField));
		usernameTextField.sendKeys(userName);
		wait.until(ExpectedConditions.invisibilityOf(usernameErrorMessage));
	}

	public void addPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(passwordTextField));
		passwordTextField.sendKeys(password);
	}

	public void confirmPassword(String confirmPassword) {
		wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordtextField));
		confirmPasswordtextField.sendKeys(confirmPassword);
	}

	public void clickSave() {
		saveButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
	}

}
