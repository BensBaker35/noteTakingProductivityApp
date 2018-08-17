package application.fxml;

import java.io.File;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;

import application.Java.Course;
import application.Java.FileManager;
import application.Java.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class HomeScreenFXMLController {
	@FXML
	private Pane mainPane;
	@FXML
	private SplitPane mainSplitPane;
	@FXML
	private AnchorPane coursePane;
	@FXML
	private AnchorPane schedulePane;
	@FXML
	private AnchorPane upcomingPane;
	@FXML
	private JFXListView listView_schedule;
	
	@FXML
	private HBox buttonDisplay;
	
	@FXML
	private StackPane dialogPane;
	
	public HomeScreenFXMLController() 
	{
	}
	
	@FXML
	private void initialize() {
		
		bindSplitPane();
		
		dialogPane.setVisible(false);
		
		File[] courses = FileManager.getAllCourses();
		for(File courseFile : courses) {
			
			Course c = FileManager.readCourse(courseFile);
			System.out.println(c.getName());
			JFXButton courseButton = new JFXButton(c.getName());
		
			courseButton.setOnMouseClicked(e -> {
			
				//Create a new Template FXML that reads from a written file
				FileManager.saveTransferCourse(c);
				
				
				try {
					Pane pane = FXMLLoader.load(getClass().getResource("/application/fxml/CourseHome.fxml"));
					Scene scene = new Scene(pane);
					Main.changeScene(scene);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				/*
				JFXDialogLayout dl = new JFXDialogLayout();
				
				
				JFXDialog dialog = new JFXDialog(dialogPane, dl, JFXDialog.DialogTransition.CENTER);
				
				JFXButton closeButton = new JFXButton("Close");
				Label courseLabel = new Label(c.toString());
				courseLabel.setStyle("-fx-font-size: 10");
				
				dl.setHeading(new Label(c.getName()));
				dl.setBody(new VBox(courseLabel , closeButton));
				
				closeButton.setOnMouseClicked(e2 ->{dialog.close();});
				
				
				dialogPane.setVisible(true);
				dialog.show();
				
				
				
				
				*/
			});
			buttonDisplay.getChildren().add(courseButton);
		}
		
	}

	private void bindSplitPane() {
		mainSplitPane.prefHeightProperty().bind(mainPane.heightProperty());
		mainSplitPane.prefWidthProperty().bind(mainPane.widthProperty());
	}
	
	
	public void createNewCourse() {
		//Switch to Create Course FXML Set
		try {
			
			mainPane.setPrefHeight(mainPane.getHeight());
			mainPane.setPrefWidth(mainPane.getWidth());
			Pane scenePane = FXMLLoader.load(getClass().getResource("/application/fxml/CourseCreator.fxml"));
			Scene test = new Scene(scenePane);
			Main.changeScene(test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
