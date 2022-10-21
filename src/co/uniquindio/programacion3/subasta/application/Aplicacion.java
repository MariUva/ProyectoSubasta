package co.uniquindio.programacion3.subasta.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Aplicacion extends Application {
	@Override
	public void start(Stage primaryStage) {

	}

	public void ventanaPrincipal() {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class
					.getResource("RUTA"));

			AnchorPane anchorPane = (AnchorPane) loader.load();
//			principalControlador controlador = loader.getController();
//			controlador.setAplicacion(this);
//
//			Scene scene = new Scene(anchorPane);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//			primaryStage.setTitle("COLEGIO - ESTUDIANTES");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
