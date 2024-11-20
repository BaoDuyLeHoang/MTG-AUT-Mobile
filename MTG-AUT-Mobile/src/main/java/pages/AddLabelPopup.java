package pages;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddLabelPopup extends BasePage{

	public AddLabelPopup(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how =How.ID,using="android:id/button1")
	private WebElement oKButton;
	
	@FindBy(how =How.ID,using="android:id/text1")
	private WebElement labelNameTextbox;
	
	public void tabOK() {
		this.tapByElement(oKButton);
	}
	
	public void enterTextLabelNameTextBox(String text) {
		this.enterText(labelNameTextbox, text);
	}
	
	

}
