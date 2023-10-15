package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

//1. Page Layer -> String Locators - Object Repositories
public class HomePage {
	private Page page;
	
	//1. string Locator - Object Repositories (OR)
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String myAccountLink = "span:text('My Account')";
	private String loginLink = "a:text('login')";

	//2. page constructor
	public HomePage(Page page) {
		this.page = page;		
	}
	
	//3. page actions/ methods;
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("page title: " + title);
		return title;
	}
	
	public String getHomePageURL() {
		String url =  page.url();
		System.out.println("page url :" + url);
		return url;
	}
	
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String header =  page.textContent(searchPageHeader);
		System.out.println("search header is :" +header);
		return header;
	}
	
	/*
	 * public void clickOnMyAccount() { page.click(myAccountLink); }
	 */
	
	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}	

}
