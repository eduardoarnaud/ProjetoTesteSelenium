package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {

	private WebDriver driver;

	public PageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void clicarNoBotao(WebElement e) {
		e.click();
	}
	
	public void inserirTexto(WebElement e, String texto) {
		e.clear();
		e.sendKeys(texto);
	}
	
	public boolean existeTextoNaPagina(String texto) {
		WebElement e = driver.findElement(By.cssSelector("BODY"));
		return e.getText().matches("^[\\s\\S]*"+texto+"[\\s\\S]*$");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
}
