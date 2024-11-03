package stepsDefinations;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

public class RegristrationSteps {
WebDriver driver;
HomePage hp;
LoginPage lp;
AccountRegistrationPage regpage;
@Given("the user navigates to Register Account page")
public void user_navigates_to_register_account_page() {
	hp=new HomePage(BaseClass.getDriver());
	hp.clcikMyAccount();
	hp.clickRegister();
}
@When("the user enters the details into below fields")
public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	Map<String,String>dataMap=dataTable.asMap(String.class,String.class);
	regpage=new AccountRegistrationPage(BaseClass.getDriver());
	regpage.setFirstName(dataMap.get("firstName"));
	regpage.setLastName(dataMap.get("lastName"));
	regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
	regpage.setTelephone(dataMap.get("telephone"));
	regpage.setPassword(dataMap.get("password"));
	regpage.setConfirmPass(dataMap.get("password"));
			
}
@When("the user select Privacy Policy")
public void user_selects_privacy_policy() {
	regpage.setPrivacyPolicy();
}
@When("the user clicks on Continue button")
public void user_clciks_on_continue_button() {
	regpage.clickContinue();
}
@Then("the user account should  get created sucessfully")
public void user_account_should_get_created_sucessfully() {
	String confmsg=regpage.getConfirmationMsg();
	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
}
}
