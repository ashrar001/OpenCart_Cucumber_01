package stepsDefinations;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import junit.framework.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class LoginSteps {
   WebDriver driver;
   HomePage hp;
   LoginPage lp;
   MyAccountPage macc;
   
   List<HashMap<String,String>> datamap;
   @Given("the user navigates to login page")
   public void user_navigate_to_login_page() {
	   BaseClass.getLogger().info("Go to my account-->Click on Login..");
	   hp=new HomePage(BaseClass.getDriver());
	   hp.clcikMyAccount();
	   hp.clcikLogin();
   }
   @When("user enters email as{string} and password as {string}")
   public void user_email_as_and_password_as(String email,String pwd) {
	   BaseClass.getLogger().info("Entering email and password..");
	   lp=new LoginPage(BaseClass.getDriver());
	   lp.setEmail(email);
	   lp.setPassword(pwd);
   }
   @When("the user clciks on the Login button")
   public void clcik_on_login_button() {
	   lp.clcikLogin();
	   BaseClass.getLogger().info("clicked on login button...");
   }
   @Then("the user should be redirected to the MyAccount Page")
   public void user_navigates_to_my_account_page() {
	   macc=new MyAccountPage(BaseClass.getDriver());
	   boolean targetPage=macc.isMyAccountPageExist();
	   Assert.assertEquals(targetPage, true);
   }
   //************ Data driven Testing **************
   @Then ("the user should be redirected to the MyAccount page by passing email and password with excel row {string}")
   public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows) {
	   datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx","Sheet1");
	   int index=Integer.parseInt(rows)-1;
	   String email=datamap.get(index).get("username");
	   String pwd=datamap.get(index).get("password");
	   String exp_res=datamap.get(index).get("res");
	   lp=new LoginPage(BaseClass.getDriver());
	   lp.setEmail(email);
	   lp.setPassword(pwd);
	   lp.clcikLogin();
	   macc=new MyAccountPage(BaseClass.getDriver());
	   try {
		   boolean targetpage=macc.isMyAccountPageExist();
		   myaccpage.clickLogout();
		   Assert.assertTrue(true);
	   }
	   else {
		   Assert.assertTrue(false);
	   }
   }
   if(exp_res.equals("Invalid")) {
	   if(targetpage=true) {
		   macc.clcikLogout();
		   Assert.assertTrue(false);
	   }
	   else {
		   Assert.assertTrue(true);
	   }
   }
}
catch(Exception e) {
	Assert.assertTrue(false);
}
}
}