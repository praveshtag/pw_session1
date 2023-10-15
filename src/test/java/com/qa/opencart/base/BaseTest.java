package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {


	PlaywrightFactory pf;
	Page page;
	protected HomePage homePage;
	protected Properties prop;
	protected LoginPage loginPage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String BrowserName) {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		
		if (BrowserName != null) {
			prop.setProperty("browser", BrowserName);
		}
		
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
	}
	

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	
}
