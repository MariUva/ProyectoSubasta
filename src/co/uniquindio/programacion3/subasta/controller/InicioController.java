package co.uniquindio.programacion3.subasta.controller;

import java.net.URL;
import java.util.ResourceBundle;
import co.uniquindio.programacion3.subasta.application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController {

	private Aplicacion aplicacion;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAnunciante;

	@FXML
	private Button btnComprador;

<<<<<<< HEAD
    @FXML
    void abrirPrincipalAnunciante(ActionEvent event) {
    	aplicacion.ventanaPrincipalAnunciante();
    }

    @FXML
    void abrirPrincipalComprador(ActionEvent event) {
    	aplicacion.ventanaPrincipalComprador();
    }
=======
	@FXML
	void abrirLogin(ActionEvent event) {
		aplicacion.ventanaLogin();
	}

	@FXML
	void initialize() {
>>>>>>> aa609470ef03d550892fd318f96be072b871e8bd

	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
}
