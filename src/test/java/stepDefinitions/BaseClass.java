package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.Addcutomerpage;
import pageObjects.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public Addcutomerpage addcust;
	
	//Created for generating random email 
	public static String RandomString() {
		String generatedstring1=RandomStringUtils.randomAlphabetic(5);
		return (generatedstring1);
			}
	
}
