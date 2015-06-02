package com.mutual.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

public class ControladorAeropuertoArgentina {
	@FXML
	private WebView webView;

	@FXML
	private Button buttonHome;

	@FXML
	private ImageView imageHome;

	

	public Button getButtonHome() {
		return buttonHome;
	}

	public void setButtonHome(Button buttonHome) {
		this.buttonHome = buttonHome;
	}

	public ImageView getImageHome() {
		return imageHome;
	}

	public void setImageHome(ImageView imageHome) {
		this.imageHome = imageHome;
	}

	public WebView getWebView() {
		return webView;
	}

	public void setWebView(WebView webView) {
		this.webView = webView;
	}



	@FXML
	void recargar(ActionEvent event) {
		webView.getEngine().load("http://www.aa2000.com.ar/");
		;
	}

}
