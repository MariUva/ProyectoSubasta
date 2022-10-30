package co.uniquindio.programacion3.subasta.controller;

import co.uniquindio.programacion3.subasta.application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ProductoController {

	private Aplicacion aplicacion;


    @FXML
    void abrirVentanaAnunciante(ActionEvent event) {
    	aplicacion.ventanaPrincipalAnunciante();
    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}
