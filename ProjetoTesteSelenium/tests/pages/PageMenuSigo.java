package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.PageObject;

public class PageMenuSigo extends PageObject{

	@FindBy(id="item_1")
	private WebElement ItemManterGerenciaRegional;
	
	public WebElement getItemManterGerenciaRegional() {
		return ItemManterGerenciaRegional;
	}

	public void setItemManterGerenciaRegional(WebElement item_ManterGerenciaRegional) {
		this.ItemManterGerenciaRegional = item_ManterGerenciaRegional;
	}

	public PageMenuSigo(WebDriver driver){
		super(driver);
	}
}
