package greenMobile.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.lowagie.text.DocumentException;

import control.elementos.ObjetosConfigAux;
import evidencia.doc.pdf.AdminDocPdf;
import greenMobile.pages.Login;
import greenMobile.pages.HomePages;
import greenMobile.pages.DetalleRecoleccion;
import greenMobile.pages.ListaRecoleccion;
import model.Ambientes;
import model.DispositivoPrueba;
import model.Estados;
import model.Navegadores;

public class Ejecucion {

	ObjetosConfigAux objAux;
	Login objLogin;
	HomePages objSiguiente;
	ListaRecoleccion objlistaRecoleccion;
	DetalleRecoleccion objDetalleRecoleccion;
	
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException {

		objAux = new ObjetosConfigAux("R58M73RV0RY", false);
		objLogin = new Login(objAux);
		objSiguiente = new HomePages(objAux);
		objlistaRecoleccion = new ListaRecoleccion(objAux);
		objDetalleRecoleccion = new DetalleRecoleccion(objAux);
		
	}

	@Test
	public void ingresarLogin() throws IOException, InterruptedException {

		objAux.AdminDocPdf = new AdminDocPdf(Ambientes.NA, Navegadores.ANDROID, DispositivoPrueba.Movil);
		objLogin.ingresarLogin();
		objSiguiente.flecha();
		objlistaRecoleccion.Listarecoleccion();
		objDetalleRecoleccion.Casosrecoleccion();
		
	}

	
	@AfterMethod
	public void finalizeTest(ITestResult t) throws MalformedURLException, DocumentException, IOException {
		if (t.getStatus() == ITestResult.SUCCESS)
			objAux.AdminDocPdf.crearDocumento(Estados.SUCCESS);
		else {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			Throwable cause = t.getThrowable();
			if (null != cause) {
				cause.printStackTrace(pw);
				objAux.AdminDocPdf.generaEvidencia("Resultado NO Esperado: ",
						Shutterbug.shootPage(objAux.getDriver()).getImage());
			} else {
				objAux.AdminDocPdf.generaEvidencia("Resultado NO Esperado: ",
						Shutterbug.shootPage(objAux.getDriver()).getImage());
			}
			objAux.AdminDocPdf.crearDocumento(Estados.FAILED);
		}
	}

	@AfterClass
	public void exit() {

		 objAux.getDriver().quit();
	}

}
