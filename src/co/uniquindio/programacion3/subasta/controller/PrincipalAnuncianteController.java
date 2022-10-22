package co.uniquindio.programacion3.subasta.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.programacion3.subasta.application.Aplicacion;
import co.uniquindio.programacion3.subasta.modell.Anuncio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrincipalAnuncianteController {

	private Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnMisVentas;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnCrearAnuncio;

    @FXML
    private TableView<Anuncio> tablaProductosAnunciante;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnProductosPuja;

    @FXML
    private Button btnCrearProducto;

    @FXML
    void ventanaInicio(ActionEvent event) {

    }

    @FXML
    void ventanaCrearAnuncio(ActionEvent event) {

    }

    @FXML
    void ventanaCrearProducto(ActionEvent event) {

    }

    @FXML
    void ventanaProductosPuja(ActionEvent event) {

    }

    @FXML
    void ventanaMisVentas(ActionEvent event) {

    }

    @FXML
    void initialize() {


    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
}
