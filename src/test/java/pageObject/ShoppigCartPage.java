package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppigCartPage extends BasePage{
    public ShoppigCartPage(WebDriver driver) {
    	super(driver);
    }
    @FindBy(xpath = "//button[@aria-expanded='false']")
    @FindBy(xpath = "//div[@id='cart']")
    WebElement btnItems;
    
    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    WebElement lnkViewCart;
    
    @FindBy(xpath = "//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td")
    WebElement lblTotalPrice;
    
    @FindBy(xpath = "//a[text()='Checkout']")
    WebElement btnCheckout;
    
    public void clcikIteamsToNavigateCart() {
    	btnItems.click();
    }
    public void clcikViewCart() {
    	lnkViewCart.click();
    }
    public String getTotalPrice() {
    	return lblTotalPrice.getText();
    }
    public void clcikOnCheckout() {
    	btnCheckout.click();
    }
}
