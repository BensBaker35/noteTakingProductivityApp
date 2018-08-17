package application.fxml;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import application.Java.Course;
import application.Java.FileManager;
import application.Java.Note;
import javafx.fxml.FXML;
import javafx.scene.Group;

public class NoteCreatorFXMLController {
	
	@FXML
	private JFXButton submitButton;
	
	@FXML 
	private Group noteGroup;
	
	@FXML 
	private JFXTextField input_sectionName;
	
	@FXML
	private JFXTextField input_UnitNumber;
	
	@FXML
	private JFXDatePicker dayPicker;
	
	private Course courseData;
	
	public NoteCreatorFXMLController() {}
	
	
	@FXML
	private void initialize() {
		courseData = FileManager.readTransferCourse();
	}
	
	public void createNewNote() {
		int unitNumber = Integer.parseInt(input_UnitNumber.getText());
		Note note = new Note(courseData,input_sectionName.getText(),unitNumber,dayPicker.getValue());
		courseData.addNewNote(note);
	}
}
