package com.epam.lab.selen4.PageObject;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailDraftPage {
	final static Logger LOG = Logger.getLogger(GmailDraftPage.class);
	@SuppressWarnings("unused")
	private WebDriver driver;
	@FindBy(css = "*[href='https://mail.google.com/mail/u/0/#drafts']")
	private WebElement draftLink;
	@FindBy(xpath = "//*[@role='main']//tr[contains(@class, 'zA') and contains(@class ,'yO')]")
	private WebElement draftLetter;
	@FindBy(css = "div.T-I.J-J5-Ji.aoO.T-I-atl.L3")
	private WebElement sendLetter;

	public GmailDraftPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clicDraft() {
		draftLink.click();
		LOG.info("Draft link is opened");
	}

	public void openDraftLetter() {
		draftLetter.click();
		LOG.info("Draft letter is opened");
	}

	public void sendLetter() {
		sendLetter.click();
		LOG.info("Letter is sent");
	}
}
