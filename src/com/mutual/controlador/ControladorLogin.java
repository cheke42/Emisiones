package com.mutual.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

import com.mutual.modelo.Sistema;
import com.mutual.principal.Principal;

public class ControladorLogin {

	@FXML
	private WebView webView;

	@FXML
	private ImageView imageLogin;

	@FXML
	private Button buttonLimpear;

	@FXML
	private Button buttonIngresar;

	@FXML
	private PasswordField fieldPassword;

	@FXML
	private Label labelError;

	@FXML
	private TextField fieldUsuario;

	private Principal principal;

	public WebView getWebView() {
		return webView;
	}

	public void setWebView(WebView webView) {
		this.webView = webView;
	}

	public ImageView getImageLogin() {
		return imageLogin;
	}

	public void setImageLogin(ImageView imageLogin) {
		this.imageLogin = imageLogin;
	}

	public Button getButtonLimpear() {
		return buttonLimpear;
	}

	public void setButtonLimpear(Button buttonLimpear) {
		this.buttonLimpear = buttonLimpear;
	}

	public Button getButtonIngresar() {
		return buttonIngresar;
	}

	public void setButtonIngresar(Button buttonIngresar) {
		this.buttonIngresar = buttonIngresar;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public PasswordField getFieldPassword() {
		return fieldPassword;
	}

	public void setFieldPassword(PasswordField fieldPassword) {
		this.fieldPassword = fieldPassword;
	}

	public TextField getFieldUsuario() {
		return fieldUsuario;
	}

	// Eventos
	public void setFieldUsuario(TextField fieldUsuario) {
		this.fieldUsuario = fieldUsuario;
	}

	@FXML
	void ingresar(ActionEvent event) throws Exception {
		if (Sistema.getSistema().loginCorrecto(fieldUsuario.getText(),
				fieldPassword.getText())) {
			principal.setUsuarioActivo(Sistema.getSistema().buscarUsuario(
					fieldUsuario.getText()));
			principal.cargarVentanaPantallaPrincipal();
		} else {
			labelError.setVisible(true);
			fieldPassword.clear();
			fieldUsuario.requestFocus();
		}

	}

	@FXML
	void limpear(ActionEvent event) {
		fieldPassword.clear();
		fieldUsuario.clear();
		fieldUsuario.requestFocus();
		labelError.setVisible(false);
	}
}
