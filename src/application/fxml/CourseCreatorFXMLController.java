package application.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTimePicker;

import application.Java.Course;
import application.Java.CourseSchedule;
import application.Java.CourseType;
import application.Java.Days;
import application.Java.FileManager;
import application.Java.Main;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

//import application.java.FileManager;

public class CourseCreatorFXMLController 
{
	@FXML
	private Group cNamecTeachercType;
	@FXML
	private Group cSchedule;
	@FXML
	private TextField inputText_CourseTeacher;
	@FXML
	private TextField inputText_CourseName;
	@FXML
	private URL location;
	@FXML
	private ResourceBundle resources;
	@FXML
	private JFXListView<Label> listView_CourseType;
	@FXML
	private JFXButton submitButton;
	@FXML
	private JFXTimePicker startTimePicker;
	@FXML
	private JFXTimePicker endTimePicker;
	@FXML 
	private JFXRadioButton radio_Monday;
	@FXML 
	private JFXRadioButton radio_Tuesday;
	@FXML 
	private JFXRadioButton radio_Wedensday;
	@FXML 
	private JFXRadioButton radio_Thursday;
	@FXML 
	private JFXRadioButton radio_Friday;
	@FXML 
	private JFXRadioButton radio_Saturday;
	@FXML 
	private JFXRadioButton radio_Sunday;
	private JFXRadioButton[] radioButtonArray = new JFXRadioButton[7];
	private String[] courseInfoTempArr = new String[3];
	
	// Add a public no-args constructor
	public CourseCreatorFXMLController() 
	{
	}
	
	@FXML
	private void initialize() 
	{ 
		
		cNamecTeachercType.setVisible(true);
		cSchedule.setVisible(false);
		
		initializeRadioButtonArray();
		
		BooleanBinding courseNameValid = Bindings.createBooleanBinding(() -> {
			 if(inputText_CourseName.getText().length() > 1) {
			    	return true;
			    }
			    else {
			    	return false;
			    }
		}, inputText_CourseName.textProperty());

		BooleanBinding courseTeacherValid = Bindings.createBooleanBinding(() -> {
		    if(inputText_CourseTeacher.getText().length() > 1) {
		    	return true;
		    }
		    else {
		    	return false;
		    }
		}, inputText_CourseTeacher.textProperty());
		
		
		
		//listView_CourseType = new JFXListView<>();
		System.out.println(listView_CourseType);
		for(CourseType ct : CourseType.values()) {
			listView_CourseType.getItems().add(new Label(ct.toString()));
		}
		listView_CourseType.setId("listView_CourseType");
		System.out.println(submitButton);
		submitButton.disableProperty().bind(courseNameValid.not().or(courseTeacherValid.not()));
	}

	private void initializeRadioButtonArray() {
		radioButtonArray[0] = radio_Monday;
		radioButtonArray[1] = radio_Tuesday;
		radioButtonArray[2] = radio_Wedensday;
		radioButtonArray[3] = radio_Thursday;
		radioButtonArray[4] = radio_Friday;
		radioButtonArray[5] = radio_Saturday;
		radioButtonArray[6] = radio_Sunday;
	}
	

	private void initializeScheduleList() {
		
	}
	
	public void GetSelectedInformation() {
		String CourseName = inputText_CourseName.getText();
		String courseTeacher = inputText_CourseTeacher.getText();
		String courseType = listView_CourseType.selectionModelProperty().get().getSelectedItem().getText();
		//Show next screen that has the ability to create the schedule
		courseInfoTempArr[0] = CourseName;
		courseInfoTempArr[1] = courseTeacher;
		courseInfoTempArr[2] = courseType;
		cNamecTeachercType.setVisible(false);
		cSchedule.setVisible(true);
		
	}
	
	public void GetScheduleInfo() {
		ArrayList<Days> selectedDays = new ArrayList<Days>();
		
		for(JFXRadioButton day: radioButtonArray) {
			if(day.isSelected()) {
				selectedDays.add(CourseSchedule.convertToDays(day.getText()));
			}
		}
		
		String endTimeStr = endTimePicker.getValue().toString();
		String startTimeStr = startTimePicker.getValue().toString();
		System.out.println(endTimeStr);
		System.out.println(startTimeStr);
		
		CourseSchedule courseSchedule = new CourseSchedule(selectedDays,startTimeStr,endTimeStr);
		
		Course course = new Course(courseSchedule,courseInfoTempArr[1],courseInfoTempArr[0],
				Course.GetSelectedCourse(courseInfoTempArr[2]));
		FileManager.saveCourseData(course);

		changeToMainScene();
	}

	private void changeToMainScene(){
		
		try {
			Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/application/fxml/HomeScreen.fxml"));
			Scene mainScene = new Scene(myPane);
			
			Main.changeScene(mainScene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}