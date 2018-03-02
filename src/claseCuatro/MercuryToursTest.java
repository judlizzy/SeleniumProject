package claseCuatro;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class MercuryToursTest {

	private WebDriver driver=null;
	private WebElement element =null;
	private JavascriptExecutor js;
	private Select s = null;
	private RadioButtonBorder rb = null;

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
	public void newtoursTest() {
		
		try {
			
			driver.navigate().to("http://newtours.demoaut.com/");
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Page I) Login
		
		//1. Login
		//User
		element=driver.findElement(By.name("userName"));
		element.sendKeys("mercury");
		
		//Password
		element=driver.findElement(By.name("password"));
		element.sendKeys("mercury");
		
		//2. Sign in Button
		element=driver.findElement(By.name("login"));
		element.click();	
		
		//Page II) Filter to select Flight options
		//1. Select Flight Ports
		//From
		element = driver.findElement(By.name("fromPort"));
		s=new Select(element);
		s.selectByValue("Seattle");
		
		//To
		element = driver.findElement(By.name("toPort"));
		s=new Select(element);
		s.selectByValue("Paris");
		
		
		//1. Select Flight Dates
		//Departure Month
		element = driver.findElement(By.name("fromMonth"));
		s=new Select(element);
		s.selectByValue("3");
		//Departure Day
		element = driver.findElement(By.name("fromDay"));
		s=new Select(element);
		s.selectByValue("2");
		
		//Destination Month
		element = driver.findElement(By.name("toMonth"));
		s=new Select(element);
		s.selectByValue("4");
		
		//Destination
		element = driver.findElement(By.name("toDay"));
		s=new Select(element);
		s.selectByValue("1");
		
		//3. Select First Class
		element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]"));
		element.click();
		
		
		//4. Continue
		element = driver.findElement(By.name("findFlights"));
		element.click();
		
		//Page III) Select flights
		//1. Select flights
		//Departure
		element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input"));
		element.click();
		
		//Arrival
		element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input"));
		element.click();
		
		//2. Click Continue
		element = driver.findElement(By.name("reserveFlights"));
		element.click();
		
		//Page IV) Add information
		//1. Add Passenger information
		//Name
		element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/input"));
		element.sendKeys("AAA");
		
		//Lastname
		element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"));
		element.sendKeys("AAA");
		
		//2. Select Meal
		element = driver.findElement(By.name("pass.0.meal"));
		s=new Select(element);
		s.selectByValue("VGML");
		
		//3. Scroll Down
		js.executeScript("window.scrollBy(0,500)");
		
		//4. Click on Purchase
		element = driver.findElement(By.name("buyFlights"));
		element.click();
		
		
	}

}
