package greenMobile.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import control.elementos.ObjetosConfigAux;

public class Login {

	ObjetosConfigAux objAux;

	// CREACION DE ELEMTOS

	By txtUsuario = By.id("txt_usuario");
	By txtContrasenia = By.id("txt_contrasena");
	By btnIngresar = By.id("btn_ingresar");

	// CREACION CONSTRUCTOR
	public Login(ObjetosConfigAux objAux) {
		this.objAux = objAux;
	}

	// CREACION EVENTOS

	public void setTxtUsuario(String pUser) {

		objAux.getDriver().findElement(txtUsuario).sendKeys(pUser);
	}

	public void setTxtPassword(String pPassword) {

		objAux.getDriver().findElement(txtContrasenia).sendKeys(pPassword);
	}

	public void clicBtnIngresar() {

		objAux.getDriver().findElement(btnIngresar).click();
	}

	// CREACION METODOS

	public void ingresarLogin() throws IOException, InterruptedException {

		setTxtUsuario(objAux.obtenerValorProperties("Usuario"));
		objAux.AdminDocPdf.generaEvidencia("Validar Usuario", objAux.getDriver());
		setTxtPassword(objAux.obtenerValorProperties("Password"));
		objAux.AdminDocPdf.generaEvidencia("Validar Contraseña", objAux.getDriver());
		clicBtnIngresar();
		Thread.sleep(3000);
		objAux.AdminDocPdf.generaEvidencia("Validar ingreso", objAux.getDriver());
	}
}
