package co.uniquindio.programacion3.subasta.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import co.uniquindio.programacion3.subasta.application.Aplicacion;
import co.uniquindio.programacion3.subasta.modell.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

    private Aplicacion aplicacion;

    private Persona usuarioEncontrado;

    String usuario;
    String contrasenia;
    String tipoUsuario;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private Button btnAtras;

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<String> btnTipoUsuario;

    ObservableList<String> options = FXCollections.observableArrayList("Anunciante", "Comprador");

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegistrarse;

    @FXML
    void initialize() {
        String[] tipoDeUsuario = { "Anunciante", "Comprador", "ADMIN" };
        btnTipoUsuario.getItems().clear();
        btnTipoUsuario.getItems().addAll(tipoDeUsuario);
        ModelFactoryController.crearPersona("154789854", "DANI", "123", 18, "ADMIN");
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void seleccionarTipoUsuario(ActionEvent event) {

    }

    @FXML
    void abrirVentanaRegistrarse(ActionEvent event) {
        aplicacion.ventanaRegistroLogin();
    }

    @FXML
    void abrirVentanaInicio(ActionEvent event) {
        aplicacion.ventanaPrincipal();
    }

    @FXML
    void abrirVentanaIngresar(ActionEvent event) {

        cargarDatos();
        buscarUsuario();

        if (verificarDatos(usuarioEncontrado)) {

            if (!usuarioEncontrado.getClave().equals(null)) {

                if (usuario.equals(usuarioEncontrado.getNombre()) && contrasenia.equals(usuarioEncontrado.getClave()) &&
                        tipoUsuario.equals(usuarioEncontrado.getTipoDeUsuario())) {
                    aplicacion.mostrarMensaje(null, "Hola, " + usuario + "!", "Acceso confirmado",
                            AlertType.CONFIRMATION);

                    if (tipoUsuario.equals("ADMIN")) {
                        aplicacion.ventanaAdmin();
                    }

                    if (tipoUsuario.equals("Anunciante")) {
                        aplicacion.ventanaPrincipalAnunciante();
                    }

                    if (tipoUsuario.equals("Comprador")) {
                        aplicacion.ventanaPrincipalComprador();
                    }

                } else {
                    aplicacion.mostrarMensaje(null, "Datos incorrectos",
                            "El usuario, la contrase�a o el tipo es incorrecto",
                            AlertType.ERROR);
                }

            } else {
                aplicacion.mostrarMensaje(null, "'" + usuario + "'" + ", no existe",
                        "El usuario que ingreso no existe, verifique los datos "
                                + "ó haga un registro nuevo.",
                        AlertType.ERROR);
                limpiar();
            }
        }
    }

    private void cargarDatos() {

        usuario = txtNombre.getText();
        contrasenia = String.valueOf(txtContrasenia.getText());
        tipoUsuario = btnTipoUsuario.getValue();

    }

    private void buscarUsuario() {
        usuarioEncontrado = ModelFactoryController.buscarPersona(usuario);
    }

    private boolean existeUsuario() {

        if (ModelFactoryController.existeUsuario(usuario)) {
            return true;
        }
        return false;

    }

    private boolean verificarDatos(Persona usuarioEncontrado) {

        String notificacion = "";

        if (usuario == null || usuario.equals("") ||
                contrasenia == null || contrasenia.equals("") ||
                tipoUsuario == null || tipoUsuario.equals("")) {

            if (usuario == null || usuario.equals("")) {
                notificacion += "Debe ingresar un usuario\n";
            }

            if (contrasenia == null || contrasenia.equals("")) {
                notificacion += "Debe ingresar una contraseña\n";
            }

            if (tipoUsuario == null || tipoUsuario.equals("")) {
                notificacion += "Debe ingresar el tipo de usuario\n";
            }

            aplicacion.mostrarMensaje(null, "Informacion incorrecta", notificacion, AlertType.ERROR);

            return false;

        }

        if (usuarioEncontrado != null) {
            return true;
        }

        return false;

    }

    private void limpiar() {
        txtNombre.setText(null);
        txtContrasenia.setText(null);
    }

}
