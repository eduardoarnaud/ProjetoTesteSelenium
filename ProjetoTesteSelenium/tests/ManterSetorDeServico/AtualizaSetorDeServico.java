package ManterSetorDeServico;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AtualizaSetorDeServico {

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
	public void testAtualizaSetorDeServico() throws Exception {
		
		driver.get(baseUrl + "/scriptcase/app/SIGO/sigo_menu/");
	    
	    //JavascriptExecutor � usado para executar fun��es JS
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("openMenuItem('sigo_menu_item_2')", "");
	    
	    driver.switchTo().frame("sigo_menu_item_2_iframe");
	    Thread.sleep(2000);
	    driver.findElement(By.id("id_img_bedit")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("sc_b_upd_t")).click();
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
	    System.out.println(driver.findElement(By.id("resposta_cadastro")).getText());
	    
	    assertTrue(driver.findElement(By.id("resposta_cadastro")).getText().matches("^[\\s\\S]*Setor atualizado com sucesso![\\s\\S]*$"));
	    
	}

}
