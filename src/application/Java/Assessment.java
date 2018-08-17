package application.Java;

import java.util.Date;
import java.util.List;

public class Assessment implements ICourseWork {
	
	String name;
	Date dateDue;
	Course course;
	AssessmentType assessmentType;
	List<Note> sectionsCovered;
	
	public Assessment(String name, Date dateDue, Course course, AssessmentType type, List<Note> sections) {
		this.name = name;
		this.dateDue = dateDue;
		this.course = course;
		this.assessmentType = type;
		this.sectionsCovered = sections;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Date getDueDate() {
		return dateDue;
	}

	@Override
	public Course getCourse() {
		return course;
	}
	
	public AssessmentType getAssessmentType() {
		return assessmentType;
	}
	public List<Note> getSectionsCovered(){
		return sectionsCovered;
	}
}
