package co.uniquindio.programacion3.subasta.controller;
import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.programacion3.subasta.application.Aplicacion;
import co.uniquindio.programacion3.subasta.modell.Persona;
import co.uniquindio.programacion3.subasta.modell.Subasta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable{

    private Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private TableView<Persona> tablaAdmin;

    public ObservableList<Persona> listaUsuarios;

    @FXML
    private TableColumn<Persona, String> columnaTipo;

    @FXML
    private TableColumn<Persona, String> columnaUsuario;

    @FXML
    private TableColumn<Persona, String> columnaContrasenia;

    private Subasta subasta;

    @FXML
    void abrirVentanaLogin(ActionEvent event) {
        aplicacion.ventanaLogin();
    }

    @FXML
    void initialize() {

    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        this.subasta = aplicacion.getSubasta();

        getTabla().getItems().clear();
//        getTabla().setItems(getPersonas());

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        listaUsuarios = FXCollections.observableArrayList();
        this.tablaAdmin.setItems(listaUsuarios);

        this.columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipoDeUsuario"));
        this.columnaUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnaContrasenia.setCellValueFactory(new PropertyValueFactory<>("clave"));

    }

    private ObservableList<Persona> getPersonas() {

        listaUsuarios.addAll(subasta.getListaPersonas());
        return listaUsuarios;
    }

    public TableView<Persona> getTabla() {
        return tablaAdmin;
    }

    public void setTabla(TableView<Persona> tabla) {
        this.tablaAdmin = tabla;
    }
}
