package greenMobile.pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import control.elementos.ObjetosConfigAux;
import io.appium.java_client.android.AndroidDriver;

public class ListaRecoleccion {

	ObjetosConfigAux objAux;

	By vNomListaRecoleccion = By.linkText("Lista recolección");
	By bntEntendido = By.id("showcase_button_default");

	public ListaRecoleccion(ObjetosConfigAux objAux) {
		this.objAux = objAux;
	}

	public void seleccionarLst() {

		ArrayList<WebElement> lstNombre = (ArrayList<WebElement>) objAux.getDriver()
				.findElements(By.id("com.intelmovil.greenmobile:id/txt_titulo"));

		for (int i = 0; i < lstNombre.size(); i++) {

			if (lstNombre.get(i).getText().contains("Lista recolección")) {
				lstNombre.get(i).click();
				break;
			}
		}
	}
	
	public void clicEntendido () {
		
		objAux.getDriver().findElement(bntEntendido).click();
	}
	
	

	public void Listarecoleccion() throws IOException, InterruptedException {

		objAux.AdminDocPdf.generaEvidencia("Lista de Recolección", objAux.getDriver());
		seleccionarLst();
		clicEntendido();
	}

}
