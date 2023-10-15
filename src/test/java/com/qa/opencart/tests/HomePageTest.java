package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class HomePageTest extends BaseTest{

	
	@Test
	public void homePageTitleTest() {
		String actualtitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualtitle, AppConstants.HOME_PAGE_TITLE);
	}
	  
	@Test
	public void homePageURLTest() {
		String actualurl = homePage.getHomePageURL();
		Assert.assertEquals(actualurl, prop.getProperty("url").trim());
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"macbook"},
			{"imac"},
			{"samsung"}
		};
	}
	
	@Test(dataProvider = "getProductData")
	public void searchTest(String productName) {
		String actualTestHeader = homePage.doSearch(productName);
		Assert.assertEquals(actualTestHeader, "Search - " + productName);
	}
	
}
