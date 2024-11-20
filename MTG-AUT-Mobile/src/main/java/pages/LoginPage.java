package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LoginPage extends BasePage {

	public LoginPage(AndroidDriver driver) {
		super(driver);
	}
	
	@FindBy(how =How.XPATH,using="//android.widget.EditText[contains(@text, 'Nhập số điện thoại')]")
	private WebElement phone;
	
	@FindBy(how =How.XPATH,using="//android.widget.EditText[contains(@text, 'Nhập mật khẩu')]")
	private WebElement password;
	
	@FindBy(how =How.XPATH,using="//android.view.ViewGroup[@content-desc='Đăng nhập']")
	private WebElement loginBtn;

	@FindBy(how =How.XPATH,using="//android.view.ViewGroup[@content-desc='Quên mật khẩu?']/android.widget.TextView")
	private WebElement forgotBtn;

	@FindBy(how =How.XPATH,using="//android.view.ViewGroup[@content-desc='Đăng ký']/android.widget.TextView")
	private WebElement registerBtn;


	
	public void inputPhone(String _phone) {
		this.enterText(phone, _phone);
	}

	public void inputPassword(String _password) {
		this.enterText(password, _password);
	}

	public void tapLabel() {
		this.tapByElement(loginBtn);
	}
	
	
}
