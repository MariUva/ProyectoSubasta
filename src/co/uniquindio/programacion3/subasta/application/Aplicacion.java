package co.uniquindio.programacion3.subasta.application;

import java.io.IOException;

import co.uniquindio.programacion3.subasta.controller.InicioController;
import co.uniquindio.programacion3.subasta.controller.PrincipalAnuncianteController;
import co.uniquindio.programacion3.subasta.controller.PrincipalCompradorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Aplicacion extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

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

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
