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

	@FXML
	void abrirLogin(ActionEvent event) {
		aplicacion.ventanaLogin();
	}

	@FXML
	void initialize() {

	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
}
