package ZeynepDinc.EvamSoftware;

import javax.security.auth.login.FailedLoginException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {
	protected WebDriver driver;
	protected String nameTxt;
	protected String numberTxt;
	protected String companyTxt;
	protected String emailTxt;
	protected String adressBarTxt;
	protected String contactMenu;
	protected String sendButton;
	protected void beklemeSuresi(long time) throws InterruptedException {
		Thread.sleep(time);
	}
	
	protected String getContactMenu() {
		return "//*[@id=\"menu-item-2015\"]/a/span";
	}
	protected void setContact(String contactMenu) {
		this.contactMenu=contactMenu;
	}
	
	protected String getNameTxt() {
		return "//*[@id=\"responsive-form\"]/div[1]/div[1]/span/input";
	}
	protected void setNameTxt(String nameTxt) {
		this.nameTxt = nameTxt;
	}

	protected String getNumberTxt() {
		return "//*[@id=\"responsive-form\"]/div[2]/div[1]/span/input";
	}
	protected void setNumberTxt(String numberTxt) {
		this.numberTxt = numberTxt;
	}
	
	protected String getSendButton() {
		return "//*[@id=\"responsive-form\"]/div[4]/div[2]/input";
	}

	protected String getCompanyTxt() {
		return "//*[@id=\"responsive-form\"]/div[2]/div[2]/span/input";
	}
	protected void setCompanyTxt(String companyTxt) {
		this.companyTxt = companyTxt;
	}



	protected String getEmailTxt() {
		return "//*[@id=\"responsive-form\"]/div[1]/div[2]/span/input";
	}
	protected void setEmailTxt(String emailTxt) {
		this.emailTxt = emailTxt;
	}



	protected String getAdressBarTxt() {
		return "//*[@id=\"responsive-form\"]/div[3]/div/span/textarea";
	}
	protected void setAdressBarTxt(String adressBarTxt) {
		this.adressBarTxt = adressBarTxt;
	}


	protected WebElement xPath(String xpath) {
		return   driver.findElement(By.xpath(xpath));
	}
	
	protected void xPathClick(String xpath){
		xPath(xpath).click();
	}
	
	protected void xPathSendKey(String xpath,String message){
		xPath(xpath).sendKeys(message);
	}
	
}
