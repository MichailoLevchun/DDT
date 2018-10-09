package com.epam.lab.selen4.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetterTypePage {
	final static Logger LOG = Logger.getLogger(LetterTypePage.class);
    @SuppressWarnings("unused")
	private WebDriver driver;
     
    @FindBy(css = "div.T-I.J-J5-Ji.T-I-KE.L3")
    private WebElement newLetter;
    @FindBy(css = "div.wO.nr.l1 > textarea")
    private WebElement letterMail;
    @FindBy(css = "input.aoT")
    private WebElement letterTheme;
    @FindBy(xpath = "//div[@role = 'textbox']")
    private WebElement letterText;
    @FindBy(css="img.Ha")
    private WebElement draftButton;

    
    public LetterTypePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
     
    public void clickNewLetter(){
    	newLetter.click();
    	LOG.info("New letter window is opened");
    }
    public void inputLetterEmail(){
    	letterMail.sendKeys("abbad5431");
    	LOG.info("Email is inputed");
    }
    
    public void inputLetterTheme(){
    	letterMail.sendKeys("Tema dlya lysta");
    	LOG.info("Theme is inputed");
    }
    
    public void inputLetterText(){
    	letterMail.sendKeys("Ya mayu kota");
    	LOG.info("Text is inputed");
    }
}
