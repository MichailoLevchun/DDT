package com.epam.lab.selen4.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GmailLoginPage {
	final static Logger LOG = Logger.getLogger(GmailLoginPage.class);
    @SuppressWarnings("unused")
	private WebDriver driver;
     
    @FindBy(id = "identifierId")
    private WebElement mail;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(css = "a[aria-label='Обліковий запис Google: Дон Кіхот  (abbad5431@gmail.com)'']")
    private WebElement logoutBar;
    @FindBy(xpath = "a[text()='Вийти']")
    private WebElement logoutButton;
    
    public GmailLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
     
    public void inputEmail(){
    	mail.sendKeys("abbad5431" + Keys.ENTER);
    	LOG.info("Email is inputed");
    }
    
    public void inputPassword(){
    	mail.sendKeys("123rty789" + Keys.ENTER);
    	LOG.info("Password is inputed");
    }
    
    public void logout(){
    	logoutBar.click();
    	logoutButton.click();
    }
   
}
