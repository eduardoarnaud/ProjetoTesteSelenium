package ManterGerenciaRegional;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IncluirGerenciaRegional {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Eduardo\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://187.86.29.117/";
		//baseUrl = "http://desenv.cagepa.pb.gov.br/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}

	@Test
	public void testIncluigerenciaregional() throws Exception {
		String log="";
		driver.get(baseUrl + "/scriptcase/app/SIGO/sigo_menu/");
	    driver.findElement(By.cssSelector("#item_5 > span")).click();
	    
	    //JavascriptExecutor � usado para executar fun��es JS
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("openMenuItem('sigo_menu_item_1')", log);
	    
	    driver.switchTo().frame("sigo_menu_item_1_iframe");
	    Thread.sleep(1000);
	    driver.findElement(By.id("sc_b_new_top")).click();
	    Thread.sleep(1000);
	    
	    WebElement sigla = driver.findElement(By.id("id_sc_field_sigla"));
	    sigla.clear();
		sigla.sendKeys("GRTE");
		Thread.sleep(1000);
		
		WebElement nome = driver.findElement(By.id("id_sc_field_nome"));
	    nome.clear();
		nome.sendKeys("GER�NCIA REGIONAL DO TESTE");
		Thread.sleep(1000);
		
	    driver.findElement(By.id("sc_b_ins_t")).click();
	    Thread.sleep(1000);
	    
	    driver.switchTo().alert().accept();
	    System.out.println(driver.findElement(By.id("resposta_cadastro")).getText());
	    
	    assertTrue(driver.findElement(By.id("resposta_cadastro")).getText().matches("^[\\s\\S]*Ger�ncia Regional cadastrada com sucesso![\\s\\S]*$"));
	    
	    Thread.sleep(5000);
	    driver.findElement(By.name("Bmens")).click();

	}

}
