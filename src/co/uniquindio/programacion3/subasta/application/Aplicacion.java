package co.uniquindio.programacion3.subasta.application;

import java.io.IOException;

import co.uniquindio.programacion3.subasta.controller.AdminController;
import co.uniquindio.programacion3.subasta.controller.InicioController;
import co.uniquindio.programacion3.subasta.controller.LoginController;
import co.uniquindio.programacion3.subasta.controller.ModelFactoryController;
import co.uniquindio.programacion3.subasta.controller.PrincipalAnuncianteController;
import co.uniquindio.programacion3.subasta.controller.PrincipalCompradorController;
import co.uniquindio.programacion3.subasta.controller.ProductoController;
import co.uniquindio.programacion3.subasta.controller.RegistroLoginController;
import co.uniquindio.programacion3.subasta.modell.Subasta;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Aplicacion extends Application {

	private Stage primaryStage;
	private Subasta subasta;
	private ModelFactoryController modelFactoryController;

    @Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.modelFactoryController = modelFactoryController;
//		this.primaryStage.setTitle("Las puajs de San Victorino");
		ventanaPrincipal();

	}

	public void ventanaPrincipal() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/programacion3/subasta/view/Inicio.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			InicioController controlador = loader.getController();
			controlador.setAplicacion(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.getIcons().add(new Image("/co/uniquindio/programacion3/subasta/images/LOGO.png"));
			primaryStage.centerOnScreen();
//			primaryStage.setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void ventanaPrincipalComprador() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Aplicacion.class.getResource("/co/uniquindio/programacion3/subasta/view/PrincipalComprador.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			PrincipalCompradorController controlador = loader.getController();
			controlador.setAplicacion(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.getIcons().add(new Image("/co/uniquindio/programacion3/subasta/images/LOGO.png"));
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);


		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void ventanaPrincipalAnunciante() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Aplicacion.class.getResource("/co/uniquindio/programacion3/subasta/view/PrincipalAnunciante.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			PrincipalAnuncianteController controlador = loader.getController();
			controlador.setAplicacion(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.getIcons().add(new Image("/co/uniquindio/programacion3/subasta/images/LOGO.png"));
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void ventanaProducto() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/programacion3/subasta/view/Producto.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			ProductoController controlador = loader.getController();
			controlador.setAplicacion(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.getIcons().add(new Image("/co/uniquindio/programacion3/subasta/images/LOGO.png"));
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void ventanaLogin() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/programacion3/subasta/view/Login.fxml"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
			LoginController controlador = loader.getController();
			controlador.setAplicacion(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.getIcons().add(new Image("/co/uniquindio/programacion3/subasta/images/LOGO.png"));
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	   public void ventanaRegistroLogin() {

	        try {

	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/programacion3/subasta/view/RegistroLogin.fxml"));

	            AnchorPane anchorPane = (AnchorPane) loader.load();
	            RegistroLoginController controlador = loader.getController();
	            controlador.setAplicacion(this);

	            Scene scene = new Scene(anchorPane);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	            primaryStage.getIcons().add(new Image("/co/uniquindio/programacion3/subasta/images/LOGO.png"));
	            primaryStage.centerOnScreen();
//	            primaryStage.setResizable(false);

	        } catch (Exception e) {
	            e.printStackTrace();

	        }
	    }

       public void ventanaAdmin() {

           try {

               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/programacion3/subasta/view/Admin.fxml"));

               AnchorPane anchorPane = (AnchorPane) loader.load();
               AdminController controlador = loader.getController();
               controlador.setAplicacion(this);

               Scene scene = new Scene(anchorPane);
               primaryStage.setScene(scene);
               primaryStage.show();
               primaryStage.getIcons().add(new Image("/co/uniquindio/programacion3/subasta/images/LOGO.png"));
               primaryStage.centerOnScreen();
//             primaryStage.setResizable(false);

           } catch (Exception e) {
               e.printStackTrace();

           }
       }

	    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

	        Alert alerta = new Alert(alertType);
	        alerta.setTitle(titulo);
	        alerta.setHeaderText(header);
	        alerta.setContentText(contenido);
	        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/co/uniquindio/programacion3/subasta/images/LOGO.png"));
	        alerta.showAndWait();

	    }

	    public Subasta getSubasta() {
	        return subasta;
	    }

	    public void setSubasta(Subasta subasta) {
	        this.subasta = subasta;
	    }

	public static void main(String[] args) {
		launch(args);
	}

}
