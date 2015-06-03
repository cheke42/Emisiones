package com.mutual.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ControladorAeropuertoArgentina {
    @FXML
    private WebView webView;

    @FXML
    private Button buttonHome;

    @FXML
    private ImageView imageHome;

    private Stage escenario;

    public Stage getEscenario() {
	return escenario;
    }

    public void setEscenario(Stage escenario) {
	this.escenario = escenario;
    }

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
    private void initialize() {

	webView.getEngine().load("http://www.aa2000.com.ar/");
	webView.getEngine().setUserStyleSheetLocation(
		"file:recursos/estilos/estilos.css");
	imageHome.setImage(new Image("file:recursos/imagenes/home.png"));
	
    }

    @FXML
    void recargar(ActionEvent event) {
	webView.getEngine().load("http://www.aa2000.com.ar/");
	;
    }

}
