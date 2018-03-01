package claseTres;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UdemyTest {

	static WebDriver driver=null;
	static WebElement element =null;
	static WebElement element2 =null;
	
	public UdemyTest() {
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
			driver.get("https://www.udemy.com/");
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		String name ="AAA";
		String lastname= "EEE";
		
		Wait(3);
		//1. Click to Sign in
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[4]/div[5]/require-auth/div/a")).click();
		//driver.findElement(By.xpath("//a[text()=\"Sign up\"")).click();
		
		//2. Fill information
		//Name
		driver.findElement(By.id("id_fullname")).sendKeys(name+" "+lastname);
		
		
		//E-mail
		driver.findElement(By.id("id_email")).sendKeys(name+"."+lastname+"@test.com");
		
		//Password
		driver.findElement(By.id("id_password")).sendKeys("P4ssw0rd");
		
		
		//3. Click on Sign up button
		driver.findElement(By.id("submit-id-submit")).click();

		
		Wait(10);
		//4. Log Out
		//get Initials element to hover
		element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[4]/div[6]/div[1]/a/div/div/div/span"));
		
		//get Log out element to click
		element2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[4]/div[6]/div[2]/ul[2]/li[2]/a"));
		
		//Call function to hover and click 
		MouseHoverAndClick();
		
		Wait(10);
		//5. Login again
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[4]/div[4]/require-auth/div/a")).click();
		
		//6. Fill the user information
		//E-mail
		driver.findElement(By.id("id_email")).sendKeys(name+"."+lastname+"@test.com");
		
		//Password
		driver.findElement(By.id("id_password")).sendKeys("P4ssw0rd");
		
		
		//7. Click on Sign up button
		driver.findElement(By.id("submit-id-submit")).click();


	}
	
	private static void Wait(int s) throws InterruptedException {
		Thread.sleep(s*1000);
	}
	
	//public static void MouseHoverAndClick(WebElement elementToHover, WebElement elementToClick) {
	public static void MouseHoverAndClick() {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).click(element2).build().perform();
		
	}

}
