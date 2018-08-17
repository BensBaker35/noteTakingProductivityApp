package application.Java;

import java.time.LocalDate;
import java.util.Date;

public class Note {
	
	private String sectionName;
	private int unitNumber;
	private LocalDate date;
	private Course course;
	private String courseNotes;
	
	public Note(Course course, String sectionName, int unitNumber, LocalDate date) {
		this.course = course;
		this.sectionName = sectionName;
		this.unitNumber = unitNumber;
		this.date = date;
	}
	
	public String getSectionName() {
		return sectionName;
	}

	public int getUnitNumber() {
		return unitNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public Course getCourse() {
		return course;
	}

	public String getCourseNotes() {
		return courseNotes;
	}
	
	public void setCourseNotes(String courseNotes) {
		this.courseNotes = courseNotes;
	}
}
