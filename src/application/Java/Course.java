package application.Java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3725294232997681389L;
	
	private List<Note> courseNotes;
	private CourseSchedule courseSchedule;
	private String teacher;
	private String name;
	private CourseType courseType;
	private List<ICourseWork> courseWork;
	
	public Course(CourseSchedule courseSchedule, String teacher, String name,
			CourseType courseType) {
		this.courseNotes = new ArrayList<Note>();
		this.courseSchedule = courseSchedule;
		this.teacher = teacher;
		this.name = name;
		this.courseType = courseType;
		this.courseWork = new ArrayList<ICourseWork>();
	}
	
	public List<Note> getCourseNotes() {
		return courseNotes;
	}

	public CourseSchedule getCourseSchedule() {
		return courseSchedule;
	}

	public String getTeacher() {
		return teacher;
	}

	public String getName() {
		return name;
	}

	public CourseType getCourseType() {
		return courseType;
	}
	public void addNewNote(Note note) {
		courseNotes.add(note);
	}
	
	public void addNewCourseWork(ICourseWork cw) {
		
	}
	
	public List<ICourseWork> getCourseWork() {
		return courseWork;
	}
	
public static  CourseType GetSelectedCourse(String courseString) {
		
		switch(courseString) {
		case "PE":
			return CourseType.PE;
			
		case "MATH":
			return CourseType.MATH;
			
		case "Science":
			return CourseType.SCIENCE;

		case "SOCIALSTUDIES":
			return CourseType.SOCIALSTUDIES;
		
		case "BUSINESS":
			return CourseType.BUSINESS;
			
		case "ART":
			return CourseType.ART;
			
		case "MUSIC":
			return CourseType.MUSIC;
			
		case "FORIEGNLANGUAGE":
			return CourseType.FORIEGNLANGUAGE;
			
		case "ENGINEERING":
			return CourseType.ENGINEERING;
			
		case "LANGUAGEARTS":
			return CourseType.LANGUAGEARTS;
			
			default:
				return CourseType.ART;
		}
	}
	public String toString() {
		return this.name + " "
				+ "is taught by " + this.teacher + ", The Class is a " 
				+ this.courseType + " class and runs from " + this.courseSchedule.getStartTime() 
				+ " to " + this.courseSchedule.getEndTime();
	}
}
