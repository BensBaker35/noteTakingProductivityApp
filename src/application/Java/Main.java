package application.Java;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	protected static Stage mainStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			mainStage = primaryStage;
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/application/fxml/HomeScreen.fxml"));
			Scene scene2 = new Scene(myPane);
			scene2.getStylesheets().add(getClass().getResource("/application/css/main.css").toExternalForm());
			mainStage.setScene(scene2);
			mainStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public static void changeScene(Scene scene) {
		mainStage.setScene(scene);
		mainStage.show();
	}
}
