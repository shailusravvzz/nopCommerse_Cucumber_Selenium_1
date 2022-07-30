package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.Addcutomerpage;
import pageObjects.LoginPage;

public class Steps extends BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public Addcutomerpage addcust;

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_URL(String string) {

		driver.get("http://admin-demo.nopcommerce.com/login");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String Email, String Password) {
		lp.setUserName(Email);
		lp.setPassword(Password);

	}

	@When("Click on Login")
	public void click_on_Login() throws Exception {
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws Exception {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();

	}

	// adding customer

	@Then("use can view Dashboard")
	public void use_can_view_Dashboard() {
		addcust = new Addcutomerpage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws Exception {
		addcust.clickOnCustomersMenu();
		Thread.sleep(3000);
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() {
		addcust.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() {
		addcust.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws Exception {

		String email = RandomString() + "@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("Test123");
		addcust.setCustomerRoles("Guest");
		Thread.sleep(3000);

		addcust.setManagerOfVendor("Vendor 1");
		addcust.setGender("Male");
		addcust.setFirstName("Shailendar");
		addcust.setLastName("Gannarapu");
		addcust.setDob("7/05/1985");
		addcust.setCompanyName("BusyQA");
		addcust.setAdminContent("This is for testing");
	}

	@When("click on Save button")
	public void click_on_Save_button() throws Exception {
		addcust.clickOnSave();
		Thread.sleep(3000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String messgae) {

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));

	}

}
