package co.uniquindio.programacion3.subasta.controller;

import co.uniquindio.programacion3.subasta.application.Aplicacion;
import co.uniquindio.programacion3.subasta.modell.Anuncio;
import co.uniquindio.programacion3.subasta.modell.Puja;
import co.uniquindio.programacion3.subasta.modell.Subasta;
import co.uniquindio.programacion3.subasta.modell.TipoProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductoController {

    private Aplicacion aplicacion;
    private Subasta subasta;
    ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<String, Anuncio> columNombre;

    @FXML
    private DatePicker fechaInicial;

    @FXML
    private Button btnSubirImagen;

    @FXML
    private DatePicker fechaFinal;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TableColumn<String, Anuncio> columDescripcion;

    @FXML
    private TableColumn<String, Anuncio> columPrecio;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecio;

    @FXML
    private ComboBox<?> cmbTipoProducto;

    @FXML
    private Button btnAtras;

    @FXML
    private Label imageFotoProducto;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiarAnuncio;

    @FXML
    private TableView<Anuncio> tablaAnuncios;

    @FXML
    private Label txtNombreAnunciante;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private Button btnModificar;

    /*
     * Metodo que permite limpiar los campos de texto en caso de tener texto
     */
    @FXML
    void btnlimpiarAnuncio(ActionEvent event) {

        txtNombreProducto.clear();
        txtDescripcion.clear();
        txtCodigo.clear();
        txtPrecio.clear();

        txtCodigo.setDisable(false);

    }

    /*
     * Metodo que permite actualizar un anuncio
     */
    @FXML
    void btnModificarAnuncio(ActionEvent event) {

        String nombreProducto = txtNombreProducto.getText();
        String descripcion = txtDescripcion.getText();
        String fechaPublicacion;
        String codigo = txtCodigo.getText();

        String valorInicial = txtPrecio.getText();

        TipoProducto tipoProducto;

        if (anuncioSeleccion != null) {
            if (datosValidos(nombreProducto, descripcion, fechaPublicacion, valorInicial, tipoProducto, codigo)) {

                anuncioSeleccion.setCodigo(codigo);
                anuncioSeleccion.setDescripcion(descripcion);
                anuncioSeleccion.setFechaPublicacion(fechaPublicacion);
                anuncioSeleccion.setNombreProducto(nombreProducto);
                anuncioSeleccion.setValorInicial(Double.parseDouble(valorInicial));

                tablaAnuncios.refresh();

                mostrarMensaje("Información", "Actualizar", "El anuncio ha sido actualizado.",
                        AlertType.CONFIRMATION);

            }

        } else {
            mostrarMensaje("Advertencia", "Actualizar", "No se ha seleccionado un anuncio.", AlertType.WARNING);

        }

    }

    /*
     * Metodo que permite agregar un Anuncio
     */
    @FXML
    void btnGuardarAnuncio(ActionEvent event) {

        String nombreProducto = txtNombreProducto.getText();
        String descripcion = txtDescripcion.getText();
        String nombreAnunciante;
        String fechaPublicacion =
        String valorInicial = this.txtPrecio.getText();
        TipoProducto tipoProducto;
        String codigo;

        try {
            if (condition) {

            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @FXML
    void btnSubirImagen(ActionEvent event) {

    }

    private double precioADouble(String valorInicial) {
        double precioAux = 0;

        try {
            precioAux = Double.parseDouble(valorInicial);
        } catch (Exception e) {

            mostrarMensaje("Advertencia", "La información del anuncio es invalida",
                    "Ingrese un valor numerico en el campo de precio", AlertType.WARNING);
        }
        return precioAux;
    }

    /*
     * Metodo para crear un anuncio
     */
    private void crearAnuncio(String nombreProducto, String descripcion, String fechaPublicacion,
            String valorInicial, TipoProducto tipoProducto, String codigo) throws IOException {

        double precioAux = precioADouble(valorInicial);

        Anuncio anuncio = modelFactoryController.crearAnuncio(nombreProdcuto, descripcion, fechaPublicacion,
                fechaFinalizacion, valorInicial, tipoProducto, codigo);

        // Notificar que el anuncio fue creado
        if (anuncio != null) {
            listadoAnuncios.add(0, anuncio);
            listadoAnuncios.add(anuncio);
            mostrarMensaje("Notificación anuncio", "Anuncio guardado",
                    "El anuncio " + anuncio.getNombreProducto() + " ha sido guardado", AlertType.INFORMATION);

        } else {
            mostrarMensaje("Notificación Anuncio", "Anuncio no guardado",
                    "El anuncio " + nombreProducto + " no ha sido guardado", AlertType.WARNING);

        }

    }

    /**
     * Este metodo muestra un mensaje al usuario
     *
     * @param titulo
     * @param header
     * @param contenido
     * @param alertType
     */
    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(contenido);
        alerta.showAndWait();

    }

    /*
     * Metodo que permite verificar si todos los campos de texto han sido
     * dilingeciados
     */
    private boolean datosValidos(String nombreProducto, String descripcion, String fechaPublicacion,
            String valorInicial,String fechaFinalizacion, TipoProducto tipoProducto, String codigo) {

        boolean flag = true;
        String notificacion = "";

        if (nombreProducto == null || nombreProducto.equals("")) {
            notificacion += "Nombre del producto no tiene información\n";

        }
        if (descripcion == null || descripcion.equals("")) {
            notificacion += "La descripción del producto no tiene información";

        }
        if (codigo == null || codigo.equals("")) {
            notificacion += "El codigo del producto no tiene información";

        }
        if (fechaPublicacion == null || fechaPublicacion.equals("")) {
            notificacion += "La fecha inicial del producto no tiene información";

        }
        
        if (fechaFinalizacion == null || fechaFinalizacion.equals("")) {
            notificacion += "La fecha de finalización producto no tiene información";

        }
        if (tipoProducto == null || tipoProducto.equals("")) {
            notificacion += "El tipo de producto no tiene información";

        }

        if (valorInicial.equals("")) {
            flag = false;
            notificacion += "El precio del producton o tiene información\n";

        }
        if (flag) {
            try {
                double valorInicial = Double.parseDouble(valorInicial);
            } catch (Exception e) {
                notificacion += "El precio debe de contener valores numericos";
            }

        }

        if (notificacion.equals("")) {
            return true;

        }

        mostrarMensaje("Advertencia", "Información del anuncio invalida", notificacion, AlertType.WARNING);
        return false;

    }

    @FXML
    void btnEliminarAnuncio(ActionEvent event) {

        if (anuncioSeleccion != null) {
            if (modelFactoryController.eliminarAnuncio(anuncioSeleccion.getCodigo())) {
                mostrarMensaje("Información", "Anuncio  eliminado", "El anuncio ha sido eliminado",
                        AlertType.ERROR);

            } else {
                mostrarMensaje("Información", "Anuncio selección", "No se ha seleccionado un anuncio",
                        AlertType.INFORMATION);
            }

            listadoAnuncios.remove(anuncioSeleccion);

        } else {
            mostrarMensaje("Advertencia", "Anuncio selección", "No se ha realizado la seleccion de un Anuncio",
                    AlertType.ERROR);

        }

    }

    /*
     * Metodo para regresar a la ventana del anunciante
     */
    @FXML
    void abrirVentanaAnunciante(ActionEvent event) {
        aplicacion.ventanaPrincipalAnunciante();
    }

    // ---------------------TABLA-------------------------

    ObservableList<Anuncio> listadoAnuncios = FXCollections.observableArrayList();

    private Anuncio anuncioSeleccion;

    private void mostrarInformacion() {

        if (anuncioSeleccion != null) {

            txtNombreProducto.setText(anuncioSeleccion.getNombreProducto());

        }

    }

    public void actualizarTabla() {
        tablaAnuncios.getItems().clear();
        listadoAnuncios.clear();
        listadoAnuncios.addAll(modelFactoryController.getListaAnuncios());
        tablaAnuncios.refresh();
    }

    @FXML
    void initialize() {

        this.columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.columPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaAnuncios.getSelectionModel().selectedItemProperty()
                .addListener((obs, olSelection, newSelection) -> {

                    if (newSelection != null) {
                        anuncioSeleccion = newSelection;
                        mostrarInformacion();
                    }

                });
    }

    public void setAplicacion(Aplicacion aplicacion) {

        this.aplicacion = aplicacion;
        this.modelFactoryController = aplicacion.getModelFactoryController();

        tablaAnuncios.getItems().clear();
        tablaAnuncios.setItems(getAnuncios());
    }

    private ObservableList<Anuncio> getAnuncios() {
        listadoAnuncios.addAll(modelFactoryController.getListaAnuncios());
        return listadoAnuncios;
    }

    public void setAplicacion(ModelFactoryController modelFactoryController) {

    }

}
