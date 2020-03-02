package greenMobile.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import control.elementos.ObjetosConfigAux;

public class HomePages {
	ObjetosConfigAux objAux;

	By btnNext = By.id("com.intelmovil.greenmobile:id/next");
	By btnChulo = By.id("com.intelmovil.greenmobile:id/done");
	
	public HomePages(ObjetosConfigAux objAux) {
		this.objAux = objAux;
	}

	public void clicksiguente() throws InterruptedException {

		objAux.EsperaElemento(objAux.getDriver(), btnNext, 30);
		objAux.getDriver().findElement(btnNext).click();

	}

	public void clicBtnChulo() {

		objAux.getDriver().findElement(btnChulo).click();
	}

	public void flecha() throws InterruptedException, IOException {
		clicksiguente();
		objAux.AdminDocPdf.generaEvidencia("Registro de Gestion", objAux.getDriver());
		clicksiguente();
		objAux.AdminDocPdf.generaEvidencia("Reporte de Gestión", objAux.getDriver());
		clicksiguente();
		objAux.AdminDocPdf.generaEvidencia("Captura de Evidencias", objAux.getDriver());
		clicksiguente();
		objAux.AdminDocPdf.generaEvidencia("Estamos listos", objAux.getDriver());
		clicBtnChulo();

	}
}
