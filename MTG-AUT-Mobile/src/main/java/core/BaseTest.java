package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
	private AndroidDriver driver;
	UiAutomator2Options options;
	@BeforeSuite
	public void beforeSuite() {
		options = new UiAutomator2Options()
				.setDeviceName("Medium Phone API 35")
				.setPlatformName("Android")
				.setPlatformVersion("15")
				.setAppPackage("host.exp.exponent")
				.setAppActivity("host.exp.exponent.experience.ExperienceActivity")
				.setAutomationName("UiAutomator2");
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {	 
		 driver = new AndroidDriver(
				new URL("http://127.0.0.1:4723/wd/hub"), options);
	}

	@AfterMethod
	public void afterMethod() {
		//Đóng driver sau khi test kết thúc
		if (driver != null) {
			driver.quit();
		}
	}

	public AndroidDriver getDriver() {
		return driver;
	}

}
