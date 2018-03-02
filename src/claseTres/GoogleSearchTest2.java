package claseTres;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GoogleSearchTest2 {

	public GoogleSearchTest2() {
		// TODO Auto-generated constructor stub
	}

public static void main (String[] args){
		
		WebDriver driver=null;
		WebElement element =null;
		
		//Set la propiedad del gecko driver para FF
		String driver_path="C:\\Selenium\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driver_path);
		
		//Set firefox options
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--start-maximized");
		options.addArguments("disable-extensions");
		
		//call the driver
		driver = new FirefoxDriver(options);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//call an specific webpage
		try {
			driver.get("http://www.google.com");
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		//2.1 Type Hexaware
		//driver.findElement(By.id("lst-ib")).sendKeys("Hexaware");
		//2.2. Click Enter
		//driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		//3. Click en buscar
		//driver.findElement(By.name("btnk")).click();
		
		element= driver.findElement(By.id("lst-ib"));
		element.sendKeys("Hexaware");
		element.sendKeys(Keys.ENTER);
		
		//Click Hexaware fist link
		//Hexaware - IT, BPO, Consulting and Next-Generation Services
		element = driver.findElement(By.partialLinkText("Hexaware - IT, BPO, "));
		element.click();
		
		//Click link by class
		//element = driver.findElements(By.tagName("a")).get(2);
		//element.click();
		
		
	}

	
	private static void Wait(int s) throws InterruptedException {
		Thread.sleep(s*1000);
	}

}
