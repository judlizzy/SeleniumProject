package claseCuatro;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class ManulifeTest {

	private WebDriver driver=null;
	private WebElement element =null;
	private JavascriptExecutor js;
	private Select s = null;

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
		
		js = ((JavascriptExecutor)driver);
	}
	
	@Test
	public void ManuLifeRegistration() throws InterruptedException{
		try {
					
					driver.navigate().to("https://www.manulife.ca/for-you.html");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//1. Select option
		//click on Sign In Button
		element = driver.findElement(By.xpath("//span[text()=\"Sign In\"]"));
		element.click();
		
		//Click on My ManuLife Vitality
		element = driver.findElement(By.xpath("/html/body/header/nav/div/div[1]/ul[2]/li[4]/div/div/div/div[2]/div/div[3]/a[1]"));
		element.click();
		
		//2. Change Window
		Wait(3);
		SwitchToWindows();
		
		//3. Fill information
		Wait(3);
		//Email
		element = driver.findElement(By.id("input-username"));
		element.sendKeys("AAA@test.com");
		
		//Password
		element = driver.findElement(By.id("input-password"));
		element.sendKeys("AAAAAAAA");
		
		//Click on Sign In
		/*element = driver.findElement(By.xpath("//button[text()=\"Sign In\"]"));
		element.click();
		
		
		//Close alert message pop up
		Wait(10);
		element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/button"));
		element.click();*/
		
		//4. Scroll Down
		Scroll(0,300);
		
		
		//5. Click on register
		///html/body/div/div/div[1]/div[2]/div[2]/div/form/div[6]/ul/li[2]/a
		element = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[6]/ul/li[2]/a"));
		//element = driver.findElement(By.xpath("//a[contains()=\"Click here to register\"]"));
		element.click();
		
		//6. Scroll down
		Wait(3);
		Scroll(0,300);
		
		//7. Fill information
		//Name
		element = driver.findElement(By.id("input-firstName"));
		element.sendKeys("AAA");
		
		//Lastname
		element = driver.findElement(By.id("input-lastName"));
		element.sendKeys("AAA");
		
		//ZipCode
		element = driver.findElement(By.id("input-postal"));
		element.sendKeys("A1A"); //A1a,1A1,12345,12345-6789
		
		//Date
		//Day
		element = driver.findElement(By.id("appForms.identify.dob-day-input"));
		element.sendKeys("1");
		
		//Month
		element = driver.findElement(By.id("appForms.identify.dob-month-input"));
		s=new Select(element);
		s.selectByValue("3");
		
		//Year
		element = driver.findElement(By.id("appForms.identify.dob-year-input"));
		element.sendKeys("1990");
		
		//Select Next Button
		///html/body/div/div/div[1]/div[2]/div/div/div/form/div[3]/div/button
		element = driver.findElement(By.xpath("//button[text()=\"Next\"]"));
		element.click();
		
	}
	
	private void Scroll(int x, int y) {
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	private WebElement getElement(String locatorType, String locator) {
		switch(locatorType) {
		case "id":
			element = driver.findElement(By.id(locator));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locator));
			break;
		default:
			break;
		}
		
		return element;
	}
	
	
	private void SwitchToWindows() {
		String currWin = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		
		handles.remove(currWin);
		
		for(String winHandle : handles) {
			if(!currWin.equals(winHandle)) {
				System.out.println(currWin);
				System.out.println(driver.getTitle());
				//driver.close(); //close current window
				
				String child= winHandle;
				System.out.println(child);
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
			}
		}
		
	}
	
	private static void Wait(int s) throws InterruptedException {
		Thread.sleep(s*1000);
	}
}
