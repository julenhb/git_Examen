package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	 private static Scene scene;

	    @Override
	    public void start(Stage stage) throws IOException {
	        scene = new Scene(loadFXML("Principal"), 640, 480);
	        stage.setScene(scene);
	        stage.show();
	    }

	    static void setRoot(String fxml) throws IOException {
	        scene.setRoot(loadFXML(fxml));
	    }

	    private static Parent loadFXML(String fxml) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
	        return fxmlLoader.load();
	    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
