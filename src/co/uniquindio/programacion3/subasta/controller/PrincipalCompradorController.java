package co.uniquindio.programacion3.subasta.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.programacion3.subasta.application.Aplicacion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrincipalCompradorController {

	private Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSalir;

    @FXML
    private TextField txtBuscarProducto;

    @FXML
    private Button btnMisPujas;

    @FXML
    private TableView<?> tablaComprador;

    @FXML
    private Button btnMisCompras;

    @FXML
    private Button btnOfrecer;

    @FXML
    void initialize() {

    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
}
