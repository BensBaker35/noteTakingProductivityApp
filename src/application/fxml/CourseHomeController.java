package application.fxml;

import com.jfoenix.controls.JFXListView;

import application.Java.Course;
import application.Java.FileManager;
import application.Java.ICourseWork;
import application.Java.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;

public class CourseHomeController {
	
	@FXML
	private Label classNameLabel;
	
	@FXML
	private Label classInfoLabel;
	
	@FXML
	private JFXListView<Label> noteList;
	
	@FXML
	private JFXListView<Label> workList;		
	
	@FXML
	private SplitPane courseSplitPane;
	
	@FXML
	private Pane mainPane;
	
	Course courseData;
	
	@FXML
	private void initialize() {
		courseSplitPane.prefHeightProperty().bind(mainPane.heightProperty());
		courseSplitPane.prefWidthProperty().bind(mainPane.widthProperty());
		
		courseData = FileManager.readTransferCourse();
		
		classNameLabel.setText(courseData.getName());
		classInfoLabel.setText(courseData.toString());
		
		for(Note note: courseData.getCourseNotes()) {
			noteList.getItems().add(new Label(note.getSectionName()));
		}
		
		
		for(ICourseWork courseWork: courseData.getCourseWork()) {
			workList.getItems().add(new Label(courseWork.getName()));
		}
	}
	
	public void createNewNote() {
		//Change scene to the Note Creator
	}
	
	public void createNewCourseWork() {
		//Change Scene to the Course Work Creator
	}
}
