package core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BasePage {
	protected AndroidDriver driver;
	private WebDriverWait wait;
	private WebDriverWait waitWithSpecificTimeout;
	
	public BasePage(AndroidDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		waitWithSpecificTimeout = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		PageFactory.initElements(driver, this);
	}
	
	public boolean isElementVisibility(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}
	
	public boolean isElementsVisibility(List<WebElement> elements) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public boolean isElementVisibility(WebElement element, int timeout) {
		// chờ với thời gian truyền vào (giay)
		waitWithSpecificTimeout = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			waitWithSpecificTimeout.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	public void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}
	
	 //Phương thức chạm vào element
    public void tapByElement(WebElement element) {  
    	wait.until(ExpectedConditions.elementToBeClickable(element));
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");  
        Sequence tap = new Sequence(finger, 1)  
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), element.getLocation().getX(), element.getLocation().getY()))  
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))  
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));  

        driver.perform(Collections.singletonList(tap));  
    }  
    
 // Phương thức để chạm vào tọa độ cụ thể  
    public void tapByCoordinates(int x, int y) {  
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");  
        Sequence tap = new Sequence(finger, 1)  
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))  
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))  
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));  

        driver.perform(Collections.singletonList(tap));  
    }  
    
    // Phương thức để nhấn giữ phần tử  
    public void longPressElement(WebElement element, Duration duration) {  
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");  
        Sequence longPress = new Sequence(finger, 1)  
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), element.getLocation().getX(), element.getLocation().getY()))  
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))  
                .addAction(new Pause(finger, duration))  
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));  

        driver.perform(Collections.singletonList(longPress));  
    } 
    
 // Phương thức để nhấn giữ toạ độ
    public void longPressCoordinates(int x, int y, Duration duration) {  
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");  
        Sequence longPress = new Sequence(finger, 1)  
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))  
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))  
                .addAction(new Pause(finger, duration))  
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));  

        driver.perform(Collections.singletonList(longPress));  
    } 
    
  
    
 // Phương thức để thực hiện thao tác kéo thả  
    public void swipe(int startx, int starty, int endx, int endy, Duration duration) {  
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");  
        Sequence swipe = new Sequence(finger, 1)  
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty))  
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))  
                .addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), endx, endy))  
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));  

        driver.perform(Collections.singletonList(swipe));  
    }  
    
 // Phương thức để thực hiện thao tác kéo thả lên trên  
    public void swipeMobileUp(Duration duration) {  
        Dimension size = driver.manage().window().getSize();  
        int startx = size.width / 2;  
        int starty = (int) (size.height * 0.8);  
        int endy = (int) (size.height * 0.2);  

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");  
        Sequence swipeUp = new Sequence(finger, 1)  
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty))  
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))  
                .addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), startx, endy))  
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));  

        driver.perform(Collections.singletonList(swipeUp));  
    }  
    
 // Phương thức để thực hiện thao tác kéo thả xuống dưới  
    public void swipeMobileDown(Duration duration) {  
        Dimension size = driver.manage().window().getSize();  
        int startx = size.width / 2;  
        int starty = (int) (size.height * 0.2);  
        int endy = (int) (size.height * 0.8);  

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");  
        Sequence swipeDown = new Sequence(finger, 1)  
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty))  
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))  
                .addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), startx, endy))  
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));  

        driver.perform(Collections.singletonList(swipeDown));  
    }  
    
 // Phương thức để thực hiện thao tác kéo thả từ phải sang trái  
    public void rightLeftSwipe(Duration duration) {  
        Dimension size = driver.manage().window().getSize();  
        int startX = (int) (size.width * 0.8);  
        int endX = (int) (size.width * 0.2);  
        int startY = size.height / 2;  

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");  
        Sequence swipeRightToLeft = new Sequence(finger, 1)  
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))  
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))  
                .addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), endX, startY))  
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));  

        driver.perform(Collections.singletonList(swipeRightToLeft));  
    }  
    
 // Phương thức để thực hiện thao tác kéo thả từ trái sang phải  
    public void leftRightSwipe(Duration duration) {  
        Dimension size = driver.manage().window().getSize();  
        int startX = (int) (size.width * 0.2);  
        int endX = (int) (size.width * 0.8);  
        int startY = size.height / 2;  

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");  
        Sequence swipeLeftToRight = new Sequence(finger, 1)  
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))  
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))  
                .addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), endX, startY))  
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));  

        driver.perform(Collections.singletonList(swipeLeftToRight));  
    }  
	

	
}
