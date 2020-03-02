package greenMobile.pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import control.elementos.ObjetosConfigAux;

public class DetalleRecoleccion {

	ObjetosConfigAux objAux;

	By bntClienteYanbal = By.id("com.intelmovil.greenmobile:id/txt_cliente");
	By bntRecoleccion = By.id("btn_recoleccion");
	By btnManifiesto = By.id("popupManifiest");
	By btnNumeromanifiesto = By.id("txt_numero_manifiesto");
	By btnConsultar = By.id("btn_consultar");
	By btnGuias = By.id("txt_cantidad_guias");
	By btnSiguiente = By.id("btn_siguiente");
	By btnConfirmarrecoleccion = By.id("btn_confirmar_recoleccion");
	By btnAceptar = By.id("button1");
	By btnNorecoleccion = By.id("btn_no_recoleccion");
	By BtnSelecccione = By.xpath("//*[@text='Seleccione…']");
	By txtMotivonorecolección = By.xpath("//*[@text='5: No cumple envio optimo']");
	By textObservacion = By.id("txt_observacion_no_recoleccion");
	By btnConfirmarnorecoleccion = By.id("btn_confirmar_no_recoleccion");
	By btnNorecoleccionUnificada = By.id("btn_no_recoleccion_unificada");
	
	By btndesseleccion = By.id("btn_check_box");
	By btnGuiadesseleccion = By.id("txt_numero_guia");
	By btnEvidencias = By.xpath("//*[@text='Evidencias']");
	By bntNorecoleccionUnificada = By.id("btn_recoleccion_unificada");
	By btnBack = By.xpath("//*[@class='android.widget.ImageButton']");
	By bntfirma = By.id("btn_tomar_firma");
	
	
	public DetalleRecoleccion(ObjetosConfigAux objAux) {
		this.objAux = objAux;
	}

	public void clikcliente() {

		objAux.getDriver().findElement(bntClienteYanbal).click();
	}

	public void clicrecoleccion(String numeromanifesto) throws IOException {
		objAux.getDriver().findElement(bntRecoleccion).click();
		objAux.AdminDocPdf.generaEvidencia("Validar recolección, Manifiesto", objAux.getDriver());
		objAux.getDriver().findElement(btnManifiesto).click();
		objAux.getDriver().findElement(btnNumeromanifiesto).sendKeys(numeromanifesto);
		objAux.AdminDocPdf.generaEvidencia("Numero Manifiesto", objAux.getDriver());
		objAux.getDriver().findElement(btnConsultar).click();
		objAux.getDriver().findElement(btnGuias).click();
		objAux.AdminDocPdf.generaEvidencia("Muestra de guia en lista", objAux.getDriver());
	}

	public void Notomarguias () throws InterruptedException {
		
		ArrayList<WebElement> checkBox = (ArrayList<WebElement>) objAux.getDriver()
				.findElements(btndesseleccion);
		
		ArrayList<WebElement> Numerodeguia = (ArrayList<WebElement>) 
					objAux.getDriver().findElements(btnGuiadesseleccion);
			Thread.sleep(6000);
			
			for (int i = 0; i < checkBox.size(); i++) {
				for (int j = 0; j < Numerodeguia.size(); j++) {

					if (Numerodeguia.get(j).getText().equals("9104986817")) {
						checkBox.get(i).click();
						break;
					}
					}
				}
			}
	
	public void clicNoRecoleccionUnificada () {
		objAux.getDriver().findElement(bntNorecoleccionUnificada).click();
	}
	
	
	
	public void clicSiguiete() {
		objAux.getDriver().findElement(btnSiguiente).click();
	}

	public void clicConfirmarrecoleccion() {
		objAux.getDriver().findElement(btnConfirmarrecoleccion).click();
	}

	public void clicAceptar() {
		objAux.getDriver().findElement(btnAceptar).click();
	}

	public void clicNorecoleccion() {
		objAux.getDriver().findElement(btnNorecoleccion).click();
	}

	public void clicSeleccione() {
		objAux.getDriver().findElement(BtnSelecccione).click();
	
	}
	
	public void clicMotivoNorecoleccion () {
		objAux.getDriver().findElement(txtMotivonorecolección).click();
	}
	
	public void SendtextObservacion (String Observacion){
		objAux.getDriver().findElement(textObservacion).sendKeys(Observacion);
		
	}
	
	public void SendtextObservacion1 (String Observacion1){
		objAux.getDriver().findElement(textObservacion).sendKeys(Observacion1);
		
	}
	
	
	public void evidencias () {
		objAux.getDriver().findElement(btnEvidencias).click();
	}
	
	
	
	
	public void clicConfirmarNorecoleccion() {
		objAux.getDriver().findElement(btnConfirmarnorecoleccion).click();
	}


	public void clicAtras() {
		objAux.getDriver().findElement(btnBack).click();
	}

	public void clicfirma() {
		objAux.getDriver().findElement(bntfirma).click();
	}


	public void Casosrecoleccion() throws IOException, InterruptedException {

		clikcliente();
		objAux.AdminDocPdf.generaEvidencia("Opción Recolección y No recolección, Validar recoleccion", objAux.getDriver());
		clicrecoleccion(objAux.obtenerValorProperties("numeromanifesto"));
		Notomarguias();
		clicSiguiete();
		objAux.AdminDocPdf.generaEvidencia("No recolección Unificada", objAux.getDriver());
		clicNoRecoleccionUnificada();
		clicSeleccione();
		objAux.AdminDocPdf.generaEvidencia("Motivo no recolección", objAux.getDriver());
		clicMotivoNorecoleccion();
		SendtextObservacion1(objAux.obtenerValorProperties("Observacion1"));
//		clicSiguiete();
		clicConfirmarNorecoleccion();
		clicSiguiete();
		evidencias();
		objAux.AdminDocPdf.generaEvidencia("Evidencias", objAux.getDriver());
		clicfirma();
		Thread.sleep(4000);
		objAux.AdminDocPdf.generaEvidencia("FirmaCliente", objAux.getDriver());
		Thread.sleep(3000);
		clicAtras();
		Thread.sleep(1000);
		clicAtras();
		objAux.AdminDocPdf.generaEvidencia("Confirmar Recolección", objAux.getDriver());
		clicConfirmarrecoleccion();
		objAux.AdminDocPdf.generaEvidencia("Aceptar", objAux.getDriver());
		clicAceptar();
		clikcliente();
		objAux.AdminDocPdf.generaEvidencia("No recolección", objAux.getDriver());
		clicNorecoleccion();
		clicSeleccione();
		objAux.AdminDocPdf.generaEvidencia("Lista de Causales de no recoleccion activas", objAux.getDriver());
		clicMotivoNorecoleccion();
		SendtextObservacion(objAux.obtenerValorProperties("Observacion"));
		objAux.AdminDocPdf.generaEvidencia("Detalle Observación", objAux.getDriver());
		clicConfirmarNorecoleccion();
		Thread.sleep(3000);
		objAux.AdminDocPdf.generaEvidencia("Aceptar", objAux.getDriver());
		clicAceptar();
		Thread.sleep(5000);
		objAux.AdminDocPdf.generaEvidencia("Clientes", objAux.getDriver());
		
	}

}
