package tests;

import core.BaseTest;
import core.DataProviderUtils;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LabelPageTest extends BaseTest {

	@Test()
	public void VerifyAddContactToLabel() throws InterruptedException {
		LoginPage loginPage = new LoginPage(getDriver());
		Thread.sleep(150000);

	}


}
