package claseTres;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class JavaScriptAlerts {
	
	static WebDriver driver=null;
	static WebElement element =null;

	@Before
	public void setup() {
		//Set la propiedad del gecko driver para FF
		String driver_path="C:\\Selenium\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driver_path);
		
		//Set firefox options
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--start-maximized");
		options.addArguments("disable-extensions");
		
		//call the driver
		driver = new FirefoxDriver(options);
	}
	
	@Test
	public void WindowAcceptAlertTest() throws InterruptedException {
		
		try {
			
			driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//1. Go to Frame iframeResult
		//element= driver.findElement(By.id("iframeResult"));
		//driver.switchTo().frame(element);
		driver.switchTo().frame("iframeResult");
		
		//2. Click on Try it button
		driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();
		//driver.findElement(By.xpath("/html/body/button")).click();
		Wait(5);
		
		//3. Close alert window
		driver.switchTo().alert().accept();
		
		
	}
	
	@Test
	public void WindowConfrimAlertTest() throws InterruptedException {
		
		try {
			
			driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//1. Go to Frame iframeResult
		//element= driver.findElement(By.id("iframeResult"));
		//driver.switchTo().frame(element);
		driver.switchTo().frame("iframeResult");
		
		//2. Click on Try it button
		driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();
		//driver.findElement(By.xpath("/html/body/button")).click();
		Wait(5);
		
		//3. Close alert window
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();//cancel
		
		
	}
	
	
	@Test
	public void WindowPromptAlertTest() throws InterruptedException {
		
		try {
			
			driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//1. Go to Frame iframeResult
		//element= driver.findElement(By.id("iframeResult"));
		//driver.switchTo().frame(element);
		driver.switchTo().frame("iframeResult");
		
		//2. Click on Try it button
		driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();
		//driver.findElement(By.xpath("/html/body/button")).click();
		Wait(5);
		
		//3. Close alert window
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Jud");
		Wait(2);
		driver.switchTo().alert().accept();//cancel
		
		
	}
	
	@After
	public void tearDown() { //close()
		if(driver!=null) {
			driver.quit();
		}
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	private static void Wait(int s) throws InterruptedException {
		Thread.sleep(s*1000);
	}

}
