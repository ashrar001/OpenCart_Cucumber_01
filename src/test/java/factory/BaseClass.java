package factory;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v128.runtime.Runtime.GetPropertiesResponse;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	static WebDriver driver;
	static Properties p;
	static Logger logger;

public static WebDriver initilizeBrowser()throws IOException
{
	if(getProperties().getProperty("execution_env").equalIgnoreCase("remote")) {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		if(getProperties().getProperty("os")).equalIgnoreCase("windows"){
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(getProperties().getProperty("os").equalIgnoreCase("mac")) {
			capabilities.setPlatform(Platform.MAC);
		}
		else {
			System.out.println("no matchhing os..");
		}
	
	
		switch(getProperties().getProperty("browser").toLowerCase()) {
		case "chrome":
			capabilities.setBrowserName("chrome");
			break;
			capabilities.setBrowserName("MicrosoftEdge");
			break;
			capabilities.setBrowserName("firefox");
			break;
			default:
				System.out.println("no matching Browser");
		}
		driver=new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"),capabilities);
	}
	else if(getProperties().getProperty("execution_env").equalIgnoreCase("local")) {
		switch(getProperties().getProperty("browser").toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
		default:
			System.out.println("no matching browser");
			driver=null;
		}
		
	}
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	return driver;
}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		return p;
	}

	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public static String randomNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public static String randomAlphaNumerice() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return generatedString;
	}

	public static String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return str + num;
	}
}
