package claseUno;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class BanamexTest {

	public BanamexTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Variables
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		
		//call an specific webpage
		try {
			driver.get("https://www.segurosbanamex.com.mx/segurosBanamex/seguro-auto-banamex-contratacion-paso-uno.jsp");
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		//2. Scroll
		js.executeScript("window.scrollBy(0,400)");
		
		//3. Fill Select options
		//Seleccionar una Tipo de vehiculo
		Select s = null;
		element= driver.findElement(By.id("vehiculo"));
		s=new Select(element);
		//AUTOMOVIL FRONTERIZO
		s.selectByValue("AUT");
		Wait(3);
		
		/*List<WebElement> o = s.getOptions();
		for(WebElement op: o) {
			System.out.println(op.getText());
		}*/
		
		//Seleccionar Marca
		element= driver.findElement(By.id("marca"));
		s=new Select(element);
		//AUTOMOVIL FRONTERIZO
		s.selectByValue("KI");
		Wait(3);
		
		//Seleccionar Modelo
		element= driver.findElement(By.id("modelo"));
		s=new Select(element);
		//AUTOMOVIL FRONTERIZO
		s.selectByIndex(1);
		Wait(3);
		
		//Seleccionar Descripcion
		element= driver.findElement(By.id("descripcion"));
		s=new Select(element);
		//AUTOMOVIL FRONTERIZO
		s.selectByVisibleText("KIA RIO");
		Wait(3);
		
		//Seleccionar Version
		element= driver.findElement(By.id("version"));
		s=new Select(element);
		//AUTOMOVIL FRONTERIZO
		s.selectByVisibleText("KIA RIO EX PACK L4 1.6 QC AUT");
		Wait(3);
		

		//4. Scroll
		js.executeScript("window.scrollBy(0,500)");	
		
		//5. Fill Input Texts
		//Add Codigo Postal
		element= driver.findElement(By.id("postal"));
		element.sendKeys("20230");
		Wait(3);
		
		//Add Numero Cliente
		element= driver.findElement(By.id("numeroCliente"));
		element.sendKeys("123");
		Wait(3);
		
		//Add Nombre				
		element= driver.findElement(By.id("nombres"));
		element.sendKeys("AAAA");
		Wait(3);
		
		//Add Correo Electronico
		element= driver.findElement(By.id("correoElectronico"));
		element.sendKeys("aaa@test.com");
		Wait(3);
		
		//Add Apellido Paterno
		element= driver.findElement(By.id("apellidoPaterno"));
		element.sendKeys("AAAA");
		Wait(3);
		
		//Add Telefono
		element= driver.findElement(By.id("telefono"));
		element.sendKeys("1111111111");
		Wait(3);
		
		//Add Apellido Materno
		element= driver.findElement(By.id("apellidoMaterno"));
		element.sendKeys("AAAA");
		Wait(3);
		
		//6. Llenar Captcha
		//Add Captcha text
		element= driver.findElement(By.id("ingresatexto"));
		element.sendKeys("AAA23A");
		Wait(3);
		
		//7. Selecciona aviso se privacidad
		//seleccionar CheckBox
		element= driver.findElement(By.name("avisoPrivacidad"));
		element.click();
		Wait(3);
		
		//8. Boton de Continuar
		//Click en Boton
		driver.findElement(By.id("continuarButton")).click();
		//element.sendKeys(Keys.TAB);
		//element.sendKeys(Keys.ENTER);
		
		
		
	}
	
	private static void Wait(int s) throws InterruptedException {
		Thread.sleep(s*1000);
	}

}
