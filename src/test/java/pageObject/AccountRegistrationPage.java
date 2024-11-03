package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
    public AccountRegistrationPage(WebDriver driver) {
    	super(driver);
    }
    //Elements
    @FindBy(name="firstname")
    WebElement txtFirstname;
    
    @FindBy(name="lastname")
    WebElement txtLastname;
    
    @FindBy(name="email")
    WebElement txtEmail;
    
    @FindBy(name="telephone")
    WebElement txtTelephone;
    
    @FindBy(name="password")
    WebElement txtPassword;
    
    @FindBy(name="confirm")
    WebElement txtConfirmPassword;
    
    @FindBy(name="agree")
    WebElement chkdPolicy;
    
    @FindBy(xpath = "//input[@value='continue']")
    WebElement btnContinue;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
    
    public void setFirstName(String fname) {
    	txtFirstname.sendKeys(fname);
    }
    public void lastName(String lname) {
    	txtLastname.sendKeys(lname);
    }
    public void setEmail(String email) {
    	txtEmail.sendKeys(email);
    }
    public void setTelephone(String tel) {
    	txtTelephone.sendKeys(tel);
    }
    public void setPassword(String pwd) {
    	txtPassword.sendKeys(pwd);
    }
    public void setConfirmPass(String pwd) {
    	txtConfirmPassword.sendKeys(pwd);
    }
    public void setPrivacyPolicy() {
    	chkdPolicy.click();
    }
    public void clickContinue() {
    	btnContinue.click();
    }
    public String getConfirmationMsg() {
    	try {
    		return(msgConfirmation.getText());
    	}
    	catch (Exception e) {
			return(e.getMessage());
		}
    }
}
