package claseDos;

import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Position;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrbitzTest {
	
	static WebDriver driver=null;
	static WebElement element =null;

	public OrbitzTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
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
		
		//set size for smartphones window
		//Dimension d = new Dimension(375,667);
		//driver.manage().window().setSize(d);
		
		//driver.manage().window().maximize();
		
		//Variables
		//WebDriverWait varWait = new WebDriverWait(driver,10);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		Select s = null;
		
		//1. Call an specific webpage		
		try {
			driver.get("http://www.orbitz.com");
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		//Leave the package option selected
		
		//Leave the Flight + Hotel option selected
		
		//2. Fill the Origin flight information
		element= driver.findElement(By.id("package-origin"));
		element.clear();
		element.sendKeys("Monterrey");
		//varWait.until(ExpectedConditions.textToBePresentInElement(element, "Monterrey"));
		Wait(2);
		element.sendKeys(Keys.ENTER);
		
		
		//3. Fill the Destination flight
		element= driver.findElement(By.id("package-destination"));
		element.clear();
		element.sendKeys("Mexico");
		Wait(2);
		element.sendKeys(Keys.ENTER);
		
		
		//4. Click on Departure Date of flight
		//Select the Departure Date of flight - By xpath
		element= driver.findElement(By.xpath("/html/body/section/div/div/div/section/div[1]/div/div/div/form/div/section/div/fieldset[3]/div[1]/label/span[2]"));
		element.click();
		element= driver.findElement(By.xpath("/html/body/section/div/div/div/section/div[1]/div/div/div/form/div/section/div/fieldset[3]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[6]/button"));
		element.click();
		
		//Select the Departure Date of flight - by text
		/*element= driver.findElement(By.id("package-departing"));
		//element.clear();
		element.sendKeys("03/02/2018");*/
		
		//5. Click on Returning Date of flight - by text
		//Select the Returning Date of flight
		element= driver.findElement(By.id("package-returning"));
		element.clear();
		element.sendKeys("03/06/2018");
		//Wait(2);
		//element.sendKeys(Keys.ENTER);
		
		//6.Select 1 adult
		element= driver.findElement(By.id("package-1-adults"));
		s=new Select(element);
		s.selectByValue("1");
		
		//7. Click Enter
		Wait(3);
		driver.findElement(By.id("search-button")).click();
		
		//II) Page 2 -  Select Hotel
		
		//Select first result
		Wait(5);
		//element= driver.findElement(By.cssSelector("#resultsContainer article:nth-child(2) a"));
		//element = driver.findElement(By.cssSelector(".flex-link:nth-child(1) a"));
		element= driver.findElement(By.xpath("/html/body/div[4]/form/div[11]/div[2]/div[12]/section/div/div[17]/section/article[1]/div[2]/div[1]/a"));
		element.click();
		
		//III) Page 3 -  Select Room
		//1. switch focus on new window
		Wait(5);
		SwitchToWindows();
		
		//2. Scroll
		Wait(5);
		js.executeScript("window.scrollBy(0,600)");
		
		
		//Select first room option
		//element= driver.findElement(By.cssSelector(".btn-secondary btn-action t-select-btn"));
		Wait(5);
		element= driver.findElement(By.xpath("/html/body/div[4]/div[6]/section/section[2]/article[2]/div/div/div[2]/div[2]/a"));
		element.click();
		
		//IV) Page 4 -  Select Departure to Mexico
		//Select Departure to Mexico
		Wait(5);
		element= driver.findElement(By.xpath("/html/body/div[2]/div[6]/section/div[7]/ul/li[1]/div/div[1]/div[2]/div/div[2]/button"));
		element.click();
		
		//V) Page 5 -  Select Return to Monterrey 
		//Select Return to Monterrey 
		Wait(5);
		element= driver.findElement(By.xpath("/html/body/div[2]/div[6]/section/div[7]/ul/li[1]/div/div[1]/div[2]/div/div[2]/button"));
		element.click();
		
		//V) Page 6 -  Select Continue Booking
		//1. Scroll
		Wait(5);
		js.executeScript("window.scrollBy(0,200)");
				
		//2. Select Continue Booking
		Wait(5);
		element= driver.findElement(By.xpath("/html/body/div[7]/aside/footer/div/div[2]/button"));
		element.click();
		
		//V) Page 6 -  Review and Book
		//1. Scroll
		Wait(5);
		js.executeScript("window.scrollBy(0,500)");
		
		//2. Select the Title
		element= driver.findElement(By.xpath("/html/body/div[7]/div[1]/section/div[5]/section[1]/section[1]/article/fieldset/div[2]/div/div/fieldset[1]/label[1]/select"));
		s=new Select(element);
		s.selectByValue("4_Miss");
		
		//3. Fill the First Name
		element= driver.findElement(By.id("firstname[0]"));
		element.clear();
		element.sendKeys("AAA");

		//4. Fill the Middle Name
		/*element= driver.findElement(By.xpath("/html/body/div[7]/div[1]/section/div[5]/section[1]/section[1]/article/fieldset/div[2]/div/div/fieldset[1]/label[3]/input"));
		element.clear();
		element.sendKeys("AAA");*/
		
		//5. Fill the Last Name
		element= driver.findElement(By.id("lastname[0]"));
		element.clear();
		element.sendKeys("AAA");
		
		//6. Leave united states selected
		
		//7. Fill the phone number
		element= driver.findElement(By.xpath("/html/body/div[7]/div[1]/section/div[5]/section[1]/section[1]/article/fieldset/div[2]/div/div/label[2]/input"));
		element.clear();
		element.sendKeys("1111111111");
		
		
		//8. Select Date
		//Month
		element= driver.findElement(By.xpath("/html/body/div[7]/div[1]/section/div[5]/section[1]/section[1]/article/fieldset/div[2]/div/div/fieldset[2]/label[1]/select"));
		s=new Select(element);
		s.selectByValue("02");
		
		//Day
		element= driver.findElement(By.xpath("/html/body/div[7]/div[1]/section/div[5]/section[1]/section[1]/article/fieldset/div[2]/div/div/fieldset[2]/label[2]/select"));
		s=new Select(element);
		s.selectByValue("27");
		
		//Year
		element= driver.findElement(By.xpath("/html/body/div[7]/div[1]/section/div[5]/section[1]/section[1]/article/fieldset/div[2]/div/div/fieldset[2]/label[3]/select"));
		s=new Select(element);
		s.selectByValue("1990");
		
		//9. Scroll down
		Wait(5);
		//js.executeScript("window.scrollBy(0,400)");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//10. Click on Complete Booking
		Wait(3);
		driver.findElement(By.id("complete-booking")).click();
		
		
		
	}
	
	private static void Wait(int s) throws InterruptedException {
		Thread.sleep(s*1000);
	}
	
	
	private static void SwitchToWindows() {
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

}
